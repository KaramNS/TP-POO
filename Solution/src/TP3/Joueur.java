package TP3;

import java.io.IOException;

public abstract class Joueur {
    String nom;
    protected Paquet paquetMain;

    public abstract Carte choisirCarte() throws NumberFormatException, IOException;

    public Joueur(String nom){
        this.nom = nom;
        this.paquetMain = new Paquet();
    }
    public final void nouveauJeu(){
        this.paquetMain = new Paquet();
    }
    public final Carte jouer() throws NumberFormatException, IOException{
        return this.choisirCarte();
    }
    public void recupererCarte(Carte carte){
        this.paquetMain.ajouter(carte);
    }
    public boolean aPerdu(){
        if(this.paquetMain.estVide()){return true;}
        else{return false;}
    }
    
    @Override
    public String toString(){
        return this.nom + "\n" + this.paquetMain.toString() + "\n";
    }
}

