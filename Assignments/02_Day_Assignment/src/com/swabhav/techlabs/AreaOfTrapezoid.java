package com.swabhav.techlabs;

import java.util.Scanner;

public class AreaOfTrapezoid {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the first base value : ");
		float firstBaseValue = sc.nextFloat();
		
		System.out.println("Enter the second base value : ");
		float secondBaseValue = sc.nextFloat();
		
		System.out.println("Enter the height value : ");
		float height = sc.nextFloat();
		
		float areaOfTrapezoid = (firstBaseValue + secondBaseValue)/2 *height;
		System.out.println("The area of Trapezoid is : "+areaOfTrapezoid);
	}
}
