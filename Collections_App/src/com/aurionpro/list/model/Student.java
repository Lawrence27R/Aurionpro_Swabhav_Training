package com.aurionpro.list.model;

public class Student {
	private int studentId;
	private String name;
	private double percentage;
	public Student(int studentId, String name, double percentage) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.percentage = percentage;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
    @Override
    public String toString() {
        return "Student{studentId=" + studentId + ", name='" + name + "', percentage=" + percentage + "}";
    }
}
