package com.aurionpro.creational.factory.abstractcar.model;

public class MarutiFactory implements ICarFactory{

	@Override
	public ICar makeCar() {
		return new Maruti();
	}

}
