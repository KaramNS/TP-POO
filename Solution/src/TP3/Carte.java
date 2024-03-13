package TP3;

public class Carte implements Comparable<Carte>{
    public final int valeur;
    public final Couleur couleur; //PIQUE(1), COEUR(2), CARREAU(3), TREFLE(4);

    public Carte(int valeur, int couleur){
        this.valeur = valeur;
        this.couleur = Couleur.numToCouleur(couleur);
    }

    @Override
    public int compareTo(Carte carte){
        int resValeur = this.valeur - carte.valeur;
        
        if(resValeur == 0){
            resValeur = this.couleur.getValeur() - carte.couleur.getValeur();

            if(resValeur > 0){return 1;}
            else if(resValeur < 0){return -1;}
            else if (resValeur == 0){return 0;}
        }
        else if(resValeur > 0){return 1;}
        else if(resValeur < 0){return -1;}

        else{return -2;}
        throw new IllegalArgumentException("Err : impossible de comparer");
    }
    @Override
    public String toString(){
        return "Valeur = " + this.valeur + ", Couleur " + this.couleur;
    }
    
}
