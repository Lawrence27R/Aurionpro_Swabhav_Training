package com.aurionpro.list.test;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		System.out.println(names.size());
		names.add("Lawrence");
		names.add("Suhas");
		names.add("Swapnil");
//		names.add(10);
		names.get(1);
		System.out.println(names.equals(names));
		
		System.out.println(names.hashCode());
		System.out.println(names);
		names.clear();
	}
	
}
