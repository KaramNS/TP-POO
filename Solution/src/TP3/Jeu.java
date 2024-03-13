package TP3;

public class Jeu {
    private Paquet paquetInitiale;

    public String jouerCoup(){
        jouer
    }
    public void creerNouveauPaquet(){
        this.paquetInitiale = new Paquet();
        for(int i=1 ; i<5; i++){
            for(int j=0 ; j<13; j++){
                paquetInitiale.ajouter(new Carte(j, i));
            }
        }
    }
    public void distribuerPaquet(Joueur j1, Joueur j2){
        paquetInitiale.melanger();
        for(int i=0 ; i<paquetInitiale.taille() ; i++){
            j1.paquet.ajouter(paquetInitiale.get(i));
            i++;
            j2.paquet.ajouter(paquetInitiale.get(i));
        }
    }
    public void jouerPartie(){

    }
    public static void main(String[] args) {
        
    }
}
