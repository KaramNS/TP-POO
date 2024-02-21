//package poo.tp.premierspas;
// Exercice 2 Question 2 

import java.util.Scanner;
import java.util.Random;

public class jeuEx2 {
    /*
    A guessing game; type start to start the game 
     */
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Entrer A & B les limite respective de devination max & min \nEntier A : ");
        int A = scanner.nextInt();
        System.out.print("Entrer B : ");
        int B = scanner.nextInt();
            
        if(A < B){
            System.err.println("Err: A < B");
            System.exit(1);
        }
            
        int randomInt = (A + random.nextInt(A - B));

        boolean flag = false;
        int guess = 0;
        while(!flag){
            System.out.println(String.format("Deviner un chiffre entre  %d & %d", A, B));
             guess = scanner.nextInt();
    
            if(guess == randomInt){
                flag = true;
            }
            if(guess < A || guess > B){
                System.out.println("Oh la, vous devinez trop loin monsieur (Out of range)");
            }
        } 
        System.out.println("Vous avez ganger");
    }
} 
