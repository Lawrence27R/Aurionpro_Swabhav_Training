package com.aurionpro.model;

public class Triangle implements Shape{
	
	private int length;
	private int heigth;
	
	
	public Triangle(int length, int heigth) {
		super();
		this.length = length;
		this.heigth = heigth;
	}


	@Override
	public void area() {
		System.out.println("Area of rectangle : "+(length*heigth)/2);
		
	}

}
