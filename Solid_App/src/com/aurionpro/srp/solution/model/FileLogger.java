package com.aurionpro.srp.solution.model;

//Dependency Inversion principle Solid Principles
public class FileLogger implements ILogger{

	@Override
	public void log(String error) {
		System.out.println("Logged to database "+error);
		
	}

}
