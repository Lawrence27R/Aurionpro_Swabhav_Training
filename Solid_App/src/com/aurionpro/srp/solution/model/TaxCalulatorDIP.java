package com.aurionpro.srp.solution.model;

//Dependency Inversion principle Solid Principles
public class TaxCalulatorDIP {
	private int amount;
	private int rate;
	private ILogger logger;
	
	public TaxCalulatorDIP() {
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

	public ILogger getLogger() {
		return logger;
	}

	public void setLogger(ILogger logger) {
		this.logger = logger;
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
	
}
