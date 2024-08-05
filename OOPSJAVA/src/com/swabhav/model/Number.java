package com.swabhav.model;

public class Number {
	private int value;
	
	
	public Number(int value) {
		this.value=value;
	}
	
//	cannot be accessed it can only be accessed within same class in same package
//	private int getValue() {
//		return value;
//	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
