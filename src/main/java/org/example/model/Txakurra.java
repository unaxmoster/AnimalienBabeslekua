package org.example.model;

public class Txakurra extends Animalia {

    public Txakurra(String izena, int adina, double pisua) {
        super(izena, adina, pisua);
    }

    @Override
    public void eginSoinua() {
        System.out.println("Zaunka!");
    }

    @Override
    public String getSoinua() {
        return "Zaunka!";
    }

    @Override
    public String getEspeziea() {
        return "Txakurra";
    }
}