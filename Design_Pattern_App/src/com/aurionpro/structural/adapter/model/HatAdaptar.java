package com.aurionpro.structural.adapter.model;

public class HatAdaptar implements IItems{
	private Hat hat;

	public HatAdaptar(Hat hat) {
		super();
		this.hat = hat;
	}

	@Override
	public String getItemName() {
		return hat.getLongName();
	}

	@Override
	public double getItemPrice() {
		return hat.getBasicPrice() + hat.getTax();
	}
	
}
