package com.aurionpro.list.model;

public class Car {
	private int carId;
	private String companyName;
	private double price;
	private double mileage;
	public Car(int carId, String companyName, double price, double mileage) {
		super();
		this.carId = carId;
		this.companyName = companyName;
		this.price = price;
		this.mileage = mileage;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", companyName=" + companyName + ", price=" + price + ", mileage=" + mileage
				+ "]";
	}
	
	
}
