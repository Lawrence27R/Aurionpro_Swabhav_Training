package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationsTest1 {

	Operations operations;

	// Creates new object before each method

	@BeforeEach
	void init() {
		operations = new Operations();
	}

	@AfterEach
	void status() {
		System.out.println("Test Finished");
	}

	@Test
	void testAddition() {
		assertEquals(30, operations.addition(20, 10));
	}

	@Test
	void testSubstraction() {
		assertEquals(10, operations.substraction(20, 10));
	}

	@Test
	void testMultiplication() {
		assertEquals(200, operations.multiplication(20, 10));
	}

	@Test
	void testDivision() {
		
		assertEquals(2, operations.division(20, 10));
		assertThrows(ArithmeticException.class, () -> operations.division(20, 0));
	}

	@Test
	void testModulus() {
		assertEquals(0, operations.modulus(20, 10));
	}

	@Test
	void testSquareOfArray() {

		int numbers[] = { 5, 6, 7 };
		int squaredNumbers[] = { 25, 36, 49 };
		assertArrayEquals(squaredNumbers, operations.squareOfArray(numbers));
	}
}
