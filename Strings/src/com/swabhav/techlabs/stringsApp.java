package com.swabhav.techlabs;

public class stringsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name1 = "AT";
		String name2 = "AT";
		
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());
		System.out.println(name1 == name2);
		String name3 = "M";
		System.out.println(name3.hashCode());
		name3 = name3 + "B";
		System.out.println(name3.hashCode());
		
		// new object is created
		String name11 = new String("AT");
		String name22 = new String("AT");
		System.out.println(name11 == name22);
		
		//can be changed mutable
		StringBuffer name12 = new StringBuffer("Lawrence");
		System.out.println(name12.hashCode());
		name12 = name12.append("Rodriques");
		System.out.println(name12.hashCode());
		
		
		StringBuilder name123 = new StringBuilder("Lawrence");
		System.out.println(name123.hashCode());
		name123 = name123.append("Rodriques");
		System.out.println(name123.hashCode());
	}

}
