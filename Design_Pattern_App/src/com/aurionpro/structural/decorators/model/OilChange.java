package com.aurionpro.structural.decorators.model;

public class OilChange extends CarServiceDecorator{

	
	public OilChange(ICarService carObj) {
		super(carObj);
		// TODO Auto-generated constructor stub
	}
	
	public double getCost() {
		return 500 + carObj.getCost();
	}
}
