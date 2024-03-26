package TP3;

import java.io.Console;
import java.io.IOException;

public class Humain extends Joueur{
    Console console ;

    public Humain(String nom){
        super(nom);
        this.console = System.console();
    }
    public Carte choisirCarte() throws NumberFormatException, IOException{
        System.out.println(this.paquetMain);
        System.out.println("Veillez choisir un carte à jouer : ");

        int indexCarteChoisi = Integer.parseInt(this.console.readLine());

        return this.paquetMain.retirer(indexCarteChoisi);
    }
}
