package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.EmployeeDbConnection;

public class EmployeeDbTest {
	public static void main(String[] args) {
		EmployeeDbConnection employeedb = new EmployeeDbConnection();
		Scanner scanner = new Scanner(System.in);
		
		employeedb.connectToEmployeeDb();
//		employeedb.getDataType();
		
//		Batch Processing
//		employeedb.getEmployeeDetails();
//		employeedb.executeBatch();
		employeedb.getEmployeeDetails();
		employeedb.addEmployeeDetails();
		
//		int choice;
//
//        do {
//            System.out.println("Select Operation to perform : ");
//            System.out.println("1. Add Employee Details");
//            System.out.println("2. Display Employee Details");
//            System.out.println("3. Update Employee Details");
//            System.out.println("4. Delete Employee Details");
//            System.out.println("5. Exit");
//            System.out.print("Enter your choice: ");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                	employeedb.addEmployeeDetails();
//                    break;
//                case 2:
//                	employeedb.getEmployeeDetails();
//                    break;
//                case 3:
//                	employeedb.updateEmployeeDetails();
//                    break;
//                case 4:
//                	employeedb.deleteEmployeeDetails();
//                    break;
//                case 5:
//                	System.out.println("Exiting...");
//                	System.exit(5);
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        } while (choice != 6);

        scanner.close();
		
	}
}
