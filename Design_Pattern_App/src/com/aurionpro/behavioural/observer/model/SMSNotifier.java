package com.aurionpro.behavioural.observer.model;

public class SMSNotifier implements INotifier{

	@Override
	public void notify(Account account, String message) {
		System.out.println("Sending message through SMS "+account.getName() +message);
		
	}


}
