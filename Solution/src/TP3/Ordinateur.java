package TP3;
import java.util.Random;

public class Ordinateur extends Joueur {

    public Ordinateur(){
        super("Ordinateur");
    }
    @Override
    public Carte choisirCarte(){
        Random random = new Random();
        return paquetMain.get(random.nextInt(paquetMain.taille()-1));
    }
}
