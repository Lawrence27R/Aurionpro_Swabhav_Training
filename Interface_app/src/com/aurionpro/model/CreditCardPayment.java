package com.aurionpro.model;

public class CreditCardPayment implements Payment{
	
	@Override
	public void payBill() {
		System.out.println("Payment made from credit card");
		
	}

	@Override
	public void redeem() {
		System.out.println("Payment redeem in credit card");
		
	}
	
	
}
