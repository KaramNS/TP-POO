package TP3;
import java.util.ArrayList;

import java.util.Collections;

public class Paquet{
    private int taille;
    private boolean estVide;
    private ArrayList<Carte> paquet = new ArrayList<>(52);

    public Paquet(){
        this.taille = 00;
        this.estVide = true;
        // for(int i=1 ; i<5; i++){
        //     for(int j=0 ; j<13; j++){
        //         ajouter(new Carte(j, i));
        //     }
        // }
    }
    public int taille(){
        return this.taille;
    }
    public void ajouter(Carte carte){
        if(this.taille == 52){
            System.err.println("Err capacité max de paquet est atteite !");
        }
        else{
            taille ++;
            estVide = false;
            paquet.add(carte);
        }
    }
    public Carte retirer(int index){
        return paquet.remove(index);
    }
    public Carte retirer(){
        return paquet.remove(0);
    }
    public Carte get(int index){
        return paquet.get(index);
    }
    public boolean estVide(){
        return estVide;
    }
    public void melanger(){
        Collections.shuffle(paquet);
    }
    @Override
    public String toString(){
        String res = "";
        for(int i=0 ; i<taille ; i++){
           res += ("Valeur [" + i + "]" + " : " + this.paquet.get(i).toString() + "\n");
        }
        return res;
    }
}


