package org.example.model;

import java.util.ArrayList;

public class Babeslekua {

    private ArrayList<Animalia> animaliak;

    public Babeslekua() {
        animaliak = new ArrayList<>();
    }

    public void gehituAnimalia(Animalia animalia) {
        animaliak.add(animalia);
    }

    public ArrayList<Animalia> getAnimaliak() {
        return animaliak;
    }

    public boolean ezabatuAnimalia(String izena) {

        return animaliak.removeIf(
                animalia -> animalia.getIzena().equalsIgnoreCase(izena)
        );
    }

    public boolean adoptatuAnimalia(String izena) {

        for (Animalia animalia : animaliak) {

            if (animalia.getIzena().equalsIgnoreCase(izena)
                    && !animalia.getAdoptatua()) {

                animalia.adoptatu();
                return true;
            }
        }

        return false;
    }
}