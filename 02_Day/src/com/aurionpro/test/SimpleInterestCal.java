package com.aurionpro.test;

import java.util.Scanner;

public class SimpleInterestCal {

	public static void main(String[] args) {

		System.out.println("Enter the princial amount : ");
		Scanner sc1 = new Scanner(System.in);

		int principal = sc1.nextInt();

		System.out.println("Enter the rate of interest : ");
		Scanner sc2 = new Scanner(System.in);

		double rate = sc2.nextFloat();

		System.out.println("Enter time : ");
		Scanner sc3 = new Scanner(System.in);

		int time = sc3.nextInt();

		double result = (principal * rate * time )/100;
		
		
		System.out.println("Simple Interest Calculated is "+result);
	}
}
