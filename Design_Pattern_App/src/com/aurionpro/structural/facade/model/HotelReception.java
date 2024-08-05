package com.aurionpro.structural.facade.model;

public class HotelReception {

	public void getIndianMenu(){
		IHotel indianHotel = new IndianHotel();
		IMenu menu = indianHotel.getMenu();
		menu.displayMenu();
	}
	
//	public void getI(){
//		IHotel indianHotel = new IndianHotel();
//		IMenu menu = indianHotel.getMenu();
//		menu.displayMenu();
//	}
}
