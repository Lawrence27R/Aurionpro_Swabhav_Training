package com.aurionpro.structural.decorators.model;

public class StandardHat implements IHat{

	@Override
	public String getName() {
		return "Nike Standard Hat";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 300;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "This is a standard Nike hat.";
	}

}
