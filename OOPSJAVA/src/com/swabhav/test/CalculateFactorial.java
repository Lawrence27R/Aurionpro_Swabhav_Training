package com.swabhav.test;

import java.util.Scanner;

public class CalculateFactorial {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int number = scanner.nextInt();
		int factorial = calculateFactorial(number);
		if (factorial == -1) {
			System.out.println("Enter positive integers.");
			return;
		}
		System.out.println(factorial);
	}
	
	public static int calculateFactorial(int number) {
		if (number == 0) {
			return 1;
		}
		if (number < 0) {
			return -1;
		}
		int factorial = 1;
		for (int i=1; i<=number; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
}
