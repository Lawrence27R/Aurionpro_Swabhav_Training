package com.july._14;

public class Employee {
	private int employeeId;
	private String employeeName;
	private int salary;

	public Employee() {
		employeeId = 12;
		employeeName = "Lawrence";
		salary = 30000;
	}

	public Employee(int employeeId, String employeeName, int salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getSalary() {
		return salary;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void display() {
		System.out.println("Employee ID : " + employeeId);
		System.out.println("Employee Name : " + employeeName);
		System.out.println("Salary : " + salary);
	}
}
