package com.aurionpro.model;

public class Guitar {
	private String serialNumber;
	private double price;
	GuitarSpecs spec;
	
	public Guitar(String serialNumber, double price, GuitarSpecs spec) {
		super();
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public GuitarSpecs getSpec() {
		return spec;
	}

	public void setSpec(GuitarSpecs spec) {
		this.spec = spec;
	}
	
	
}
