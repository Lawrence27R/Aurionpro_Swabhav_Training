package com.aurionpro.test;

import com.aurionpro.main.Base;
import com.aurionpro.main.Derived1;
import com.aurionpro.main.Derived2;

public class Test {
	public static void main(String[] args) {
		Base base = new Base();
		base.display();
		
		Derived1 derived1 = new Derived1();
		derived1.display();
		base = derived1;
		
		base = new Derived2();
		base.display();
	}
}
