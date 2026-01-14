package org.example.zadaniedomowe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PomocTechnicznaApp {

    private final Storage storage;
    private final Service service;

    public PomocTechnicznaApp(Storage storage, Service service) {
        this.storage = storage;
        this.service = service;

        
        // 1. Tworzymy nowe zgłoszenie
        service.utworzenieNowegoZgloszenia(555, 999);
        service.utworzenieNowegoZgloszenia(1234, 3333);
        // 2. Zmieniamy status istniejącego zgłoszenia (np. tego z ID 1 z init)
        service.zmianaStatusuZgloszenia(1, Status.Rozpatrzone);
        
        // 3. Próbujemy zmienić status nieistniejącego zgłoszenia (edge case)
        service.zmianaStatusuZgloszenia(999, Status.Zamkniete);

        // 4. Zmieniamy pracownika
        service.zmianaPracownikaZajmujacegoSieZgloszeniem(2, 777);

        service.wypisanieZgloszeniaPoId(1);
        storage.print();
    }

    public static void main(String[] args) {
        SpringApplication.run(PomocTechnicznaApp.class, args);
    }

}
