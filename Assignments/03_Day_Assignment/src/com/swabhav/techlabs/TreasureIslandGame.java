package com.swabhav.techlabs;

import java.util.Scanner;

public class TreasureIslandGame {
	public static void main(String[] args) {
		System.out.println("Welcome to the treasure Island.");
		System.out.println("Your mission is to find the treasure.");
		Scanner sc = new Scanner(System.in);
		
        System.out.println("Choose an option:");
        System.out.println("1. Left");
        System.out.println("2. Right");
        int choice1 = sc.nextInt();

        if (choice1 == 1) {
            System.out.println("Choose an option:");
            System.out.println("1. Swim");
            System.out.println("2. Wait");
            int choice2 = sc.nextInt();

            if (choice2 == 2) {
                System.out.println("Choose an option:");
                System.out.println("1. Red");
                System.out.println("2. Blue");
                System.out.println("3. Yellow");
                int choice3 = sc.nextInt();

                switch (choice3) {
                    case 1:
                        System.out.println("Burned by fire. Game Over.");
                        break;
                    case 2:
                        System.out.println("Eaten by beasts. Game Over.");
                        break;
                    case 3:
                        System.out.println("You Win!");
                        break;
                    default:
                        System.out.println("Game Over.");
                        break;
                }
            } else {
                System.out.println("Attacked by trout. Game Over.");
            }
        } else {
            System.out.println("Fall into a hole. Game Over.");
        }
	}
}
