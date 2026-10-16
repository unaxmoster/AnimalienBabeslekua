package org.example.controller;

import org.example.dao.AnimaliaDAO;
import org.example.model.Animalia;
import org.example.model.Babeslekua;

import java.util.ArrayList;

public class AnimaliaController {

    private Babeslekua babeslekua;
    private AnimaliaDAO dao;

    public AnimaliaController() {

        babeslekua = new Babeslekua();
        dao = new AnimaliaDAO();

        ArrayList<Animalia> animaliak = dao.lortuAnimaliak();

        for (Animalia animalia : animaliak) {
            babeslekua.gehituAnimalia(animalia);
        }
    }

    public void gehituAnimalia(Animalia animalia) {

        dao.insertar(animalia);
        babeslekua.gehituAnimalia(animalia);
    }

    public ArrayList<Animalia> lortuAnimaliak() {
        return babeslekua.getAnimaliak();
    }

    public boolean ezabatuAnimalia(String izena) {

        boolean ezabatuta = dao.ezabatu(izena);

        if (ezabatuta) {
            babeslekua.ezabatuAnimalia(izena);
        }

        return ezabatuta;
    }

    public boolean adoptatuAnimalia(String izena) {

        boolean adoptatuta = dao.adoptatu(izena);

        if (adoptatuta) {
            babeslekua.adoptatuAnimalia(izena);
        }

        return adoptatuta;
    }
}
