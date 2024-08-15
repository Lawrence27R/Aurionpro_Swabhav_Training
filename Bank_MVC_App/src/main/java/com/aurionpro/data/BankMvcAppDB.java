package com.aurionpro.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

public class BankMvcAppDB {

    private Connection connection = null;

    public void connectToDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmvcappdb", "root", "root");
            System.out.println("Connection is successful.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isAdminValid(String username, String password, HttpSession session) {
        connectToDb();
        String query = "SELECT adminId FROM admin WHERE adminUsername = ? AND adminPassword = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int adminId = resultSet.getInt("adminId");
                session.setAttribute("adminId", adminId);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public boolean isCustomerValid(String customerAccountNum, String password, HttpSession session) {
        connectToDb();
        String query = "SELECT c.customerId, ca.customerAccountNum FROM customer c JOIN customeraccount ca ON ca.customerAccountNum = ? AND c.customerPassword = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customerAccountNum); // Changed to String
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int customerId = resultSet.getInt("customerId");
                String customerAccountNumFromDb = resultSet.getString("customerAccountNum"); // Changed to String
                session.setAttribute("customerId", customerId);
                session.setAttribute("customerAccountNum", customerAccountNumFromDb);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }



    public boolean addCustomer(String firstname, String lastname, String email, String password, Integer adminId) {
        connectToDb();
        String query = "INSERT INTO customer (customerFName, customerLName, emailId, customerPassword, adminId) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, adminId);

            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public ResultSet getCustomerById(String customerId) throws SQLException {
        connectToDb();
        String query = "SELECT * FROM customer WHERE customerId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, customerId);
        return preparedStatement.executeQuery();
    }

    public String generateAccountNumber() {
        return "1000200" + (int) (Math.random() * 10000); // Generate a random 4-digit number
    }
    
    public boolean addAccountForCustomer(String customerId, String accountNumber) {
        connectToDb();
        String query = "INSERT INTO customeraccount (customerId, customerAccountNum, customerBalance) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customerId);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.setDouble(3, 5000); // Set initial balance to 5000

            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public String getAccountByCustomerId(String customerId) {
        // TODO Auto-generated method stub
        return null;
    }

    public ResultSet getAllCustomers(String sortBy) throws SQLException {
        connectToDb();
        String query = "SELECT c.customerFName, c.customerLName, a.customerAccountNum, a.customerBalance " +
                       "FROM customer c " +
                       "JOIN customeraccount a ON c.customerId = a.customerId ";

        if ("balance".equals(sortBy)) {
            query += "ORDER BY a.customerBalance DESC";
        } else if ("accountNumber".equals(sortBy)) {
            query += "ORDER BY a.customerAccountNum ASC";
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public boolean updateCustomerProfile(int customerId, String firstName, String lastName, String email, String password) {
        connectToDb();
        String query = "UPDATE customer SET customerFName = ?, customerLName = ?, emailId = ?, customerPassword = ? WHERE customerId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, customerId);

            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }
    
    public int getCustomerIdByAccountNum(String customerAccountNum) throws SQLException {
        connectToDb();
        String query = "SELECT customerId FROM customeraccount WHERE customerAccountNum = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customerAccountNum);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("customerId");
            }
        } finally {
            closeConnection();
        }
        return -1; // Return -1 if not found
    }


    public ResultSet getTransactionsByAccountNum(String accountNum) throws SQLException {
        String query = "SELECT senderAccNum, receiversAccNum, typeOfTrans, amount, date FROM transactions WHERE senderAccNum = ? OR receiversAccNum = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, accountNum);
        preparedStatement.setString(2, accountNum);
        return preparedStatement.executeQuery();
    }
    
    public ResultSet getFilteredTransactions(String accountNum, String startDate, String endDate, String typeOfTrans) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT senderAccNum, receiversAccNum, typeOfTrans, amount, date FROM transactions WHERE (senderAccNum = ? OR receiversAccNum = ?)");
        
        if (startDate != null && !startDate.isEmpty()) {
            query.append(" AND date >= ?");
        }
        if (endDate != null && !endDate.isEmpty()) {
            query.append(" AND date <= ?");
        }
        if (typeOfTrans != null && !typeOfTrans.isEmpty()) {
            query.append(" AND typeOfTrans = ?");
        }
        
        PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
        preparedStatement.setString(1, accountNum);
        preparedStatement.setString(2, accountNum);

        int paramIndex = 3;

        if (startDate != null && !startDate.isEmpty()) {
            preparedStatement.setString(paramIndex++, startDate);
        }
        if (endDate != null && !endDate.isEmpty()) {
            preparedStatement.setString(paramIndex++, endDate);
        }
        if (typeOfTrans != null && !typeOfTrans.isEmpty()) {
            preparedStatement.setString(paramIndex, typeOfTrans);
        }

        return preparedStatement.executeQuery();
    }



    
    public ResultSet getAllTransactions() throws SQLException {
        connectToDb();
        String query = "SELECT senderAccNum, receiversAccNum, typeOfTrans, amount, date FROM transactions";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public ResultSet getTransactionsByType(String type) throws SQLException {
        connectToDb();
        String query = "SELECT senderAccNum, receiversAccNum, typeOfTrans, amount, date FROM transactions WHERE typeOfTrans = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, type);
        return preparedStatement.executeQuery();
    }

    public ResultSet getTransactionsByDate(String date) throws SQLException {
        connectToDb();
        String query = "SELECT senderAccNum, receiversAccNum, typeOfTrans, amount, date FROM transactions WHERE date = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, date);
        return preparedStatement.executeQuery();
    }



    public ResultSet getCustomerTransactions(String customerAccountNum) throws SQLException {
        connectToDb();
        String query = "SELECT senderAccNum, receiversAccNum, typeOfTrans, amount, date FROM transactions WHERE senderAccNum = ? OR receiversAccNum = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, customerAccountNum);
        preparedStatement.setString(2, customerAccountNum);
        return preparedStatement.executeQuery();
    }



    public boolean debitAmount(String customerAccountNum, double amount) throws SQLException {
        // Removed connection open/close here
        String query = "UPDATE customeraccount SET customerBalance = customerBalance - ? WHERE customerAccountNum = ? AND customerBalance >= ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, customerAccountNum); // Changed to String
            preparedStatement.setDouble(3, amount);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                logTransaction(customerAccountNum, null, "debit", amount); // Log debit transaction
                return true;
            }
        }
        return false;
    }

    public boolean creditAmount(String customerAccountNum, double amount) throws SQLException {
        // Removed connection open/close here
        String query = "UPDATE customeraccount SET customerBalance = customerBalance + ? WHERE customerAccountNum = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, customerAccountNum); // Changed to String
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                logTransaction(customerAccountNum, null, "credit", amount); // Log credit transaction
                return true;
            }
        }
        return false;
    }

    public boolean transferAmount(String senderAccountNum, double amount, String receiversAccNum) throws SQLException {
        connectToDb(); // Connect to DB
        try {
            connection.setAutoCommit(false); // Start transaction

            // Debit from sender account
            if (!debitAmount(senderAccountNum, amount)) {
                connection.rollback(); // Rollback if debit fails
                return false;
            }

            // Credit to receiver account
            String query = "UPDATE customeraccount SET customerBalance = customerBalance + ? WHERE customerAccountNum = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDouble(1, amount);
                preparedStatement.setString(2, receiversAccNum); // Changed to String
                int result = preparedStatement.executeUpdate();
                if (result == 0) {
                    connection.rollback(); // Rollback if credit fails
                    return false;
                }
            }

            // Log transactions
            logTransaction(senderAccountNum, receiversAccNum, "debit", amount); // Log debit for sender
            logTransaction(receiversAccNum, senderAccountNum, "credit", amount); // Log credit for receiver

            connection.commit(); // Commit transaction
            return true;
        } catch (SQLException e) {
            connection.rollback(); // Rollback in case of error
            throw e;
        } finally {
            connection.setAutoCommit(true); // Reset auto-commit mode
            closeConnection(); // Close connection here
        }
    }



    private void logTransaction(String senderAccountNum, String receiversAccNum, String type, double amount) throws SQLException {
        String query = "INSERT INTO transactions (senderAccNum, receiversAccNum, typeOfTrans, amount, date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, senderAccountNum); // Changed to String
            preparedStatement.setString(2, receiversAccNum != null ? receiversAccNum : senderAccountNum); // Self-credit or self-debit
            preparedStatement.setString(3, type);
            preparedStatement.setDouble(4, amount);
            preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
        }
    }



}
