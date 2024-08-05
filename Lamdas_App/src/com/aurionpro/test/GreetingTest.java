package com.aurionpro.test;

import com.aurionpro.model.IGreeting;

public class GreetingTest {
	public static void main(String[] args) {
		
		IGreeting greet = (name) -> System.out.println("Hello "+name);
		greet.say("World");
	}	
}
