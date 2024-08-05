package com.aurionpro.structural.adapter.test;

import java.util.List;

import com.aurionpro.structural.adapter.model.Biscuit;
import com.aurionpro.structural.adapter.model.Hat;
import com.aurionpro.structural.adapter.model.HatAdaptar;
import com.aurionpro.structural.adapter.model.IItems;
import com.aurionpro.structural.adapter.model.ShoppingCart;

public class ShoppingCartTest {
	public static void main(String[] args) {
		
        ShoppingCart cart = new ShoppingCart();

        Biscuit biscuit = new Biscuit();
        Hat hat = new Hat("Topi", "Louis Vitton", 100, 10);
        HatAdaptar hatAdaptar = new HatAdaptar(hat);
        
        List<IItems> items = cart.getCartItems();
        for (IItems item : items) {
            System.out.println("Item Name: " + item.getItemName());
            System.out.println("Item Price: " + item.getItemPrice());
        }

        System.out.println("Total Cart Price: " + cart.getCartPrice());
	}
}
