package com.aurionpro.main;

public class BankTransferPayment extends Payment{

	@Override
	public void payBill() {
		System.out.println("Payment made through bank transfer");
		
	}

	@Override
	public void redeem() {
		System.out.println("Payment redeem in bank account");
		
	}

}
