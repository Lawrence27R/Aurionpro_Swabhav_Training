package com.aurionpro.model;

public class Student extends Person{
private  int rollNumber;
private double percentage;
public int getRollNumber() {
	return rollNumber;
}
public void setRollNumber(int rollNumber) {
	this.rollNumber = rollNumber;
}
public double getPercentage() {
	return percentage;
}
public void setPercentage(double percentage) {
	this.percentage = percentage;
}

//public Student(String name, String address, int age, int rollNumber, double percentage) {
//	super(name, address, age);
//	this.rollNumber = rollNumber;
//	this.percentage = percentage;
//}
@Override
public String toString() {
	return "Student [rollNumber=" + rollNumber + ", percentage=" + percentage + ", Name=" + getName()
			+ ", Address=" + getAddress() + ", Age=" + getAge() +  "]";
}
}
