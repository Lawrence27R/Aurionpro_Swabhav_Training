package com.swabhav.techlabs;

import java.util.Scanner;

public class ArithmeticOperators {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number1 : ");
		int number1 = sc.nextInt();
		System.out.println("Enter Number2 : ");
		int number2 = sc.nextInt();
		
		int addition = number1 + number2;
		int substraction = number1 - number2;
		int multiplication = number1 * number2;
		int division = number1/number2;
		int modulus = number1%number2;
		
		System.out.println("Addtion is : "+addition);
		System.out.println("Substraction is : "+substraction);
		System.out.println("Multiplication is : "+multiplication);
		System.out.println("Division is : "+division);
		System.out.println("Modulus is : "+modulus);
		System.out.println(number1++);
		System.out.println(++number1);
		System.out.println(--number1);
		System.out.println(number1--);
	}
}
