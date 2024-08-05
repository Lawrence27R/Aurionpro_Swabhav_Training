package com.swabhav.techlabs;

import java.util.Scanner;

public class CompoundInterestCalculator {
	
	public static void main(String[] args) {
		
		System.out.println("Compound Interest Calulator");
		System.out.println("Enter the Principal Amount :");
		Scanner sc = new Scanner(System.in);
		int princialAmt = sc.nextInt();
		
		System.out.println("Enter the Principal Amount :");
		double rateOfInterest = sc.nextDouble();
		
		System.out.println("Enter the Principal Amount :");
		int time = sc.nextInt();
		
	    System.out.print("Enter number of times interest is compounded: ");
	    int number = sc.nextInt();
		
	    double compoundInterest = princialAmt * (Math.pow((1 + rateOfInterest/100), (time * number))) - princialAmt;
		System.out.println("Compound Interest Calculated is : "+compoundInterest);
	}
}
