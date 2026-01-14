package org.example.zadaniedomowe;


import java.time.LocalDate;

public class Zgloszenie {
    private Status status;
    private int clientId;
    private int pracownikId;
    LocalDate dataWystawienia;
    private int zgloszenieId;

    public Zgloszenie(LocalDate dataWystawienia, Status status, int clientId, int pracownikId, int zgloszenieId) {
        this.status = status;
        this.dataWystawienia = dataWystawienia;
        this.clientId = clientId;
        this.pracownikId = pracownikId;
        this.zgloszenieId = zgloszenieId;
    }

    public int getClientId() {
        return clientId;
    }
    public int getZgloszenieId() {
        return zgloszenieId;
    }

    public int getPracownikId() {
        return pracownikId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPracownikId(int pracownikId) {
        this.pracownikId = pracownikId;
    }

    @Override
    public String toString() {
        return "Zgloszenie{" +
                "status=" + status +
                ", clientId=" + clientId +
                ", pracownikId=" + pracownikId +
                ", dataWystawienia=" + dataWystawienia +
                ", zgloszenieId=" + zgloszenieId +
                '}';
    }
}
