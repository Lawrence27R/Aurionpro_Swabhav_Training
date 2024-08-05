package com.aurionpro.test;

import com.aurionpro.main.BankTransferPayment;
import com.aurionpro.main.CreditCardPayment;
import com.aurionpro.main.Payment;
import com.aurionpro.main.PaypalPayment;

public class PaymentTest {
	public static void main(String[] args) {
		
		Payment payment;
		payment = new CreditCardPayment();
		payment.payBill();
		payment.redeem();
		payment = new PaypalPayment();
		payment.payBill();
		payment.redeem();
		payment = new BankTransferPayment();
		payment.payBill();
		payment.redeem();
	}
}
