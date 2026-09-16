package org.example;

public class Untxia extends Animalia{

    public Untxia(String izena, int adina, double pisua){
        super(izena, adina, pisua);
    }

    @Override
    public void eginSoinua(){
        System.out.println("??");
    }

    @Override
    public String getEspeziea(){
        return "Untxia";
    }
}
