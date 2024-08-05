package com.aurionpro.model;

public class BankTransferPayment implements Payment{

	@Override
	public void payBill() {
		System.out.println("Payment made through bank transfer");
		
	}

	@Override
	public void redeem() {
		System.out.println("Payment redeem in bank account");
		
	}

}
