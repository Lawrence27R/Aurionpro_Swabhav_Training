<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet, java.sql.SQLException" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Customer Transactions</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">
<!--     <h2 class="text-center">Your Transactions</h2> -->

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
            ResultSet transactions = (ResultSet) request.getAttribute("transactions");

            if (transactions != null) {
                try {
                    while (transactions.next()) {
            %>
            <tr>
                <td><%= transactions.getString("senderAccNum") %></td>
                <td><%= transactions.getString("receiverAccNum") %></td>
                <td><%= transactions.getString("typeOfTrans") %></td>
                <td><%= transactions.getDouble("amount") %></td>
                <td><%= transactions.getDate("date") %></td>
            </tr>
            <% 
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
            %>
            <tr>
                <td colspan="5" class="text-danger">Error: <%= e.getMessage() %></td>
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
