package com.aurionpro.behavioural.observer.test;

import com.aurionpro.behavioural.observer.model.Account;
import com.aurionpro.behavioural.observer.model.EmailNotifier;
import com.aurionpro.behavioural.observer.model.INotifier;
import com.aurionpro.behavioural.observer.model.InsufficientFundsException;
import com.aurionpro.behavioural.observer.model.SMSNotifier;
import com.aurionpro.behavioural.observer.model.WhatsappNotifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args) {
		Account account = new Account(123456, "Lawrence", 1000);

		System.out.println("Select the notifications you want (enter numbers separated by spaces):");
		System.out.println("1. SMS");
		System.out.println("2. Email");
		System.out.println("3. WhatsApp");

		Scanner scanner = new Scanner(System.in);

		List<INotifier> notifiers =  new ArrayList<>();
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			notifiers.add(new SMSNotifier());
		case 2:
			notifiers.add(new EmailNotifier());
		case 3:
			notifiers.add(new WhatsappNotifier());
		default:
			System.out.println("Invalid choice: ");
			break;
		}

		for (INotifier notifier : notifiers) {
			account.registerNotifier(notifier);
		}

		account.deposit(5000);
		try {
			account.withdrawal(20000);
		} catch (InsufficientFundsException exception) {
			// TODO Auto-generated catch block
			System.out.println(exception.getMessage());
		}
	}
}
