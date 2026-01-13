package org.example.zadaniedomowe;

@org.springframework.stereotype.Service
public class Service {
    private final Storage storage;

    public Service(Storage storage) {
        this.storage = storage;
    }

    public void utworzenieNowegoZamownia(Zgloszenie zgloszenie){

    }
    public void zmianaStatusuZgloszenia(int id, Status status){

    }
    public void zmianaPracownikaZajmujacegoSieZgloszeniem(){

    }
    public void wypisanieZgloszeniaPoId(Zglaszajacy zglaszajacy){

    }

}
