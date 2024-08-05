package com.aurionpro.test;

import com.aurionpro.model.MyThread;

public class DemoThread {
	public static void main(String[] args) {
		MyThread thread =  new MyThread("New Thread");
		
		for (int i=5; i>0; i--) {
			System.out.println(Thread.currentThread().getName()+ " : "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
