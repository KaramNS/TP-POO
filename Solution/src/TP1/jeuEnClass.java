
import java.util.Scanner;
import java.util.Random;

public class jeuEnClass {
    int min; //Entier borne max
    int max; //Entier borne max
    int randomInt; //Entier random à deviner
    int guess; //La devination de usr
    
    // Constructor 
    public jeuEnClass(int A, int B){
        min = Math.min(A, B);
        max = Math.max(A, B);
        randomInt = random(min, max+1);
        guess = randomInt+1 ;
    }

    // Random
    public int random(int min, int max){
        if(max < min){
            System.err.println("Err: A < B");
            System.exit(1);
        }
        Random random = new Random();
        return (min + random.nextInt(max - min));
    }

    // Run / Try 
    @SuppressWarnings("resource")
    void run(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        
        while(!flag){
            System.out.println(String.format("Deviner un chiffre entre  %d & %d", min, max));
            guess = scanner.nextInt();
    
            if(guess == randomInt){
                flag = true;
            }
            if(guess < min || guess > max){
                System.out.println("Oh la, vous devinez trop loin monsieur (Out of range)");
            }
        } 
    System.out.println("Vous avez ganger");
    }


    public static void main(String[] args){
        if(args.length == 2){
            int A = Integer.parseInt(args[0]);
            int B = Integer.parseInt(args[1]);
            jeuEnClass partie = new jeuEnClass(A, B);
            partie.run();
        }
    } 
}
