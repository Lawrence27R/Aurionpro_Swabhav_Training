package com.aurionpro.set.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aurionpro.set.model.Student;
import com.aurionpro.set.model.ComparatorClass;

public class StudentTest {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(1, "Lawrence", 85));
		students.add(new Student(2, "Suhas", 95));
		students.add(new Student(3, "Subhod", 75));
		students.add(new Student(4, "Aditya", 90));
		students.add(new Student(5, "Pratik", 99));
		System.out.println("Before Sorting : ");
		printStudents(students);
		
		Collections.sort(students, new ComparatorClass.RollNumberComparator());
		System.out.println("After Sorting : ");
		printStudents(students);
		
	}

	private static void printStudents(List<Student>students) {
		for (Student student: students) {
			System.out.println(student);
		}
		
	}
}
