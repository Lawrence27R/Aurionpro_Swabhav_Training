package com.aurionpro.set.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.set.model.ComparatorClassEmployee;
import com.aurionpro.set.model.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		
		List<Employee> employees = createEmployee();
		
		printEmployee(employees);
		
		Collections.sort(employees, new ComparatorClassEmployee.EmployeeIdComparator());
	}
	
	
	private static List<Employee> createEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of Employees to create : ");
		int number = scanner.nextInt();
		
		for (int i=0; i<number; i++) {
			System.out.println("Enter Employee Id : ");
			int employeeId = scanner.nextInt();
			System.out.println("Enter Employee name : ");
			String name = scanner.next();
			System.out.println("Enter Employee Salary : ");
			double salary = scanner.nextDouble();
			
			employees.add(new Employee(employeeId, name, salary));
		}
		return employees;
	}
	
	private static void printEmployee(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
	}
}
