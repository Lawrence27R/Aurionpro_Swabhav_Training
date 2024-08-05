package com.aurionpro.structural.decorators.model;

public class CarServiceDecorator implements ICarService{
	public ICarService carObj;

	public CarServiceDecorator(ICarService carObj) {
		super();
		this.carObj = carObj;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return carObj.getCost();
	}
	
}
