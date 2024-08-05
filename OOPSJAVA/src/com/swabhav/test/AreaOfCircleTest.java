package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.AreaOfCircle;

public class AreaOfCircleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius : ");
		int radius = sc.nextInt();
		AreaOfCircle areaOfCricle = new AreaOfCircle(radius);
		System.out.println("Area of circle : "+areaOfCricle.calculateArea(radius));
		sc.close();
	}

}
