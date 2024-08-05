package com.aurionpro.model;

public class Circle implements Shape{
	private int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}


	@Override
	public void area() {
		System.out.println("Area of Circle is : "+(3.14*radius*radius));
		
	}
	
	
}
