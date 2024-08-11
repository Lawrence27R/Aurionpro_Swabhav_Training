package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankAccountTranscation {
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	Scanner scanner = new Scanner(System.in);

	public void connectToBankAccountDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
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
}
