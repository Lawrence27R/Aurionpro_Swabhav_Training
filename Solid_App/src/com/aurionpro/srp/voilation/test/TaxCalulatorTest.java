package com.aurionpro.srp.voilation.test;

import com.aurionpro.srp.voilation.model.TaxCalculator;

//Dependency Inversion principle Solid Principles
public class TaxCalulatorTest {
	public static void main(String[] args) {
		TaxCalculator t1 = new TaxCalculator();
		t1.calculateTax(1000, 20);
		
		TaxCalculator t2 = new TaxCalculator();
		t2.calculateTax(2000, 0);
	}
}
