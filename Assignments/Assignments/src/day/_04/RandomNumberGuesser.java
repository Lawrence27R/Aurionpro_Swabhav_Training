package day._04;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuesser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int choice = 1;

        while (choice == 1) {
            int randomNumber = random.nextInt(10) + 1;
            int guess = 0;
            int attempts = 0;

            System.out.println("Random number generated between 1 to 10.")

            while (guess != randomNumber && attempts < 5) {
                System.out.print("Guess the number: ");
                guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("You won! You guessed the number in " + attempts + " attempts.");
                } else if (guess < randomNumber) {
                    System.out.println("Sorry, too low.");
                } else {
                    System.out.println("Sorry, too high.");
                }
            }

            if (guess != randomNumber) {
                System.out.println("You have exceeded the maximum possible attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Do you want to play the game again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choice = sc.nextInt();
        }

        System.out.println("Thank you for playing.");
        sc.close();
    }
}