package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StudentTest {
	
	private IStudent istudent;
	
	@BeforeEach
	void init() {
		istudent = Mockito.mock(IStudent.class);
		Mockito.when(istudent.getStudentMarks()).thenReturn((double) 650);
		Mockito.when(istudent.getTotalSubjects()).thenReturn(10);
	}
	
	
	@Test
	void testStudentPercentageCalulator() {
		Student student = new Student(istudent);
		assertEquals(65, student.StudentPercentageCalulator());

	}

}
