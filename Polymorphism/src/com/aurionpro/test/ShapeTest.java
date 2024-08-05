package com.aurionpro.test;

import com.aurionpro.main.Circle;
import com.aurionpro.main.Rectangle;
import com.aurionpro.main.Shape;
import com.aurionpro.main.Triangle;

public class ShapeTest {
	
	public static void main(String[] args) {
		
		Shape shape;
		
		shape = new Circle(5);
		shape.area();
		shape= new Rectangle(10, 15);
		shape.area();
		shape = new Triangle(10, 15);
		shape.area();
	}
}
