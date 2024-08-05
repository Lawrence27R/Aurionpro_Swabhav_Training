package com.aurionpro.test;

import com.aurionpro.model.Task;

public class TestDemo {
	public static void main(String[] args) {
		
		for (int i=0; i<10; i++) {
			Thread thread = new Thread(new Task());
			thread.start();
		}
	}
}
