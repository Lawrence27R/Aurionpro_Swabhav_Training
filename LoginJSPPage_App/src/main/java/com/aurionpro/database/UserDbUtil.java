package com.aurionpro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.entity.User;

public class UserDbUtil {

    private Connection connection = null;
    private Statement statement = null;

    public void connectToUserDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");
            statement = connection.createStatement();
            System.out.println("Connection is successful.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllUsers() {
        ResultSet dbusers = null;

        try {
            dbusers = statement.executeQuery("SELECT * FROM users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbusers;
    }

    public boolean validateCredentials(String username, String password) {
        ResultSet dbusers = getAllUsers();

        try {
            while (dbusers.next()) {
                if (dbusers.getString("username").equals(username) &&
                    dbusers.getString("password").equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    public List<User> getUsers(){
    	ResultSet dbUsers = null;
    	List<User> users = new ArrayList<User>();
    	
    	try {
			dbUsers = statement.executeQuery("select * from users");
			while(dbUsers.next()) {
				users.add(new User(dbUsers.getInt("userid"), dbUsers.getString("username"), dbUsers.getString("password")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return users;
    }
}
