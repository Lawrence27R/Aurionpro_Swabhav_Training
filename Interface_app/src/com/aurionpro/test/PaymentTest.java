package com.aurionpro.test;

import com.aurionpro.model.BankTransferPayment;
import com.aurionpro.model.CreditCardPayment;
import com.aurionpro.model.Payment;
import com.aurionpro.model.PaypalPayment;

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
