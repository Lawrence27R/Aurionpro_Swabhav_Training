package com.swabhav.techlabs;

import java.util.Scanner;

public class WaterBillCalculator {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of units consumed :");
		int numUnits = sc.nextInt();
		
		int meterCharge = 75;
		
		if (numUnits <= 100) {
			int charge = numUnits * 5;
			int totalWaterBill = charge + meterCharge;
			System.out.println("Total Water bill of "+numUnits+ " units cosumed is "+totalWaterBill);
		}
		else {
			if (numUnits <= 250) {
				int charge = (100*5) + (numUnits-100) * 10;
				int totalWaterBill = charge + meterCharge;
				System.out.println("Total Water bill of "+numUnits+ " units cosumed is "+totalWaterBill);
			}
			else {
				int charge = (100*5) + ((150) * 10) + (numUnits-250) * 20;
				int totalWaterBill = charge + meterCharge;
				System.out.println("Total Water bill of "+numUnits+ " units cosumed is "+totalWaterBill);
			}
		}
	}
}

//program to check whether the character is vowel or not
