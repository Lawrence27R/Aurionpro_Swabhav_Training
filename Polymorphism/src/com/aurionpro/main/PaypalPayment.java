package com.aurionpro.main;

public class PaypalPayment extends Payment{

	@Override
	public void payBill() {
		System.out.println("Payment made from paypal");
		
	}

	@Override
	public void redeem() {
		System.out.println("Payment redeem in paypal");
		
	}
	
	

}
