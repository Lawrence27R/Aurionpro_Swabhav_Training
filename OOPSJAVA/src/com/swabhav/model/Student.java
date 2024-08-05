package com.swabhav.model;

public class Student {
	String name;
	int rollno;
	int age;
	double percentage;
	
	public String getName() {
		return name;
	}
	public int getRollNo() {
		return rollno;
	}
	public int getAge() {
		return age;
	}
	public double getPercentage() {
		return percentage;
	}
	
	public void setName(String n) {
		name = n;
	}
	public void setRollNo(int r) {
		rollno = r;
	}
	public void setAge(int a) {
		age = a;
	}
	public void setPercentage(double p) {
		percentage = p;
	}
	public void grade() {
		if (percentage > 75) {
			System.out.println("Grade : A");
		}
		else if (percentage > 60 && percentage >= 75) {
			System.out.println("Grade : B");
		}
		else if (percentage > 50 && percentage <= 60) {
			System.out.println("Grade : C");
		}
		else if (percentage > 40 && percentage >= 50) {
			System.out.println("Grade : D");
		}
		else {
			System.out.println("Grade : F");
		}
	}
	
	public void display() {
		System.out.println("Name is : "+name);
		System.out.println("Roll no is : "+rollno);
		System.out.println("Age is : "+age);
		System.out.println("Percntage is : "+percentage);
	}
}
