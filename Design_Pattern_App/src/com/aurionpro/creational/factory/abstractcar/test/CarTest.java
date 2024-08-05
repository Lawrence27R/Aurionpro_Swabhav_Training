package com.aurionpro.creational.factory.abstractcar.test;

import com.aurionpro.creational.factory.abstractcar.model.ICar;
import com.aurionpro.creational.factory.abstractcar.model.ICarFactory;
import com.aurionpro.creational.factory.abstractcar.model.MahindraFactory;
import com.aurionpro.creational.factory.abstractcar.model.MarutiFactory;
import com.aurionpro.creational.factory.abstractcar.model.TataFactory;

public class CarTest {
	public static void main(String[] args) {
		ICar car;
		ICarFactory marutiFactory = new MarutiFactory();
		
		car = marutiFactory.makeCar();
		car.start();
		car.stop();
		
		ICarFactory tataFactory = new TataFactory();
		
		car = tataFactory.makeCar();
		car.start();
		car.stop();
		
		ICarFactory mahindraFactory = new MahindraFactory();
		
		car = mahindraFactory.makeCar();
		car.start();
		car.stop();
	}
}
