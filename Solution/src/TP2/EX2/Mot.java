package TP2.EX2;

public class Mot {
    private String mot;
    
    public Mot(){
        this.mot = System.console().readLine();
    }
    public String toString(){
        return mot;
    }
    public String afficheVoyelles(){
        String res = "";
        for(int i = 0; i < this.mot.length(); i++){
            for(int j = 0 ; j < 6; j++){
                if(mot.charAt(i) == 'a' || mot.charAt(i) == 'o' || mot.charAt(i) == 'e' 
                || mot.charAt(i) == 'u' || mot.charAt(i) == 'i' || mot.charAt(i) == 'y'){
                    res += mot.charAt(i);
                }
            }
        }
        return res;
    }
}
