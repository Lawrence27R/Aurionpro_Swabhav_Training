package com.swabhav.techlabs;

public class LogicalOperators {
	public static void main(String[] args) {
		
//		    && operator
		   System.out.println((6 > 3) && (8 > 6)); // true
		   System.out.println((6 > 3) && (8 < 6)); // false

//		    || operator
		   System.out.println((6 < 3) || (8 > 6)); // true
		   System.out.println((6 < 3) || (8 < 6)); // false

//		    ! operator
		   System.out.println(!(6 == 3)); // true
		   System.out.println(!(6 > 3)); // false
	}
}
