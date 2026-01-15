package org.example.zadaniedomowe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceIntegrationTest {

    @MockitoBean
    private Storage storage;

    @Autowired
    private Service service;

    @Test
    void testZmianyStatusu() {
        // GIVEN: Przygotowujemy obiekt i mówimy mockowi, żeby go zwrócił
        Zgloszenie zgloszenie = new Zgloszenie(LocalDate.now(), Status.W_trakcie, 1, 1, 10);
        when(storage.getZgloszeniePoId(10)).thenReturn(zgloszenie);

        // WHEN: Wywołujemy logikę z serwisu
        service.zmianaStatusuZgloszenia(10, Status.Zamkniete);

        // THEN: Sprawdzamy czy status w obiekcie faktycznie się zmienił
        assertTrue(zgloszenie.getStatus() == Status.Zamkniete);
    }

    @Test
    void testPobieraniaZgloszenZMocka() {
        // GIVEN: Ustalamy, że storage zawsze zwróci listę z jednym elementem
        Zgloszenie z = new Zgloszenie(LocalDate.now(), Status.W_trakcie, 1, 1, 1);
        when(storage.getZgloszeniaArrayList()).thenReturn(List.of(z));

        // WHEN: Pobieramy dane przez storage (mocka)
        List<Zgloszenie> lista = storage.getZgloszeniaArrayList();

        // THEN: Sprawdzamy czy lista nie jest pusta
        assertTrue(lista.size() == 1);
        assertTrue(lista.get(0).getZgloszenieId() == 1);
    }
    @Test
    void testCzyZmianaPracownikaZajmujacegoSieZgloszeniem() {
        Zgloszenie z = new Zgloszenie(LocalDate.now(), Status.W_trakcie, 1, 1, 1);
        when(storage.getZgloszeniePoId(1)).thenReturn(z);
        assertTrue(z.getPracownikId() == 1);
        service.zmianaPracownikaZajmujacegoSieZgloszeniem(1, 2);
        assertTrue(z.getPracownikId() == 2);
    }
}