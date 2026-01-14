package org.example.zadaniedomowe;

import java.time.LocalDate;

@org.springframework.stereotype.Service
public class Service {
    private final Storage storage;

    public Service(Storage storage) {
        this.storage = storage;
    }

    public void utworzenieNowegoZgloszenia(int clientId, int pracownikId){
        int zgloszenieId = storage.generateNextId();
        storage.addZgloszenie(new Zgloszenie(LocalDate.now(),Status.W_trakcie,clientId,pracownikId,zgloszenieId));
        System.out.println("Dodano nowe zgloszenie zgloszenieID " + zgloszenieId + " dla clientID" + clientId + " i pracownikID " + pracownikId);

    }
    public void zmianaStatusuZgloszenia(int zgloszenieId, Status status){
        Zgloszenie zgloszenie = storage.getZgloszeniePoId(zgloszenieId);
        if (zgloszenie != null) {
            zgloszenie.setStatus(status);
            System.out.println("Zmieniono status zgloszenia o ID " + zgloszenieId + " na " + status);
        } else {
            System.out.println("Nie znaleziono zgloszenia o ID " + zgloszenieId);
        }
    }
    public void zmianaPracownikaZajmujacegoSieZgloszeniem(int zgloszenieId, int nowypracownikId){
        Zgloszenie zgloszenie = storage.getZgloszeniePoId(zgloszenieId);

        if (zgloszenie != null) {
            if(zgloszenie.getStatus() != Status.Zamkniete) {
                zgloszenie.setPracownikId(nowypracownikId);
                System.out.println("Przypisano nowego pracownika o ID " + nowypracownikId + " do zgloszenia o ID " + zgloszenieId);
            }else{
                System.out.println("Blad, nie mozna zmienic pracownika przy zamknietym zgloszeniu");

            }
        }
    }
    public void wypisanieZgloszeniaPoId(int zgloszenieId){
        Zgloszenie zgloszenie = storage.getZgloszeniePoId(zgloszenieId);
        if (zgloszenie != null) {
            System.out.println(zgloszenie);
        } else {
            System.out.println("Nie znaleziono zgloszenia o ID " + zgloszenieId);
        }
    }


}
