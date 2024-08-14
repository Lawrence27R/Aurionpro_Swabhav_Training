<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet, java.sql.SQLException" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>View Transactions</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
<!--     <h2 class="text-center">View Transactions</h2> -->

    <!-- Transactions Table -->
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Sender Account Number</th>
                <th>Receiver Account Number</th>
                <th>Type of Transaction</th>
                <th>Amount</th>
                <th>Date</th>
            </tr>
        </thead>
        <tbody>
            <% 
            // Retrieve the result set and error message from the request attributes
            ResultSet rs = (ResultSet) request.getAttribute("transactions");
            String errorMessage = (String) request.getAttribute("errorMessage");

            // Display error message if any
            if (errorMessage != null) {
            %>
                <tr>
                    <td colspan="5" class="text-danger"><%= errorMessage %></td>
                </tr>
            <% 
            } else {
                try {
                    if (rs != null) {
                        while (rs.next()) {
                            String senderAccountNum = rs.getString("senderAccountNum");
                            String receiverAccountNum = rs.getString("receiverAccountNum");
                            String transactionType = rs.getString("transactionType");
                            double amount = rs.getDouble("amount");
                            java.sql.Date transactionDate = rs.getDate("transactionDate");
            %>
            <tr>
                <td><%= senderAccountNum %></td>
                <td><%= receiverAccountNum %></td>
                <td><%= transactionType %></td>
                <td><%= amount %></td>
                <td><%= transactionDate %></td>
            </tr>
            <% 
                        }
                    } else {
            %>
                <tr>
                    <td colspan="5">No transactions found.</td>
                </tr>
            <% 
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Display the SQL error message
            %>
                <tr>
                    <td colspan="5" class="text-danger">Error: <%= e.getMessage() %></td>
                </tr>
            <% 
                }
            }
            %>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
