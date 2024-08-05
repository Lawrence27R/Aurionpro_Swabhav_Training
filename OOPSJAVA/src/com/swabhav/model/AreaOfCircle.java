package com.swabhav.model;


public class AreaOfCircle {
	
	int radius;
	public AreaOfCircle(int radius)
	{
	this.radius = radius;	
	}
	public double calculateArea(int r) {
		double area = 3.14 * r * r;
		return area;
	}

	
}
