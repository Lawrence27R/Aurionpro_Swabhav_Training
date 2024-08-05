package com.aurionpro.model;

public class Reference {

	public Reference() {
		System.out.println("Inside Constructor");
	}
	
	public static void staticPrint() {
		System.out.println("Inside Static method");
	}
	
	public void print() {
		System.out.println("Inside non static method");
	}
}
