package com.aurionpro.srp.solution.test;

import com.aurionpro.srp.solution.model.FileLogger;
import com.aurionpro.srp.solution.model.TaxCalulatorDIP;

//Dependency Inversion principle Solid Principles
public class TaxCalculatorDIP {
	public static void main(String[] args) {
		TaxCalulatorDIP t1 = new TaxCalulatorDIP();
		t1.calculateTax(1000, 20);
		
		t1.setLogger(new FileLogger());
		TaxCalulatorDIP t2 = new TaxCalulatorDIP();
		t2.calculateTax(2000, 0);
	}
}
