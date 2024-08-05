package com.swabhav.techlabs;

import java.util.Scanner;

public class SeasonClassifer {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the month number : ");
		int monthNum = sc.nextInt();
		
		switch (monthNum) {
		
		case 2 :
		case 3 :
		case 4 :
		case 5 : System.out.println("This is summer month");
				break;
		case 6 :
		case 7:
		case 8:
		case 9: System.out.println("This is monsoon month");
				break;
		case 10 :
		case 11:
		case 12:
		case 1: System.out.println("This is winter month");
				break;
		default : System.out.println("Invalid Input");
		}
	}
}
