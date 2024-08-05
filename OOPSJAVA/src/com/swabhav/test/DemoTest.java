package com.swabhav.test;

import com.swabhav.model.Demo;

public class DemoTest {
	public static void main(String[] args) {
		System.out.println("Jadu");
		Demo demo1 = new Demo();
		demo1.display();
		demo1.increment();
		demo1.display();

		Demo demo2 = new Demo();
		demo2.display();
		demo2.increment();
		demo2.display();

		Demo demo3 = new Demo();
		demo3.display();
		demo3.increment();
		demo3.display();
	}
	
}
