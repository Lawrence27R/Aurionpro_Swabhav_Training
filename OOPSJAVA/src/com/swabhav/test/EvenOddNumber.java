package com.swabhav.test;

import java.util.Scanner;

public class EvenOddNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int number = scanner.nextInt();
		
		if (number % 2 ==0) {
			System.out.println("Even");
			return;
		}
		System.out.println("Odd");
	}
}
