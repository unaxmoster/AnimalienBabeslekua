package org.example;

public class Katua extends Animalia{

    public Katua(String izena, int adina, double pisua){
        super(izena, adina, pisua);
    }

    @Override
    public void eginSoinua(){
        System.out.println("Miau!");
    }

    @Override
    public String getEspeziea(){
        return "Katua";
    }
}
