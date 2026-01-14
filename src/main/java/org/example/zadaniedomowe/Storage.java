package org.example.zadaniedomowe;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {
    private ArrayList<Zgloszenie> zgloszeniaArrayList = new ArrayList<>();


    public Storage(){
        zgloszeniaArrayList.add(new Zgloszenie(LocalDate.now(),Status.W_trakcie,1234,3333,1));
        zgloszeniaArrayList.add(new Zgloszenie(LocalDate.now(),Status.OczekujeNaOdpowiedzKlienta,1234,3333,2));
    }

    public List<Zgloszenie> getZgloszeniaArrayList() {
        return new ArrayList<>(zgloszeniaArrayList);
    }
    public Zgloszenie getZgloszeniePoId(int zgloszenieId){
        return zgloszeniaArrayList.stream()
                .filter(zgloszenie -> zgloszenie.getZgloszenieId() == zgloszenieId)
                .findFirst().orElse(null);

    }

    public boolean existByClientId(int clientId){
        return zgloszeniaArrayList.stream().anyMatch(z -> z.getClientId() == clientId);
    }
    public int generateNextId(){
        return zgloszeniaArrayList.stream()
                .mapToInt(Zgloszenie::getZgloszenieId)
                .max()
                .orElse(0) + 1;
    }
    public void addZgloszenie(Zgloszenie zgloszenie){
        zgloszeniaArrayList.add(zgloszenie);
    }

}
