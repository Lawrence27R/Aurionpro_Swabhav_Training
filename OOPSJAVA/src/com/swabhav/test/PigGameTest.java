package com.swabhav.test;

import java.util.Random;
import java.util.Scanner;

public class PigGameTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int maxTurns = 5;
        int turns = 0;

        for (turns = 1; turns <= maxTurns; turns++) {
            int turnScore = 0;
            boolean turnOver = false;

            System.out.println("TURN " + turns);
            turnScore = rollDice(turnOver, turnScore);

            totalScore += turnScore;
            System.out.println("Total score: " + totalScore);

            if (totalScore > 20) {
                System.out.println("You win!");
                System.out.println("Total " + turns + " turns taken");
                break;
            }
        }

        if (totalScore < 20) {
            System.out.println("Game over. You didn't reach 20 points.");
        }
      scanner.close();
    }


    private static int rollDice(boolean turnOver, int turnScore) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (!turnOver) {
            System.out.print("Roll or hold? (r/h): ");
            char choice = scanner.next().charAt(0);

            if (choice == 'r') {
                int dice = random.nextInt(6) + 1;
                System.out.println("dice: " + dice);

                if (dice == 1) {
                    System.out.println("Turn over. No score.");
                    turnScore = 0;
                    turnOver = true;
                    continue;
                }

                turnScore += dice;
                continue;
            }

            if (choice == 'h') {
                System.out.println("Turn over.");
                System.out.println("Turn Score: " + turnScore);
                turnOver = true;
                continue;
            }

            System.out.println("Invalid input, please enter 'r' to roll or 'h' to hold.");
        }


        return turnScore;
    }
}
