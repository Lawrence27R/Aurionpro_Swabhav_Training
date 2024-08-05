package com.aurionpro.creational.factory.test;

import com.aurionpro.creational.factory.model.CarFactory;
import com.aurionpro.creational.factory.model.ICar;

public class CarTest {
	public static void main(String[] args) {
		ICar car;
		CarFactory carFactory = new CarFactory();
		
		car = carFactory.makeCar("Maruti");
		car.start();
		car.stop();
		
	}
}
