package TP3;

import java.io.IOException;
import java.util.Scanner;

public class Jeu {
    private Paquet paquetInitiale;
    private Joueur j1 ;
    private Joueur j2;

    public Jeu(String nomJ1, Joueur j2){ // jouer J2 déja existant
        this.j1 = new Humain(nomJ1);
        this.j2 = j2;
    }
    public Jeu(Joueur j1, Joueur j2){ //2 joueurs non existants
        this.j1 = j1;
        this.j2 = j2;
    }
    public Jeu(String nomJ){ //1 joueur non existant VS Ordi
        this.j1 = new Humain(nomJ);
        this.j2 = new Ordinateur();
    }
    public Jeu(Joueur j){ //1 joueur existant VS Ordi
        this.j1 = j;
        this.j2 = new Ordinateur();
    }
    public Jeu(String nomJ1, String nomJ2){//2 joueurs déja existants
        j1 = new Humain(nomJ1);
        j2 = new Humain(nomJ2);
    }
    public Jeu(){ // Ordi VS Ordi
        j1 = new Ordinateur();
        j2 = new Ordinateur();
    }

    public Joueur jouerCoup() throws NumberFormatException, IOException{
        Carte carteJ1 = j1.choisirCarte();
        Carte carteJ2 = j2.choisirCarte();
        int comparaison = carteJ1.compareTo(carteJ2);

        if(comparaison == 0){jouerCoup();}
        else if(comparaison == 1){
            j1.recupererCarte(carteJ1);
            j1.recupererCarte(carteJ2);
            System.out.println(j1.nom + " a gagné " + carteJ1);
            return j1;
        }
        else if(comparaison == -1){
            j2.recupererCarte(carteJ1);
            j2.recupererCarte(carteJ2);
            System.out.println(j2.nom + " a gagné avec " + carteJ2);
            return j2;
        }
        return null;
    }
    public void creerNouveauPaquet(){
        this.paquetInitiale = new Paquet();
        for(int i=1 ; i<5; i++){
            for(int j=1 ; j<14; j++){
                paquetInitiale.ajouter(new Carte(j, i));
            }
        }
    }
    public void distribuerPaquet(){
        paquetInitiale.melanger();
        while (!paquetInitiale.estVide()) {
            Carte c = paquetInitiale.retirer(0);
            this.j1.recupererCarte(c);
            c = paquetInitiale.retirer(0);
            this.j2.recupererCarte(c);
        }
        // for(int i=0 ; i<paquetInitiale.taille()/2 ; i++){
        //     j1.paquetMain.ajouter(paquetInitiale.retirer());
        //     j2.paquetMain.ajouter(paquetInitiale.retirer());
        // }
    }
    public void jouerPartie() throws NumberFormatException, IOException{
        this.j1.nouveauJeu();
        this.j2.nouveauJeu();
    
        this.creerNouveauPaquet();
        System.out.println("nouveau paquet cree");
        System.out.println(paquetInitiale);
        this.paquetInitiale.melanger();
        System.out.println(" paquet melanger");
        System.out.println(paquetInitiale);
        this.distribuerPaquet();
        System.out.println(" paquet distribuer");
        System.out.println(paquetInitiale);
        System.out.println(j1);

        if(j1.paquetMain.estVide()){
            System.out.println(j1 + " a perdu .");
        }
        else if(j2.paquetMain.estVide()){
            System.out.println(j2 + " a perdu .");
        }
        while(j1.paquetMain.estVide() || j2.paquetMain.estVide()){
            jouerCoup();
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println("Choisir le mode du Jeu : \n[0]: 2 Humains \n[1]: 1 Humain vs 1 Ordi \n[2] : 2 Ordi 😈");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());

        if(choice == 0){
            System.out.println("Saisir les noms des Jouer, Jouer1 puis Jouer2 : \n");
            String nomJ1 = scanner.nextLine();
            String nomJ2 = scanner.nextLine();
            Jeu jeu = new Jeu(nomJ1, nomJ2);
            jeu.jouerPartie();
        }
        if(choice == 1){
            System.out.println("Saisir le nom du Jouer: ");
            String nomJ1 = scanner.nextLine();
            Jeu jeu = new Jeu(nomJ1);
            jeu.jouerPartie();
        }
        if(choice == 2){
            Jeu jeu = new Jeu();
            jeu.jouerPartie();
        }
    }
}


