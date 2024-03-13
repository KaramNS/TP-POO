package TP3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Joueur {
    String nom;
    protected Paquet paquetMain;
    
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
    public Carte choisirCarte() throws NumberFormatException, IOException{
        System.out.println("Veillez choisir un carte à jouer : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int indexCarteChoisi;
        
        indexCarteChoisi = Integer.parseInt(br.readLine());

        return this.paquetMain.retirer(indexCarteChoisi);
    }
    public void recupererCarte(Carte carte){

    }
    public boolean aPerdu(){
        if(this.paquetMain.estVide()){return true;}
        else{return false;}
    }
    
    @Override
    public String toString(){
        return "";
    }
}
