package com.aurionpro.main;

public class CreditCardPayment extends Payment{
	
	@Override
	public void payBill() {
		System.out.println("Payment made from credit card");
		
	}

	@Override
	public void redeem() {
		System.out.println("Payment redeem in credit card");
		
	}
	
	
}
