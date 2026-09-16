package org.example;

public class Animalia {

    private boolean adoptatua;
    private int adina;
    private double pisua;
    private String izena;

    public Animalia(String izena, int adina, double pisua){

    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public int getAdina() {
        return adina;
    }

    public void setAdina(int adina) {
        this.adina = adina;
    }

    public void setAdoptatua(boolean adoptatua) {
        this.adoptatua = adoptatua;
    }

    public double getPisua() {
        return pisua;
    }

    public void setPisua(double pisua){
        this.pisua = pisua;
    }

    public boolean getAdoptatua() {
        return adoptatua;
    }

    public String getEspeziea(){
        return "Animalia";
    }

    public void adoptatu(){
        adoptatua = true;
    }

    public void eginSoinua(){
        System.out.println("Animalia soinua egiten ari da");
    }

    @Override
    public String toString(){
        return "Izena: " + izena +
                ", Adina: " + adina +
                ", Pisua: " + pisua +
                ", Adoptatua: " + adoptatua;
    }
}
