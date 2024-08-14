package com.aurionpro.model;

public class Harddisk {
	private int capacity;
	
	public Harddisk() {
		System.out.println("Inside Harddisk Constructor");
	}
	
	public Harddisk(int capacity) {
		super();
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		System.out.println("Inside Harddisk Setter");
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "HardDisk [capacity=" + capacity + "]";
	}
	
	
}
