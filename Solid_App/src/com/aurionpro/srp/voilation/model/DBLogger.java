package com.aurionpro.srp.voilation.model;

//Dependency Inversion principle Solid Principles
public class DBLogger {
	public void log (String error) {
		System.out.println("Logged to database "+error);
	}
}
