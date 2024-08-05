package com.swabhav.techlabs;

import java.util.Scanner;

public class TemperatureConvetor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter temperature: ");
        double temperature = scanner.nextDouble();
        
        System.out.println("Choose conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
        case 1: double fahrenheit = (9*temperature/5) + 32;
        		System.out.println("Temperature converted Celsius to Fahrenheit is :"+fahrenheit);
        		break;
        case 2: double celcuius = (temperature - 32)*5/9;
		System.out.println("Temperature converted Fahrenheit to Celsius is :"+celcuius);
		break;
        case 3: double kelvin = temperature + 273.15;
		System.out.println("Temperature converted Celsius to Kelvin is :"+kelvin);
		break;
        case 4: double kelvinToCel = temperature - 273.15;
		System.out.println("Temperature converted Kelvin to Celsius is :"+kelvinToCel);
		break;
        case 5: double fahToKelvin = (temperature - 32)*5/9 + 273.15;
		System.out.println("Temperature converted Fahrenheit to Kelvin is :"+fahToKelvin);
		break;
        case 6: double kelToFahren = (temperature - 273.15) * 9/5 +32;
		System.out.println("Temperature converted Kelvin to Fahrenheit is :"+kelToFahren);
		break;
		default : System.out.println("Invalid Option");
        }
	}
}
