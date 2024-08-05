package com.aurionpro.creational.factory.abstractcar.model;

public class Tata implements ICar{

	@Override
	public void start() {
		System.out.println("Tata car started.");
		
	}

	@Override
	public void stop() {
		System.out.println("Tata car stopped.");
		
	}

}
