package com.aurionpro.structural.decorators.model;

public class PremiumHat implements IHat{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Nike Premium Hat";
	}

	@Override	
	public double getPrice() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "This is Premium Nike Hat.";
	}

}
