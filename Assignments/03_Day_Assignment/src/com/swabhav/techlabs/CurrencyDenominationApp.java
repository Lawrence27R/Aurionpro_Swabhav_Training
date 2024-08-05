package com.swabhav.techlabs;

import java.util.Scanner;

public class CurrencyDenominationApp {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter withdrawal amount : ");
		int withdrawalAmt = sc.nextInt();
		
		
		if (withdrawalAmt > 100 && withdrawalAmt <= 50000) {
			if (withdrawalAmt % 100 == 0) {
				
				int twoThousandNotes = withdrawalAmt / 2000;
				int amountLeft1 = withdrawalAmt % 2000;
				int fiveHundredNotes = amountLeft1 / 500;
				int amountLeft2 = amountLeft1 % 500;
				int twoHundredNotes = amountLeft2 / 200;
				int amountLeft3 = amountLeft2 % 200;
				int hundredNotes = amountLeft3 / 100;
				int amountLeft4 = amountLeft3 % 100;
				
				System.out.println("Two Thousand : "+twoThousandNotes);
				System.out.println("Five Hundred : "+fiveHundredNotes);
				System.out.println("Two Hundred : "+twoHundredNotes);
				System.out.println("One Hundred : "+hundredNotes);
			}
			else {
				System.out.println("Withdrawal should be multiple of 100");
			}
		}
		else {
			System.out.println("Amount exceeds withdrwal limit of 50000");
		}
	}
}
