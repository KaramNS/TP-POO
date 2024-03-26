package TP3;
import java.util.ArrayList;

import java.util.Collections;

public class Paquet{
    private int taille;
    private ArrayList<Carte> paquet = new ArrayList<>(52);

    public Paquet(){
        this.taille = 00;
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
            paquet.add(carte);
        }
    }
    public Carte retirer(int index){
        //if(this.taille > index){
            return this.paquet.remove(index);
        //}
        // else{System.err.println("Err index non accèssible (Out of Range)");}
        // return null;
    }
    // public Carte retirer(Carte carte){
    //     return paquet.remove(paquet.get(carte));
    // }
    public Carte get(int index){
        return paquet.get(index);
    }
    public boolean estVide(){
        return (this.taille != 0);
    }
    public void melanger(){
        Collections.shuffle(paquet);
    }
    @Override
    public String toString(){
        String res = "";
        for(int i=0 ; i<taille ; i++){
           res += ("Carte [" + i + "]" + " : " + this.paquet.get(i).toString() + "\n");
        }
        return res;
    }
}


