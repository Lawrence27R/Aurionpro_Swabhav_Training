package com.aurionpro.test;

import java.util.Scanner;

public class CalcuAreaOfCircle {
	
	public static void main(String[] args) {
		
		System.out.println("Enter the radius of circle : ");
		Scanner sc = new Scanner(System.in);
		
		int radius = sc.nextInt();
		
		float pi = 3.14f;
		
		double area = pi * radius * radius;
		
		System.out.println("Area of circle with radius " +radius+ " is " +area);
	}
}

//Read principal amout and number of years and rate of interest form user