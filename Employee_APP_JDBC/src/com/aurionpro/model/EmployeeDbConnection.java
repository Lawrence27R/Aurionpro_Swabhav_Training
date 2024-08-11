package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDbConnection {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	Scanner scanner = new Scanner(System.in);

	public void connectToEmployeeDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
			statement = connection.createStatement();
			System.out.println("Connection is successful.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getDataType() {
		ResultSet resultSet;
		try {
			resultSet = statement.executeQuery("select * from employees");
			ResultSetMetaData metaData = resultSet.getMetaData();

			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.println("Column Name: " + metaData.getColumnName(i));
				System.out.println("Column Type: " + metaData.getColumnTypeName(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addEmployeeDetails() {
		
//		Batch Processing
        String query = "insert into employees (employeeId, name, salary) values (?, ?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);

            while (true) {
                System.out.println("Enter the Employee Details:");
                System.out.print("Enter Employee Id: ");
                int employeeId = scanner.nextInt();
                
                System.out.print("Enter Employee Name: ");
                String name = scanner.next();
                
                System.out.print("Enter Employee Salary: ");
                double salary = scanner.nextDouble();
                
                // Consume the newline character left by nextInt() and nextDouble()
                scanner.nextLine();

                preparedStatement.setInt(1, employeeId);
                preparedStatement.setString(2, name);
                preparedStatement.setDouble(3, salary);
                preparedStatement.addBatch();
                
                System.out.print("Add more values (Y/N): ");
                String decision = scanner.nextLine();
                if (decision.trim().equalsIgnoreCase("N")) {
                    break;
                }
            }

            int[] batchResult = preparedStatement.executeBatch();
            connection.commit();
            System.out.println("Batch executed successfully");

        }  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Single Entry
//		System.out.println("Enter the Employee Details : ");
//		System.out.println("Enter Employee Id : ");
//		int employeeId = scanner.nextInt();
//		System.out.println("Enter Employee name : ");
//		String name = scanner.next();
//		System.out.println("Enter Employee Salary : ");
//		double salary = scanner.nextDouble();
//
//		try {
//			preparedStatement = connection.prepareStatement("insert into employees values(?,?,?)");
//			preparedStatement.setInt(1, employeeId);
//			preparedStatement.setString(2, name);
//			preparedStatement.setDouble(3, salary);
//
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void getEmployeeDetails() {
		try {
			ResultSet dbEmployeeDetails = statement.executeQuery("select * from employees");
            while (dbEmployeeDetails.next()) {
                int employeeid = dbEmployeeDetails.getInt("employeeid");
                String name = dbEmployeeDetails.getString("name");
                double salary = dbEmployeeDetails.getDouble("salary");

                System.out.println(employeeid + "\t" + name + "\t" + salary);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateEmployeeDetails() {
		System.out.println("Enter Employee Id to update details : ");
		int employeeid = scanner.nextInt();
		System.out.println("Select the details to update : ");
		System.out.println("1. Name");
		System.out.println("2. Salary");
		
		try {
		int choice = scanner.nextInt();
		
		if (choice == 1) {
			System.out.println("Enter Employee name to be updated : ");
			String name = scanner.next();
			preparedStatement = connection.prepareStatement
					("update employees set name = ? where employeeid = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, employeeid);
			preparedStatement.execute();
		}
		if (choice == 2) {
			System.out.println("Enter Employee salary to be updated : ");
			double salary = scanner.nextDouble();
			preparedStatement = connection.prepareStatement
					("update employees set salary = ? where employeeid = ?");
			preparedStatement.setDouble(1, salary);
			preparedStatement.setInt(2, employeeid);
			preparedStatement.execute();
		}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteEmployeeDetails() {
	    System.out.println("Enter Employee Id to delete : ");
	    int employeeid = scanner.nextInt();

	    try {
	        preparedStatement = connection.prepareStatement("delete from employees where employeeid = ?");
	        preparedStatement.setInt(1, employeeid);
	        preparedStatement.executeUpdate();
//	        System.out.println("Delete operation completed.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void executeBatch() {
        String sql = "insert into employees (employeeid, name, salary) values (?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            
            // Add batch entries
            statement.setInt(1, 3);
            statement.setString(2, "Shawn");
            statement.setInt(3, 6000);
            statement.addBatch();

            statement.setInt(1, 4);
            statement.setString(2, "Om");
            statement.setInt(3, 7000);
            statement.addBatch();

            statement.setInt(1, 5);
            statement.setString(2, "Parag");
            statement.setInt(3, 8000);
            statement.addBatch();

            int[] batchResult = statement.executeBatch();
            connection.commit();

            System.out.println("Batch executed successfully");

        } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
