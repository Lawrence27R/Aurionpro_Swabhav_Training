package com.aurionpro.behavioural.observer.model;

public class WhatsappNotifier implements INotifier{

	@Override
	public void notify(Account account, String message) {
		System.out.println("Sending message through Whatsapp "+account.getName() +message);
	}

}
