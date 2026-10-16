package org.example.model;

public class Untxia extends Animalia {

    public Untxia(String izena, int adina, double pisua) {
        super(izena, adina, pisua);
    }

    @Override
    public void eginSoinua() {
        System.out.println("??");
    }

    @Override
    public String getSoinua() {
        return "??";
    }

    @Override
    public String getEspeziea() {
        return "Untxia";
    }
}
