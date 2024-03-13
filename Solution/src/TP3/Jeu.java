package TP3;

import java.io.IOException;
import java.util.Scanner;

public class Jeu {
    private Paquet paquetInitiale;
    private Joueur j1 ;
    private Joueur j2;

    public Jeu(String nomJ1, Joueur j2){ // jouer J2 déja existant
        this.j1 = new Joueur(nomJ1);
        this.j2 = j2;
    }
    public Jeu(Joueur j1, Joueur j2){ //2 joueurs non existants
        this.j1 = j1;
        this.j2 = j2;
    }
    public Jeu(String nomJ){ //1 joueur non existant VS Ordi
        this.j1 = new Joueur(nomJ);
        this.j2 = new Ordinateur();
    }
    public Jeu(Joueur j){ //1 joueur existant VS Ordi
        this.j1 = j;
        this.j2 = new Ordinateur();
    }
    public Jeu(String nomJ1, String nomJ2){//2 joueurs déja existants
        j1 = new Joueur(nomJ1);
        j2 = new Joueur(nomJ2);
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
        else if(comparaison == 1){return j1;}
        else if(comparaison == -1){return j2;}
        return null;
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
            j1.paquetMain.ajouter(paquetInitiale.get(i));
            i++;
            j2.paquetMain.ajouter(paquetInitiale.get(i));
        }
    }
    public void jouerPartie() throws NumberFormatException, IOException{
        this.j1.nouveauJeu();
        this.j2.nouveauJeu();
    
        this.creerNouveauPaquet();
        this.paquetInitiale.melanger();
        this.distribuerPaquet(j1, j2);

        while(!j1.paquetMain.estVide() || !j2.paquetMain.estVide()){
            jouerCoup();
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println("Choisir le mode du Jeu : \n[0]: 2 Humains \n[1]: 1 Humain vs 1 Ordi \n[2] : 2 Ordi 😈");
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


