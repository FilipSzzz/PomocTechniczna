package org.example.zadaniedomowe;


import java.time.LocalDate;

public class Zgloszenie {
    private Status status;
    private Pracownik pracownik;
    private int clientId;
    private int pracownikId;
    LocalDate dataWystawienia;

    public Zgloszenie(LocalDate dataWystawienia, Status status, int clientId, int pracownikId) {
        this.status = status;
        this.dataWystawienia = dataWystawienia;
        this.clientId = clientId;
        this.pracownikId = pracownikId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getPracownikId() {
        return pracownikId;
    }

    public Status getStatus() {
        return status;
    }
}
