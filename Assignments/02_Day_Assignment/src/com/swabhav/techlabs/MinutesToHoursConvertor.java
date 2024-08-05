package com.swabhav.techlabs;

import java.util.Scanner;

public class MinutesToHoursConvertor {
	public static void main(String[] args) {
		
		System.out.println("Enter the time in minutes : ");
		Scanner sc1 = new Scanner(System.in);
		
		int timeInMinutes = sc1.nextInt();
		
		int convertedTimeInHours = timeInMinutes/60;
		int convertedTimeInMinutes = timeInMinutes%60;
		
		System.out.println(+timeInMinutes+" Minutes is "+convertedTimeInHours+" Hours and "+convertedTimeInMinutes+" Minutes");
		
		
	}
}
