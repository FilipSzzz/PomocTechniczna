package org.example.zadaniedomowe;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {
    private ArrayList<Zgloszenie> zgloszeniaArrayList = new ArrayList<>();

    public List<Zgloszenie> getZgloszeniaArrayList() {
        return new ArrayList<>(zgloszeniaArrayList);
    }
    public Zgloszenie getZgloszeniePoId(int zgloszenieId){
        return zgloszeniaArrayList.stream()
                .filter(zgloszenie -> zgloszenie.getZgloszenieId() == zgloszenieId)
                .findFirst().orElse(null);

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
    public void print(){
        zgloszeniaArrayList.forEach(System.out::println);
    }

}
