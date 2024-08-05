package com.aurionpro.structural.facade.model;

public class DVDPlayer implements IDVDPlayer{
	
	public void on(){
		System.out.println("DVD player on");
	}
	public void off(){
		System.out.println("DVD player off");
	}
	public void start(){
		System.out.println("DVD player started");
	}
	public void stop(){
		System.out.println("DVD player stopped");
	}
}
