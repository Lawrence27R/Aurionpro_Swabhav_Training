package com.aurionpro.srp.solution.model;

public class TaxCalulator {
	
	private Invoice invoice;
	
	
	public TaxCalulator(Invoice invoice) {
		super();
		this.invoice = invoice;
	}


	public double calculateTax() {
		return  invoice.getAmount() * invoice.getTax()/100;
	}
}
