package org.example.zadaniedomowe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceIntegrationTest {
    @MockitoBean
    private Storage storage;
    @MockitoBean
    private Service service;
    @Test
    void testujemyCzyMoznaDodacZgloszenieOTymSamymClientID() {
//        List<Zgloszenie> zgloszenia = new ArrayList<>();
//        zgloszenia.add(new Zgloszenie(LocalDate.now(),Status.W_trakcie,1,1,1));
//        zgloszenia.add(new Zgloszenie(LocalDate.now(),Status.W_trakcie,1,1,2));
        Zgloszenie z1 = new Zgloszenie(LocalDate.now(),Status.W_trakcie,1,1,1);
        Zgloszenie z2 = new Zgloszenie(LocalDate.now(),Status.W_trakcie,1,1,2);
        storage.addZgloszenie(z1);
        storage.addZgloszenie(z2);
        when(storage.generateNextId()).thenReturn(1);

        assertTrue(storage.getZgloszeniaArrayList().size()==2);
    }
}
