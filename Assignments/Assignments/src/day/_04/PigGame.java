package day._04;

import java.util.Random;
import java.util.Scanner;

public class PigGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int totalScore = 0;
        int maxTurns = 5;
        int i = 0;
        for (i = 1; i <= maxTurns; i++) {
            int turnScore = 0;
            boolean turnOver = false;
            
            System.out.println("TURN " +i);
            
            while (!turnOver) {
                System.out.print("Roll or hold? (r/h): ");
                char choice = sc.next().charAt(0);
                
                if (choice == 'r') {
                    int dice = random.nextInt(6) + 1;
                    System.out.println("dice: " + dice);
                    
                    if (dice == 1) {
                        System.out.println("Turn over. No score.");
                        turnScore = 0;
                        turnOver = true;
                    } 
                    else {
                        turnScore += dice;
                    }
                    
                } else if (choice == 'h') {
                	System.out.println("Turn Score : "+turnScore);
                    totalScore += turnScore;
                    turnOver = true;
                } else {
                    System.out.println("Invalid input, please enter 'r' to roll or 'h' to hold.");
                }
            }
            
            System.out.println("Total score: " + totalScore);
            
            if (totalScore > 20) {
                System.out.println("You win!");
                break;
            }
        }
        
        if (totalScore < 20) {
            System.out.println("Game over. You didn't reach 20 points.");
            System.out.println("Total "+i+" turns taken");
        }
        
    }
}