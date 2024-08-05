package com.aurionpro.structural.adapter.model;

import java.util.List;

public class ShoppingCart {
	List<IItems> cartItems;

	public ShoppingCart() {
		super();
		this.cartItems = cartItems;
	}

	public void addItemtoCart(IItems items) {
		cartItems.add(items);
	}

	public List<IItems> getCartItems() {
		return cartItems;
	}

	public double getCartPrice() {
		double totalCartPrice = 0;
		for (IItems item : cartItems) {
			totalCartPrice += item.getItemPrice();
		}
		return totalCartPrice;
	}
}
