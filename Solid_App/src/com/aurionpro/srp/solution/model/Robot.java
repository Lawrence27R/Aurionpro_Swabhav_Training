package com.aurionpro.srp.solution.model;

//ISP SOLID PRINCIPLES
public class Robot implements IWorkable{

	@Override
	public void start() {
		System.out.println("Robot has started the work.");
		
	}

	@Override
	public void stop() {
		System.out.println("Robot has stopped the work.");
		
	}

}
