package com.aurionpro.structural.decorators.test;

import com.aurionpro.structural.decorators.model.GoldenHat;
import com.aurionpro.structural.decorators.model.IHat;
import com.aurionpro.structural.decorators.model.PremiumHat;
import com.aurionpro.structural.decorators.model.RibbionHat;
import com.aurionpro.structural.decorators.model.StandardHat;

public class HatDecoratorTest {
	public static void main(String[] args) {
		IHat hat1 = new StandardHat();
		IHat hat2 = new PremiumHat();
		
		GoldenHat goldenhat = new GoldenHat(hat1);
		RibbionHat ribbionHat = new RibbionHat(hat2);
		RibbionHat ribbionhatwithgolden = new RibbionHat(goldenhat);
		
		System.out.println(hat1.getName());
		System.out.println(hat1.getPrice());
		System.out.println(hat1.getDescription());
		System.out.println(goldenhat.getName());
		System.out.println(goldenhat.getPrice());
		System.out.println(goldenhat.getDescription());
		System.out.println(ribbionHat.getName());
		System.out.println(ribbionHat.getPrice());
		System.out.println(ribbionHat.getDescription());
		System.out.println(ribbionhatwithgolden.getName());
		System.out.println(ribbionhatwithgolden.getPrice());
		System.out.println(ribbionhatwithgolden.getDescription());
	}
}
