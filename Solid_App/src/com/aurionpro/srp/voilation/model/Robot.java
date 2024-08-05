package com.aurionpro.srp.voilation.model;

//ISP SOLID PRINCIPLES
public class Robot implements IWorker{

	@Override
	public void startWork() {
		System.out.println("Robot has started the work.");
		
	}

	@Override
	public void stopWork() {
		System.out.println("Robot has stopped the work.");
		
	}

	@Override
	public void eat() {
		System.out.println("Robot has started to eat.");
		
	}

	@Override
	public void drink() {
		System.out.println("Robot has started to drink.");
		
	}

}
