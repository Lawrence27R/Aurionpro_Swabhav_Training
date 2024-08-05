package com.swabhav.techlabs;

import java.util.Scanner;

public class DistanceBwtTwoPointsCalculator {
	public static void main(String[] args) {
		
		System.out.println("Enter the co-ordinates of first point : ");
		System.out.println("Enter x-coordinate : ");
		Scanner sc1 = new Scanner(System.in);
		
		float x_CoordinateFirstPoint = sc1.nextFloat();
		System.out.println("Enter y-coordinate : ");
		Scanner sc2 = new Scanner(System.in);
		
		float y_CoordinateFirstPoint = sc2.nextFloat();
		
		System.out.println("Enter the co-ordinates of second point : ");
		System.out.println("Enter x-coordinate : ");
		Scanner sc3 = new Scanner(System.in);
		
		float x_CoordinateSecondPoint = sc3.nextFloat();
		System.out.println("Enter y-coordinate : ");
		Scanner sc4 = new Scanner(System.in);
		
		float y_CoordinateSecondPoint = sc4.nextFloat();
		
		float distanceBtwTwoPoints = (float) Math.sqrt(Math.pow(x_CoordinateSecondPoint - x_CoordinateFirstPoint, 2) 
				+ Math.pow(y_CoordinateSecondPoint - y_CoordinateFirstPoint, 2));
		
		System.out.println("The distance between two points "+x_CoordinateFirstPoint+","+ y_CoordinateFirstPoint+" and "
				+ ""+x_CoordinateSecondPoint+","+y_CoordinateSecondPoint+" is "+distanceBtwTwoPoints);
	}
}
