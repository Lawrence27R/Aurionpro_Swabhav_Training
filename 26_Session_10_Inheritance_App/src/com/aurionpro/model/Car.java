package com.aurionpro.model;

public class Car extends FourWheeler{
private double price;

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public Car(String companyName,double milage, double price) {
	super(companyName,milage);
	this.price = price;
}

@Override
public String toString() {
	return "Car [price=" + price + ", Mileage=" + getMileage() + ", CompanyName=" + getCompanyName()
			+  "]";
}
}
