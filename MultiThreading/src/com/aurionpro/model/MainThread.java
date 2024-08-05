package com.aurionpro.model;

public class MainThread {
	public static void main(String[] args) {
			Thread thread = Thread.currentThread();
			System.out.println(thread);
			
			thread.setName("New Thread");
			System.out.println(thread);
			
			for (int i=5; i>0; i--) {
				System.out.println(thread.currentThread().getName()+ " : "+i);
				try {
					thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
