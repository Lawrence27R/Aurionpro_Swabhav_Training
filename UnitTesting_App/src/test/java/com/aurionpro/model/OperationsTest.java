package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperationsTest {
	
	Operations operations = new Operations();
	@Test
	public void testAddition() {
		assertEquals(30, operations.addition(20, 10));
	}

}
