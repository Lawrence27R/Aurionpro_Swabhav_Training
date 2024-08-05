package day._04;

import java.util.Scanner;

public class SimpleAtmSimulation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float balance = 1000f;
		int choice;
		
		while (true) {
			System.out.println("ATM Menu:");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1: System.out.println("Your current balance is: $"+balance);
			break;
			case 2: System.out.println("Enter amount to deposit : ");
			float depositAmount = sc.nextFloat();
			System.out.println("You have deposited $"+depositAmount+" Your new balance is $"+(balance+depositAmount));
			balance += depositAmount; 
			break;
			case 3: System.out.println("Enter amount to withdraw : ");
			float withdrawalAmount = sc.nextFloat();
			if (withdrawalAmount > balance) {
				System.out.println("Your Account Balance is less than the amount you want to withdraw");
			}
			else {
				System.out.println("You have deposited $"+withdrawalAmount+". Your new balance is $"+(balance-withdrawalAmount));
			}
			break;
			case 4: System.out.println("Thank you for using the ATM. Goodbye!");
			break;
			default : System.out.println("Invalid input. Please select correct option");
			}
		}
			
	}
}
