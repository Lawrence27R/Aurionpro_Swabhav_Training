package com.aurionpro.behavioural.observer.model;

public class EmailNotifier implements INotifier{

	@Override
	public void notify(Account account, String message) {
		System.out.println("Sending message through Email "+account.getName() +message);
	}

}
