package com.aurionpro.model;

public class PaypalPayment implements Payment{

	@Override
	public void payBill() {
		System.out.println("Payment made from paypal");
		
	}

	@Override
	public void redeem() {
		System.out.println("Payment redeem in paypal");
		
	}
	
	

}
