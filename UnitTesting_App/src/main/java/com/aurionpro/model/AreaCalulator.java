package com.aurionpro.model;

public class AreaCalulator {

	public double AreaOfCircle(double radius) {
		return 3.14 * radius * radius;
	}

	public double AreaOfRectangle(double length, double breadth) {
		return length * breadth;
	}

	public double AreaOfTriangle(double length, double height) {
		return 0.5 * length * height;
	}
}
