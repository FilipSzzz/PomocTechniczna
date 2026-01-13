package org.example.zadaniedomowe;

import java.time.LocalDate;

@org.springframework.stereotype.Service
public class Service {
    private final Storage storage;

    public Service(Storage storage) {
        this.storage = storage;
    }

    public void utworzenieNowegoZgloszenia(int clientId, int pracownikId){
        storage.addZgloszenie(new Zgloszenie(LocalDate.now(),Status.W_trakcie,clientId,pracownikId));

    }
    public void zmianaStatusuZgloszenia(int clientId, Status status){
        storage.getZgloszenia().forEach(System.out::println);
    }
    public void zmianaPracownikaZajmujacegoSieZgloszeniem(int clientId, int pracownikId){
//        storage.getZgloszeniePoId();
    }
    public void wypisanieZgloszeniaPoId(int clientId){
        storage.getZgloszeniePoId(clientId).toString();
    }


}
