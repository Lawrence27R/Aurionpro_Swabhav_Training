package com.aurionpro.structural.decorators.model;

public class RibbionHat extends HatDecorator{

	public RibbionHat(IHat hat) {
		super(hat);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return hat.getName()+" Ribbon Strips";
	}
	
	public double getPrice() {
		// TODO Auto-generated method stub
		return 500+hat.getPrice();
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return hat.getDescription()+" With ribbon strips";
	}
}
