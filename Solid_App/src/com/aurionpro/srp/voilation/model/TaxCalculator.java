package com.aurionpro.srp.voilation.model;

//Dependency Inversion principle Solid Principles
public class TaxCalculator {
	private int amount;
	private int rate;
	
	public TaxCalculator() {
		super();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
	public int calculateTax(int amount, int rate) {
		int tax = 0;
		try {
			tax = amount/rate;
			System.out.println("Tax calulated is :"+tax);
		}
		catch(Exception e) {
			new DBLogger().log("Divide by zero");
		}
		return tax;
	}
	@Override
	public String toString() {
		return "TaxCalculator [amount=" + amount + ", rate=" + rate + "]";
	}
	
	
}
