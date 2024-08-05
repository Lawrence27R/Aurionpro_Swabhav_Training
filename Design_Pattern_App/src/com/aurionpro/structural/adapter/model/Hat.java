package com.aurionpro.structural.adapter.model;

public class Hat {
	private String shortName;
	private String longName;
	private double basicPrice;
	private double tax;
	
	public Hat(String shortName, String longName, double basicPrice, double tax) {
		super();
		this.shortName = shortName;
		this.longName = longName;
		this.basicPrice = basicPrice;
		this.tax = tax;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public double getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(double basicPrice) {
		this.basicPrice = basicPrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Hat [shortName=" + shortName + ", longName=" + longName + ", basicPrice=" + basicPrice + ", tax=" + tax
				+ "]";
	}
	
	
}
