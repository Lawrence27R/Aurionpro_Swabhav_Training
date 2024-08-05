package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AreaCalulatorTest {

	AreaCalulator calulateArea;

	@BeforeEach
	void init() {
		calulateArea = new AreaCalulator();
	}

	@Test
	void testAreaOfCircle() {
//		fail("Not yet implemented");

		assertEquals(314, calulateArea.AreaOfCircle(10));
	}

	@Test
	void testAreaOfRectangle() {
//		fail("Not yet implemented");
		assertEquals(200, calulateArea.AreaOfRectangle(10, 20));
	}

	@Test
	void testAreaOfTriangle() {
//		fail("Not yet implemented");
		assertEquals(100, calulateArea.AreaOfTriangle(10, 20));
	}

}
