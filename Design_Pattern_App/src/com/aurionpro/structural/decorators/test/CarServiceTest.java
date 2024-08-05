package com.aurionpro.structural.decorators.test;

import com.aurionpro.structural.decorators.model.CarInspection;
import com.aurionpro.structural.decorators.model.ICarService;
import com.aurionpro.structural.decorators.model.OilChange;
import com.aurionpro.structural.decorators.model.WheelAlign;

public class CarServiceTest {
	public static void main(String[] args) {
		ICarService carService = new CarInspection();
		
		OilChange oilChange = new OilChange(carService);
		WheelAlign wheelAlign = new WheelAlign(oilChange);
		
		System.out.println("Service Cost : "+carService.getCost());
		System.out.println("Oil Change Cost : "+oilChange.getCost());
		System.out.println("Wheel Align Cost : "+wheelAlign.getCost());
	}
}
