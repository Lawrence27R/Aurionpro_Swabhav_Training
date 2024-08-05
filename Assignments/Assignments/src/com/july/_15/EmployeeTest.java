package com.july._15;

import java.util.Scanner;

import com.july._14.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee ID : ");
		int employeeId = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Employee Name : ");
		String employeeName = sc.nextLine();
		
		System.out.println("Enter Salary Amount : ");
		int salary = sc.nextInt();
		Employee employee1 = new Employee(employeeId, employeeName, salary);

		employee1.display();
		
		System.err.println();
		Employee employee2 = new Employee();
		System.out.println("Enter Employee ID : ");
		int j = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Employee Name : ");
		String k = sc.nextLine();
		employee2.setEmployeeId(j);
		employee2.setEmployeeName(k);
		
		System.out.println("Enter Salary Amount : ");
		int l = sc.nextInt();
		employee2.setSalary(l);
		
		employee2.display();
		
		sc.close();
	}
}
