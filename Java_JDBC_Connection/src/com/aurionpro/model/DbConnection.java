package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnection { 
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	Scanner scanner = new Scanner(System.in);
	
	public void connectToDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
			statement  = connection.createStatement();
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
			resultSet = statement.executeQuery("select * from students");
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
    
	public void getStudentsDetails() {
		try {
			ResultSet dbStudentDetails = statement.executeQuery("select * from students");
			while(dbStudentDetails.next()) {
				System.out.println(dbStudentDetails.getInt(1)+"\t"+dbStudentDetails.getString("name")+"\t"
			+dbStudentDetails.getInt("age")+"\t"+dbStudentDetails.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addStudent() {
		System.out.println("Enter the details to add in the database:");
		System.out.println("Enter Roll no: ");
		int rollnumber = scanner.nextInt();
		System.out.println("Enter Name: ");
		String name = scanner.next();
		System.out.println("Enter Age: ");
		int age = scanner.nextInt();
		System.out.println("Enter Percentage: ");
		double percentage = scanner.nextDouble();
	
		try {
			preparedStatement = connection.prepareStatement("insert into students values(?,?,?,?)");
			preparedStatement.setInt(1, rollnumber);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, age);
			preparedStatement.setDouble(4, percentage);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStudent() {
		System.out.println("Enter the details to update in the database:");
		System.out.println("Enter Roll no: ");
		int rollno = scanner.nextInt();
		System.out.println("Enter Age: ");
		int age = scanner.nextInt();
		try {
			preparedStatement = connection.prepareStatement
					("update students set age = ? where rollno = ?");
			preparedStatement.setInt(1, age);
			preparedStatement.setInt(2, rollno);
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
