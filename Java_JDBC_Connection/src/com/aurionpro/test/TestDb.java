package com.aurionpro.test;

import com.aurionpro.model.DbConnection;

public class TestDb {
	public static void main(String[] args) {
		DbConnection dbconnector = new DbConnection();
		dbconnector.connectToDb();
		dbconnector.getDataType();
		dbconnector.getStudentsDetails();
//		dbconnector.addStudent();
//		dbconnector.updateStudent();
//		dbconnector.getStudentsDetails();
	}
}
