package com.swabhav.techlabs;

import java.util.Scanner;

public class MaximumBtwThreeNums {
	public static void main(String[] args) {
		System.out.println("Enter the numbers :");
		Scanner sc = new Scanner(System.in);
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		int number3 = sc.nextInt();
		System.out.println("Maximum between three numbers");
		
		if ((number1 > number2) && (number1 > number3)) {
			System.out.println(+number1+" is maximum number");
		}
		else if ((number2 > number1) && (number2 > number3)) {
			System.out.println(+number2+"is maximum number");
		}
		else
		{
			System.out.println(+number3+" is maximum number");
		}
	}
}
