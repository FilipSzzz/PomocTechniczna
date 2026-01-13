package org.example.zadaniedomowe;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {
    private ArrayList<Zgloszenie> zgloszenia = new ArrayList<>();

    public Storage(){
        init();
    }
    public void init(){
        zgloszenia.add(new Zgloszenie(LocalDate.now(),Status.W_trakcie,1234,3333));
        zgloszenia.add(new Zgloszenie(LocalDate.now(),Status.OczekujeNaOdpowiedzKlienta,1234,3333));
    }

    public List<Zgloszenie> getZgloszenia() {
        return new ArrayList<>(zgloszenia);
    }
    public boolean existByClientId(int clientId){
        return zgloszenia.stream().anyMatch(z -> z.getClientId() == clientId);
    }
    public void addZgloszenie(Zgloszenie zgloszenie){
        if (!existByClientId(zgloszenie.getClientId())) zgloszenia.add(zgloszenie);
    }

}
