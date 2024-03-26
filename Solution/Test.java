import TP3.Carte;

import TP3.Paquet;

public class Test {
    public static void main(String[] args) {
        //Jeu jeu = new Jeu();
        Paquet paquet = new Paquet();
        paquet.ajouter(new Carte (1, 1));
        paquet.ajouter(new Carte (2, 1));
        paquet.ajouter(new Carte (3, 1));
        paquet.ajouter(new Carte (4, 1));

        System.out.println("Avant de mélanger" + paquet);
        paquet.melanger();
        System.out.println("Après de mélanger" + paquet);
        paquet.retirer(0);
        System.out.println("Après de retirer" + paquet);
    }
}
