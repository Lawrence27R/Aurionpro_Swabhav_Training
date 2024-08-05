package com.aurionpro.srp.voilation.test;

import com.aurionpro.srp.voilation.model.Invoice;

public class InvoiceTest {
	public static void main(String[] args) {
		
		Invoice invoice = new Invoice(1, "Mobile Phone", 15000, 10);
		
		invoice.print();
	}
}
