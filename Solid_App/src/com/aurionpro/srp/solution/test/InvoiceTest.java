package com.aurionpro.srp.solution.test;

import com.aurionpro.srp.solution.model.DetailsPrinter;
import com.aurionpro.srp.solution.model.Invoice;
import com.aurionpro.srp.solution.model.TaxCalulator;

public class InvoiceTest {

	public static void main(String[] args) {
		Invoice invoice = new Invoice(1, "Mobile Phone", 15000, 10);
		TaxCalulator taxcalulator = new TaxCalulator(invoice);
		DetailsPrinter printer = new DetailsPrinter(invoice, taxcalulator);
		
		printer.print();
	}
}
