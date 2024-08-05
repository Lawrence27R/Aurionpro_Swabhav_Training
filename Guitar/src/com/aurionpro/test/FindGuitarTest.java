package com.aurionpro.test;

import java.util.List;

import com.aurionpro.model.Builder;
import com.aurionpro.model.Guitar;
import com.aurionpro.model.GuitarSpecs;
import com.aurionpro.model.Inventory;
import com.aurionpro.model.Type;
import com.aurionpro.model.Wood;

public class FindGuitarTest {

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		initializeInventory(inventory);

		GuitarSpecs whatErinLikes = new GuitarSpecs(Builder.FENDER,
			"Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);

		List<Guitar> matchingGuitars = inventory.search(whatErinLikes);

		if (!matchingGuitars.isEmpty()) {
			System.out.println("Erin, you might like these guitars:");
			for (Guitar guitar : matchingGuitars) {
				GuitarSpecs spec = guitar.getSpec();
				System.out.println("  We have a " +
					spec.getBuilder() + " " + spec.getModel() +
					spec.getType() + " guitar:\n    " +
					spec.getBackWood() + " back and sides,\n     " +
					spec.getTopWood() + " top.\n  You can have it for only $" +
					guitar.getPrice() + "!\n ----");
			}
		} else {
			System.out.println("Sorry, Erin, we have nothing for you.");
		}
	}

	private static void initializeInventory(Inventory inventory) {
		inventory.addGuitar("V95693", 1499.95,
		new GuitarSpecs(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
		        Wood.ALDER, Wood.ALDER));
		inventory.addGuitar("V9512", 1549.95,
			new GuitarSpecs(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
				Wood.ALDER, Wood.ALDER));
		inventory.addGuitar("122784", 5495.95, 
			new GuitarSpecs(Builder.MARTIN, "D-18", Type.ACOUSTIC, 6,
				Wood.MAHOGANY, Wood.CEDAR));
		
	}
	
	
}

