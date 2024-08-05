package com.aurionpro.test;

import java.util.Scanner;

public class test {
	
	public static void main(String[] args) {
		
//		long num1 = 250L;
//		
//		float num2 = 3.9F;
//		
//		double num3 = 3456;
//		
//		char name = "Lawrence";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number 1:");
		int num1 = sc.nextInt();
		
		System.out.println("Enter Number 2:");
		int num2 = sc.nextInt();
		
		int result = num1 + num2;
		
		System.out.println("Addition of " + num1 + " and " + num2 + " is  " +result);
		
		
	}

}
