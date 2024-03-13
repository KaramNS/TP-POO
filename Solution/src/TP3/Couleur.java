package TP3;

enum Couleur {
    PIQUE(1), COEUR(2), CARREAU(3), TREFLE(4);
    // La valeur indique la priorité en ordre descendant, 1 est le prioritaire
    private final int valeur;

    private Couleur(int valeur){
        this.valeur = valeur;
    }
    public static Couleur numToCouleur(int num){
        if(num == 1){return Couleur.PIQUE;}
        if(num == 2){return Couleur.COEUR;}
        if(num == 3){return Couleur.CARREAU;}
        if(num == 4){return Couleur.TREFLE;}
        throw new IllegalArgumentException("Numéro de couleur invalide : " + num);
    }
    public int getValeur(){
        return this.valeur;
    }

}
