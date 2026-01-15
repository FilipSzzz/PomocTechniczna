package org.example.zadaniedomowe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private Service service;
    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new Storage();
        service = new Service(storage);
    }

    @Test
    void utworzenieNowegoZgloszenia_PowinnoDodacZgloszenieZPoprawnymiDanymi() {
        // When
        service.utworzenieNowegoZgloszenia(100, 200);

        // Then
        assertEquals(1, storage.getZgloszeniaArrayList().size(), "Powinno być 1 zgłoszenie w bazie");
        
        Zgloszenie z = storage.getZgloszeniaArrayList().get(0);
        assertEquals(1, z.getZgloszenieId(), "Pierwsze ID powinno wynosić 1");
        assertEquals(Status.W_trakcie, z.getStatus(), "Domyślny status to W_trakcie");
        assertEquals(100, z.getClientId());
        assertEquals(200, z.getPracownikId());
    }

    @Test
    void utworzenieKilkuZgloszen_PowinnoNadawacUnikalneId() {
        // When
        service.utworzenieNowegoZgloszenia(10, 20);
        service.utworzenieNowegoZgloszenia(10, 20);

        // Then
        assertEquals(2, storage.getZgloszeniaArrayList().size());
        
        Zgloszenie z1 = storage.getZgloszeniaArrayList().get(0);
        Zgloszenie z2 = storage.getZgloszeniaArrayList().get(1);

        assertNotEquals(z1.getZgloszenieId(), z2.getZgloszenieId(), "ID zgłoszeń muszą być różne");
        assertEquals(1, z1.getZgloszenieId());
        assertEquals(2, z2.getZgloszenieId());
    }


    @Test
    void zmianaStatusu_GdyZgloszenieIstnieje_PowinnaZaktualizowacStatus() {
        // Given
        service.utworzenieNowegoZgloszenia(100, 200); // ID = 1
        assertEquals(Status.W_trakcie, storage.getZgloszeniePoId(1).getStatus());

        // When
        service.zmianaStatusuZgloszenia(1, Status.OczekujeNaOdpowiedzKlienta);


        assertEquals(Status.OczekujeNaOdpowiedzKlienta, storage.getZgloszeniePoId(1).getStatus());
    }

    @Test
    void zmianaStatusu_GdyZgloszenieNieIstnieje_NiePowinnaRzucacWyjatku() {
        // When & Then
        // Próbujemy zmienić status zgłoszenia o ID 999 (którego nie ma)
        assertDoesNotThrow(() -> service.zmianaStatusuZgloszenia(999, Status.Zamkniete));
    }


    @Test
    void zmianaPracownika_GdyZgloszenieOtwarte_PowinnaZmienicPracownika() {
        // Given
        service.utworzenieNowegoZgloszenia(100, 200); // Pracownik = 200

        // When
        service.zmianaPracownikaZajmujacegoSieZgloszeniem(1, 300);

        // Then
        assertEquals(300, storage.getZgloszeniePoId(1).getPracownikId());
    }

    @Test
    void zmianaPracownika_GdyZgloszenieZamkniete_NIE_PowinnaZmienicPracownika() {
        // Given
        service.utworzenieNowegoZgloszenia(100, 200); // Pracownik startowy: 200
        service.zmianaStatusuZgloszenia(1, Status.Zamkniete); // Zamykamy zgłoszenie

        // When
        service.zmianaPracownikaZajmujacegoSieZgloszeniem(1, 999); // Próbujemy wcisnąć pracownika 999

        // Then
        int aktualnyPracownik = storage.getZgloszeniePoId(1).getPracownikId();
        assertEquals(200, aktualnyPracownik, "Pracownik nie powinien się zmienić, gdy status to Zamkniete!");
    }

    @Test
    void zmianaPracownika_GdyZgloszenieNieIstnieje_NiePowinnaRzucacWyjatku() {
        // When & Then
        assertDoesNotThrow(() -> service.zmianaPracownikaZajmujacegoSieZgloszeniem(999, 500));
    }
    @Test
    void ujemneId(){
        service.utworzenieNowegoZgloszenia(-100, 200);
        assertTrue(storage.getZgloszeniaArrayList().isEmpty());
    }
}
