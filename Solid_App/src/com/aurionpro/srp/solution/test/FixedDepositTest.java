package com.aurionpro.srp.solution.test;

import com.aurionpro.srp.solution.model.DiwaliInterest;
import com.aurionpro.srp.solution.model.FixedDeposit;
import com.aurionpro.srp.solution.model.HoliInterest;
import com.aurionpro.srp.solution.model.IFestivalInterest;

//OSP SOLID PRINCIPLES
public class FixedDepositTest {
	public static void main(String[] args) {
		IFestivalInterest diwali = new DiwaliInterest();
		IFestivalInterest holi = new HoliInterest();
		
		FixedDeposit fixedDeposit1 = new FixedDeposit(111, "Lawrence", 5000, 4);
		FixedDeposit fixedDeposit2 = new FixedDeposit(222, "Rodriques", 6000, 5);
		
		System.out.println("Simple interest of diwali :"+fixedDeposit1.simpleInterestCalculator(diwali));
		System.out.println("Simple interest of diwali :"+fixedDeposit2.simpleInterestCalculator(holi));
	}
}
