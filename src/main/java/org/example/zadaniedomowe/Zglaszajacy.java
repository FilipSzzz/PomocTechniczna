package org.example.zadaniedomowe;

public class Zglaszajacy {
    private String imie;
    private String nazwisko;
    private int pesel;
    private int zglaszajacyId;

    public Zglaszajacy(int zglaszajacyId, String imie, String nazwisko, int pesel) {
        this.zglaszajacyId = zglaszajacyId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

}
