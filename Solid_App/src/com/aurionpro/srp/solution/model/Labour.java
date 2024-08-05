package com.aurionpro.srp.solution.model;

//ISP SOLID PRINCIPLES
public class Labour implements IWorkable, ILunchInterval{

	@Override
	public void eat() {
		System.out.println("Labour has started to eat.");
		
	}

	@Override
	public void rest() {
		System.out.println("Labour has started to rest.");
		
	}

	@Override
	public void start() {
		System.out.println("Labour has started the work.");
		
	}

	@Override
	public void stop() {
		System.out.println("Labour has stopped the work.");
		
	}

}
