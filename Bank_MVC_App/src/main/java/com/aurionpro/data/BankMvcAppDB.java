package com.aurionpro.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.aurionpro.entity.Customer;

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

    public int getAdminId(String username) {
        int adminId = -1; 
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connectToDb(); 
            String sql = "SELECT adminId FROM admin WHERE adminUsername = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                adminId = rs.getInt("adminId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, pstmt);
            closeConnection(); 
        }

        return adminId;
    }
    
    private void closeResources(ResultSet rs, PreparedStatement pstmt) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isAdminValid(String username, String password, HttpSession session) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isValid = false;

        try {
            connectToDb();
            String query = "SELECT adminId FROM admin WHERE adminUsername = ? AND adminPassword = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int adminId = resultSet.getInt("adminId");
                session.setAttribute("adminId", adminId);
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(resultSet, preparedStatement);
            closeConnection(); 
        }

        return isValid;
    }
    public boolean isCustomerValid(String emailId, String password, HttpSession session) {
        connectToDb();
        String query = "SELECT c.customerId, a.customerAccountNum FROM customer c " +
                       "JOIN customeraccount a ON c.customerId = a.customerId " +
                       "WHERE c.emailId = ? AND c.customerPassword = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, emailId);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int customerId = resultSet.getInt("customerId");
                String customerAccountNumFromDb = resultSet.getString("customerAccountNum");
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
        return "1000200" + (int) (Math.random() * 10000); 
    }
    
    public boolean addAccountForCustomer(String customerId, String accountNumber) {
        connectToDb();
        String query = "INSERT INTO customeraccount (customerId, customerAccountNum, customerBalance) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customerId);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.setDouble(3, 5000); 

            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<Customer> getRecentCustomers() {
        List<Customer> recentCustomers = new ArrayList<>();
        String query = "SELECT customerId, customerFName, customerLName, emailId " +
                       "FROM customer ORDER BY customerId DESC LIMIT 5";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connectToDb(); 
            conn = connection; 
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getString("customerId"));
                customer.setCustomerFName(rs.getString("customerFName"));
                customer.setCustomerLName(rs.getString("customerLName"));
                customer.setEmailId(rs.getString("emailId"));
                recentCustomers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        } finally {
            
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return recentCustomers;
    }
    
    public String getAccountByCustomerId(String customerId) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public ResultSet getAllCustomers(String sortBy, String searchName) throws SQLException {
        connectToDb();
        String query = "SELECT c.customerFName, c.customerLName, a.customerAccountNum, a.customerBalance " +
                       "FROM customer c " +
                       "JOIN customeraccount a ON c.customerId = a.customerId ";
        
        if (searchName != null && !searchName.isEmpty()) {
            searchName = searchName.toLowerCase();
            query += "WHERE LOWER(c.customerFName) LIKE ? OR LOWER(c.customerLName) LIKE ? ";
        }

        if (sortBy != null && !sortBy.isEmpty()) {
            if ("balance".equals(sortBy)) {
                query += "ORDER BY a.customerBalance DESC";
            } else if ("accountNumber".equals(sortBy)) {
                query += "ORDER BY a.customerAccountNum ASC";
            }
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        int parameterIndex = 1;
        if (searchName != null && !searchName.isEmpty()) {
            preparedStatement.setString(parameterIndex++, "%" + searchName + "%");
            preparedStatement.setString(parameterIndex++, "%" + searchName + "%");
        }

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
        return -1; 
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
        String query = "UPDATE customeraccount SET customerBalance = customerBalance - ? WHERE customerAccountNum = ? AND customerBalance >= ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, customerAccountNum); 
            preparedStatement.setDouble(3, amount);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                logTransaction(customerAccountNum, null, "debit", amount); 
                return true;
            }
        }
        return false;
    }

    public boolean creditAmount(String customerAccountNum, double amount) throws SQLException {
        String query = "UPDATE customeraccount SET customerBalance = customerBalance + ? WHERE customerAccountNum = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, customerAccountNum); 
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                logTransaction(customerAccountNum, null, "credit", amount); 
                return true;
            }
        }
        return false;
    }

    public boolean transferAmount(String senderAccountNum, double amount, String receiversAccNum) throws SQLException {
        connectToDb(); 
        try {
            connection.setAutoCommit(false); 

            if (!debitAmount(senderAccountNum, amount)) {
                connection.rollback(); 
                return false;
            }

            String query = "UPDATE customeraccount SET customerBalance = customerBalance + ? WHERE customerAccountNum = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDouble(1, amount);
                preparedStatement.setString(2, receiversAccNum); 
                int result = preparedStatement.executeUpdate();
                if (result == 0) {
                    connection.rollback(); 
                    return false;
                }
            }

            logTransaction(senderAccountNum, receiversAccNum, "debit", amount); // Log debit for sender
            logTransaction(receiversAccNum, senderAccountNum, "credit", amount); // Log credit for receiver

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



    private void logTransaction(String senderAccountNum, String receiversAccNum, String type, double amount) throws SQLException {
        String query = "INSERT INTO transactions (senderAccNum, receiversAccNum, typeOfTrans, amount, date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, senderAccountNum); 
            preparedStatement.setString(2, receiversAccNum != null ? receiversAccNum : senderAccountNum); 
            preparedStatement.setString(3, type);
            preparedStatement.setDouble(4, amount);
            preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
        }
    }



}
