package com.swabhav.techlabs;

import java.util.Scanner;

public class BodyMassIndexCalculator {
	
	public static void main(String[] args) {
		System.out.println("Enter weight of the person in Kg :");
		Scanner sc1 = new Scanner(System.in);
		double weight = sc1.nextDouble();
		
		System.out.println("Enter height of the person in meters :");
		Scanner sc2 = new Scanner(System.in);
		double height = sc2.nextDouble();
		
		double bodyMassIndex = weight/(height * height);
		System.out.println("The Body Mass Index (BMI) of a person is : "+bodyMassIndex);
		
	}
}
