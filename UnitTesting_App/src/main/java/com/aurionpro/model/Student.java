package com.aurionpro.model;

public class Student {
	
	private IStudent student;
	
	public Student(IStudent student) {
		super();
		this.student = student;
	}



	double StudentPercentageCalulator() {
		return student.getStudentMarks()/student.getTotalSubjects();
	}
		
}
