package com.swabhav.test;

import java.util.Scanner;

import com.swabhav.model.Student;

public class StudentTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student student1 = new Student();
		System.out.println("Enter the name : ");
		String n = sc.nextLine();
		student1.setName(n);
		System.out.println("Enter the roll no : ");
		int r = sc.nextInt();
		student1.setRollNo(r);
		System.out.println("Enter the age : ");
		int a = sc.nextInt();
		student1.setAge(a);
		System.out.println("Enter the percentage : ");
		double p = sc.nextDouble();
		student1.setPercentage(p);
		
		student1.display();
		student1.grade();
		sc.close();
		
	}
}
