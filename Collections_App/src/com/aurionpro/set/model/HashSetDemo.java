package com.aurionpro.set.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo {
	public static void main(String[] args) {
		
//		Random set entry by creating hash
//		Set<String> stringset1 = new HashSet<String>();
		
//		User defined entry
//		LinkedHashSet<String> stringset1 = new LinkedHashSet<String>();
		
//		Sorted entry in the set
		TreeSet<String> stringset1 = new TreeSet<String>();
		
		stringset1.add("Apple");
		stringset1.add("Mango");
		stringset1.add("Banana");
		
		System.out.println(stringset1);
		System.out.println();
		
		Set<String> stringset2 = new HashSet<String>();
		
		stringset2.add("Grapes");
		stringset2.add("Oranges");
		stringset2.add("Chickoo");
		
		System.out.println(stringset2);
		
		System.out.println("Adding both the sets : ");
		stringset1.addAll(stringset2);
		System.out.println(stringset1);
		
		System.out.println(stringset1.contains("PineApple"));
	}
}
