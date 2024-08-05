package com.aurionpro.model;

public  class Demo {
	private int a = 1;
	static private int b = 1;
	private int c = 1;

	public void increment() {
		a++;
		b++;
		c++;
	}

	public void display() {
		System.out.print("a : " + a + "\t");
		System.out.print("b : " + b + "\t");
		System.out.print("c : " + c + "\t");
		System.out.println();
	}
	static
	{
		System.out.println("Hello");
	}
	static
	{
		System.out.println("Hellos");
	}
}
