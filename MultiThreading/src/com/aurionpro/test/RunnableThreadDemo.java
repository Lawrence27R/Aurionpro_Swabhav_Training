package com.aurionpro.test;

import com.aurionpro.model.RunnableThread;

public class RunnableThreadDemo {
	public static void main(String[] args) {
		RunnableThread thread1 =  new RunnableThread("Thread1");
		RunnableThread thread2 =  new RunnableThread("Thread2");
		RunnableThread thread3 =  new RunnableThread("Thread3");
		
//		Check before 
		System.out.println(thread1.getThread().isAlive());
		System.out.println(thread2.getThread().isAlive());
		System.out.println(thread3.getThread().isAlive());
		
		
		thread1.getThread().setPriority(Thread.MAX_PRIORITY);
		thread2.getThread().setPriority(Thread.MIN_PRIORITY);
		thread3.getThread().setPriority(Thread.NORM_PRIORITY);
		for (int i=5; i>0; i--) {
			System.out.println(Thread.currentThread().getName()+ " : "+i);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		First complete the thread and then run
		
		try {
			thread1.getThread().join();
			thread2.getThread().join();
			thread3.getThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(thread1.getThread().isAlive());
		System.out.println(thread2.getThread().isAlive());
		System.out.println(thread3.getThread().isAlive());
		
	}
}
