package org.example;

import java.util.Scanner;

public class Menua {

    private Babeslekua babeslekua;

    public Menua(Babeslekua babeslekua){
        this.babeslekua = babeslekua;
    }

    public void gehituAnimalia(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Izena: ");
        String izena = sc.nextLine();

        System.out.println("Adina: ");
        int adina = sc.nextInt();

        System.out.println("Pisua: ");
        Double pisua = sc.nextDouble();

        System.out.println("1. Txakurra/2. Katua/3. Untxia");
        String espeziea = sc.next();

        Animalia animalia;

        if(espeziea.equalsIgnoreCase("1")){
            animalia = new Txakurra(izena, adina, pisua);
        }

        else if(espeziea.equalsIgnoreCase("2")){
            animalia = new Katua(izena, adina, pisua);
        }

        else if(espeziea.equalsIgnoreCase("3")){
            animalia = new Untxia(izena, adina, pisua);
        }

        else{
            System.out.println("Espeziea ez da zuzena");
            return;
        }

        babeslekua.gehituAnimalia(animalia);

        System.out.println("Animalia gehitu da");
    }

    public void ezabatuAnimalia(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Ezabatu nahi duzun animaliaren izena: ");
        String izena = sc.nextLine();

        if (babeslekua.ezabatuAnimalia(izena)) {
            System.out.println("Animalia ezabatu da.");
        } else {
            System.out.println("Animalia ez da aurkitu.");
        }
    }

    public void erakutsiAnimalia() {
        babeslekua.erakutsiAnimaliak();
    }

    public void exekutatu(){

        Scanner sc = new Scanner(System.in);

        int aukera;

        do {

            System.out.println("\n--- MENUA ---");
            System.out.println("1. Animalia gehitu");
            System.out.println("2. Animalia ezabatu");
            System.out.println("3. Animaliak erakutsi");
            System.out.println("4. Animalia adoptatu");
            System.out.println("5. Guztiek soinua egin");
            System.out.println("0. Irten");

            System.out.print("Aukera: ");
            aukera = sc.nextInt();

            switch (aukera) {

                case 1:
                    gehituAnimalia();
                    break;

                case 2:
                    ezabatuAnimalia();
                    break;

                case 3:
                    erakutsiAnimalia();
                    break;

                case 4:
                    adoptatuAnimalia();
                    break;

                case 5:
                    babeslekua.guztiekSoinua();
                    break;

                case 0:
                    System.out.println("Agur!");
                    break;

                default:
                    System.out.println("Aukera okerra.");
            }

        } while (aukera != 0);
    }

    public void adoptatuAnimalia(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Adoptatu nahi duzun animaliaren izena: ");
        String izena = sc.nextLine();

        if (babeslekua.adoptatuAnimalia(izena)) {
            System.out.println("Animalia adoptatu da.");
        } else {
            System.out.println("Animalia ez da aurkitu edo dagoeneko adoptatuta dago.");
        }
    }
}
