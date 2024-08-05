package day._04;

import java.util.Scanner;
import java.util.Random;

public class WordGuessGame {
    public static void main(String[] args) {
        String[] words = {"program", "python", "java", "lawrence"};
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        int lives = 5;
        boolean gameOver = false;
        
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);
        
        while (!gameOver) {
            System.out.println("Current word: ");
            for (int i = 0; i < guessedWord.length; i++) {
                System.out.print(guessedWord[i] + " ");
            }
            System.out.println("\nLives left: " + lives);
            System.out.print("Guess a letter: ");
            char guessedLetter = scanner.next().charAt(0);
            
            boolean letterFound = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    guessedWord[i] = guessedLetter;
                    letterFound = true;
                }
            }
            
            if (!letterFound) {
                lives--;
            }
            
            boolean allBlanksFilled = true;
            for (int i = 0; i < guessedWord.length; i++) {
                if (guessedWord[i] == '_') {
                    allBlanksFilled = false;
                    break;
                }
            }
            
            if (allBlanksFilled) {
                System.out.println("You won! The word was: " + wordToGuess);
                gameOver = true;
            } else if (lives == 0) {
                System.out.println("Game over! You ran out of lives. The word was: " + wordToGuess);
                gameOver = true;
            }
        }
        
        scanner.close();
    }
}
