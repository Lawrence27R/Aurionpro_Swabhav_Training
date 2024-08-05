package com.aurionpro.test;

import com.aurionpro.model.Circle;
import com.aurionpro.model.Rectangle;
import com.aurionpro.model.Shape;
import com.aurionpro.model.Triangle;

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
