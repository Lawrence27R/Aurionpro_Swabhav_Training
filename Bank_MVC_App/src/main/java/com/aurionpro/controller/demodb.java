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

    public Connection connectToDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmvcappdb", "root", "root");
            System.out.println("Connection is successful.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
		return connection;
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

    public boolean isAdminUsernameValid(String username) {
        try (Connection conn = connectToDb();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM admin WHERE adminUsername = ?")) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isAdminPasswordValid(String username, String password) {
        try (Connection conn = connectToDb();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM admin WHERE adminUsername = ? AND adminPassword = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isCustomerUsernameValid(String username) {
        try (Connection conn = connectToDb();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM customeraccount WHERE customerAccountNum = ?")) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isCustomerPasswordValid(String username, String password) {
        try (Connection conn = connectToDb();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM customer c join customeraccount ca on c.customerId = ca.customerId WHERE ca.customerAccountNum = ? AND c.customerPassword = ?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
//            closeConnection();
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
//            closeConnection();
        }
        return false;
    }
    
    public ResultSet getAllTransactions() throws SQLException {
        connectToDb();
        String query = "SELECT senderAccNum, receiverAccNum, typeOfTrans, amount, date FROM transactions";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public ResultSet getCustomerTransactions(long customerAccountNum) throws SQLException {
        connectToDb();
        String query = "SELECT senderAccNum, receiverAccNum, typeOfTrans, amount, date FROM transactions WHERE senderAccNum = ? OR receiverAccNum = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, customerAccountNum); // Fetch the sender's account number
        preparedStatement.setLong(2, customerAccountNum); // Fetch the sender's account number
        return preparedStatement.executeQuery();
    }

    public boolean debitAmount(long customerAccountNum, double amount) throws SQLException {
        connectToDb();
        String query = "UPDATE customeraccount SET customerBalance = customerBalance - ? WHERE customerAccountNum = ? AND customerBalance >= ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setLong(2, customerAccountNum);
            preparedStatement.setDouble(3, amount);
            int result = preparedStatement.executeUpdate();
            System.out.println("Debit query executed. Rows affected: " + result); // Debug line
            if (result > 0) {
                logTransaction(customerAccountNum, null, "debit", amount); // No receiver for debit
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean creditAmount(long customerAccountNum, double amount) throws SQLException {
        connectToDb();
        String query = "UPDATE customeraccount SET customerBalance = customerBalance + ? WHERE customerAccountNum = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setLong(2, customerAccountNum);
            int result = preparedStatement.executeUpdate();
            System.out.println("Credit query executed. Rows affected: " + result); // Debug line
            if (result > 0) {
                logTransaction(customerAccountNum, null, "credit", amount); // No receiver for credit
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean transferAmount(long senderAccountNum, double amount, long receiverAccountNum) throws SQLException {
        connectToDb();
        try {
            connection.setAutoCommit(false);

            // Debit the sender
            if (!debitAmount(senderAccountNum, amount)) {
                connection.rollback();
                return false;
            }

            // Credit the receiver
            String query = "UPDATE customeraccount SET customerBalance = customerBalance + ? WHERE customerAccountNum = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDouble(1, amount);
                preparedStatement.setLong(2, receiverAccountNum);
                int result = preparedStatement.executeUpdate();
                System.out.println("Transfer credit query executed. Rows affected: " + result); // Debug line
                if (result == 0) {
                    connection.rollback();
                    return false;
                }
            }

            // Log the transfer transaction
            logTransaction(senderAccountNum, receiverAccountNum, "transfer", amount);

            connection.commit();
            return true;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
            closeConnection();
        }
    }

    private void logTransaction(long senderAccountNum, Long receiverAccountNum, String type, double amount) throws SQLException {
        String query = "INSERT INTO transactions (senderAccNum, receiverAccNum, typeOfTrans, amount, date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, senderAccountNum); // Log sender account number
            if (receiverAccountNum != null) {
                preparedStatement.setLong(2, receiverAccountNum); // Log receiver account number
            } else {
                preparedStatement.setNull(2, java.sql.Types.BIGINT); // Null if not applicable
            }
            preparedStatement.setString(3, type);
            preparedStatement.setDouble(4, amount);
            preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis())); // Current timestamp
            preparedStatement.executeUpdate();
        }
    }


}
