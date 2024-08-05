package com.swabhav.techlabs;

import java.util.Scanner;

public class RiderGame {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter height in cms : ");
		
		int height = sc.nextInt();
		
		if (height <= 120) {
			System.out.println("Can't Ride");
		}
		else {
			System.out.println("Can ride");
			System.out.println("Enter age : ");
			int age = sc.nextInt();
			int cost = 0;
			
			if (age < 12) {
				cost += 5;
//				cost is $5
			}
			else if (age >=12 && age < 18) {
				cost += 7;
			}
			else if (age >= 18 && age <= 45) {
				cost += 12;
			}
			else if (age >45 && age <=55){
				cost += 0;
			}
			else {
				cost += 12;
			}
			
			System.out.println("Want photos ?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = sc.nextInt();
			
			if (choice == 1) {
				cost += 3;
				System.out.println("Total bill is $"+cost);
			}
			else {
				System.out.println("Total bill is $"+cost);
			}
		}
	}
}
