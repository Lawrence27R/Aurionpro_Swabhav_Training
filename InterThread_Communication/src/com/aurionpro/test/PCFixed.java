package com.aurionpro.test;

import com.aurionpro.model.Q;
import com.aurionpro.model.Producer;
import com.aurionpro.model.Consumer;
class PCFixed {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}
}
