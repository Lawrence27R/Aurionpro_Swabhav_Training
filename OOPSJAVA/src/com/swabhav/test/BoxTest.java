package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.Box;

public class BoxTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Box box1 = new Box(20, 30);
		System.out.println(box1);
		
		box1.display();
//		System.out.println("Enter Width : ");
//		int w = sc.nextInt();
//		box1.setWidth(w);
//		System.out.println("Enter Height : ");
//		int h =sc.nextInt();
//		box1.setHeight(h);
//		System.out.println("Enter Depth : ");
//		int d = sc.nextInt();
//		box1.setDepth(d);
//		box1.display();
		
		System.out.println("Area of box1 : "+box1.calculateArea());

	}
}
