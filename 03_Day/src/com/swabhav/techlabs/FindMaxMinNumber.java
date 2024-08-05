package com.swabhav.techlabs;

import java.util.Scanner;

public class FindMaxMinNumber {
	public static void main(String[] args) {
		System.out.println("Enter the numbers :");
		Scanner sc = new Scanner(System.in);
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		System.out.println("Maximum between two numbers");
		if (number1 > number2) {
			System.out.println(+number1+" is maximum number");
		}
		else if (number1 == number2) {
			System.out.println("Both the number are equal");
		}
		else
		{
			System.out.println(+number2+" is maximum number");
		}
		System.out.println("Minimum between two numbers");
		if (number1 < number2) {
			System.out.println(+number1+" is minimum number");
		}
		else if (number1 == number2) {
			System.out.println("Both the number are equal");
		}
		else
		{
			System.out.println(+number2+" is minimum number");
		}
		
	}
}
