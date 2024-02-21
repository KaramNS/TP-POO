
import java.util.ArrayList;

// Question tout
public class Personne{
    private String nom;
    private String prenom;
    private Date DN; // DN : Date de Naissance
    private String sex; // M pour masculine, F pour Feminin
    private ArrayList<Object> statCivil = new ArrayList<>(3);
    private ArrayList<Personne> parents = new ArrayList<>(2);
    // private Personne parent1;
    // private Personne parent2;

    public Personne(String nom, String prenom, Date DN, String sex, ArrayList<Object> statCivil, ArrayList<Personne> parents){ // DN : Date de Naissance
        this.nom = nom;
        this.prenom = prenom;
        this.DN = DN;
        this.sex = sex;
        this.statCivil = statCivil; 
        // statCivil[3]= [statutCivil = "Marié/Célibataire", partenaire = Objet Personne, DateMariage = Date]
        this.parents = parents;
        // parents[2] = [Personne parent1, Personne parent2]
    }
    public void changNom(String nouveauNom){
        if(this.sex == "F"){
        this.nom = nouveauNom;
        }
    }
    public boolean estMarié(Personne personne){
        if(statCivil.get(0) == "Marié"){return true;}
        else{return false;}
    }
    public void marie(Personne partenaire, Date DateMariage){
        this.statCivil.set(0, "Marié");
        this.statCivil.set(1, partenaire);
        if((DateMariage.compareTo(DN)) == 1){
            this.statCivil.set(2, DateMariage);
        }
    }
    public ArrayList<Personne> getParents(){
        return this.parents;
    }
    public boolean estFrère(Personne p1){
        for(int i=0; i < this.parents.size(); i++){
            for(int j = 0 ; j <p1.getParents().size(); j++){
                if (this.parents.get(i) == p1.getParents().get(j)){
                    return true;
                }
            }
        }
        return false;
    }
    public void ajoutParent(ArrayList<Personne> parent) {
        // Assuming 'parents' is an array of Personne objects
        if (this.parents.size() + parent.size() == 2) {
            // Iterate over the 'parent' array and add each element to the 'parents' array
            for (int i = 0; i < parent.size(); i++) {
                // Assuming 'parents' is a fixed-size array
                if (this.parents.size() < 2) {
                    this.parents.add(parent.get(i));
                }
            }
        } 
    } 
}
