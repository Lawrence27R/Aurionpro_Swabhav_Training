package com.swabhav.techlabs;

import java.util.Scanner;

public class CheckEvenOddNumber {
	public static void main(String[] args) {
		
		System.out.println("Enter a number greater than 0");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		if (number % 2 == 0){
			System.out.println("The number is even");
		}
		else 
		{
			System.out.println("The number is odd");
		}
			

	}
}
