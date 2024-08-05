package com.aurionpro.test;

import com.aurionpro.model.ITest;
import com.aurionpro.model.Reference;

public class ReferenceTest {
	public static void main(String[] args) {
		
		ITest test1 = Reference::new;
		display(test1);
		
		ITest test2 = Reference::staticPrint;
		display(test2);
		
		Reference reference = new Reference();
		ITest test3 = reference::print;
		display(test3);
	}
	
	private static void display(ITest test) {
		test.test();
	}
}
