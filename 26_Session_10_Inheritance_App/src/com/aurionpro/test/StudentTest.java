package com.aurionpro.test;

import com.aurionpro.model.Student;

public class StudentTest {
public static void main(String[] args) {
	Student student1 = new Student();
	
	student1.setName("Suhas");
	student1.setAddress("Mira Road");
	student1.setAge(21);
	student1.setPercentage(95.99);
	student1.setRollNumber(1);
	System.out.println(student1);
}
}
