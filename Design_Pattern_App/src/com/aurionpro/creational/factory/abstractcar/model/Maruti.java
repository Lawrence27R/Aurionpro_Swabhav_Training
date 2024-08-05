package com.aurionpro.creational.factory.abstractcar.model;

public class Maruti implements ICar{

	@Override
	public void start() {
		System.out.println("Maruti car started.");
		
	}

	@Override
	public void stop() {
		System.out.println("Maruti car stopped.");
		
	}

}
