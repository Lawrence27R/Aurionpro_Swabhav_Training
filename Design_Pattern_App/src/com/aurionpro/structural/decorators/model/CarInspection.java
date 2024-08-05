package com.aurionpro.structural.decorators.model;

public class CarInspection implements ICarService{

	@Override
	public double getCost() {
		System.out.println("Car service cost :");
		return 1000;
	}

}
