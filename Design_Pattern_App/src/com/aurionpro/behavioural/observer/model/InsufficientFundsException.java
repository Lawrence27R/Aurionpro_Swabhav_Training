package com.aurionpro.behavioural.observer.model;

public class InsufficientFundsException extends Exception{
	public String getMessage() {
		return "The withdrawal amount is greater than the balance";
	}
}
