package com.aurionpro.structural.decorators.model;

public class GoldenHat extends HatDecorator{

	public GoldenHat(IHat hat) {
		super(hat);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return hat.getName()+"Golden Color";
	}
	
	public double getPrice() {
		// TODO Auto-generated method stub
		return 800+hat.getPrice();
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return hat.getDescription()+" With golden color.";
	}
}
