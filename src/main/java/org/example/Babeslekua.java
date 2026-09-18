package org.example;

import java.util.ArrayList;

public class Babeslekua {

    private ArrayList<Animalia> animaliak;

    public Babeslekua(){
        animaliak = new ArrayList<>();
    }

    public void gehituAnimalia(Animalia animalia){
        animaliak.add(animalia);
    }

    public boolean ezabatuAnimalia(String izena){

        for (Animalia animalia : animaliak) {

            if (animalia.getIzena().equalsIgnoreCase(izena)) {

                animaliak.remove(animalia);
                return true;
            }
        }

        return false;
    }


    public boolean adoptatuAnimalia(String izena){

        for (Animalia animalia : animaliak) {

            if (animalia.getIzena().equalsIgnoreCase(izena)) {

                if (!animalia.getAdoptatua()) {
                    animalia.adoptatu();
                    return true;
                }
            }
        }

        return false;
    }


    public Animalia bilatuAnimalia(String izena){

        for (Animalia animalia : animaliak) {

            if (animalia.getIzena().equalsIgnoreCase(izena)) {
                return animalia;
            }
        }

        return null;
    }


    public void erakutsiAnimaliak(){

        for (Animalia animalia : animaliak) {
            System.out.println(animalia);
        }
    }

    public void guztiekSoinua(){

        for (Animalia animalia : animaliak) {
            animalia.eginSoinua();
        }
    }
}
