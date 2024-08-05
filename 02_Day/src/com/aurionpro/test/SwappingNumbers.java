package com.aurionpro.test;

import java.util.Scanner;

public class SwappingNumbers {
	
	public static void main(String[] args) {
		
		System.out.println("Enter Number 1:");
		Scanner sc1 = new Scanner(System.in);
		
		int num1 = sc1.nextInt();
		
		System.out.println("Enter Number 2:");
		Scanner sc2 = new Scanner(System.in);
		int num2 = sc2.nextInt();
		
		int temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("After Swapping " + "Number1 is " +num1+" and number2 is " +num2 );
	}

}
