package com.aurionpro.srp.voilation.model;


//ISP Solid Principles
public class Labour implements IWorker{

	@Override
	public void startWork() {
		System.out.println("Labour has started the work.");
		
	}

	@Override
	public void stopWork() {
		System.out.println("Labour has stopped the work.");
		
	}

	@Override
	public void eat() {
		System.out.println("Labour has started to eat.");
		
	}

	@Override
	public void drink() {
		System.out.println("Labour has started to drink.");
		
	}
	
}
