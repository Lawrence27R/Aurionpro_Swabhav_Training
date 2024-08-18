<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.aurionpro.entity.Transaction" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Customer Transactions</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">
    <h2>Your Transactions</h2>
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
            List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
            if (transactions != null && !transactions.isEmpty()) {
                for (Transaction transaction : transactions) {
            %>
            <tr>
                <td><%= transaction.getSenderAccNum() %></td>
                <td><%= transaction.getReceiversAccNum() %></td>
                <td><%= transaction.getTypeOfTrans() %></td>
                <td><%= transaction.getAmount() %></td>
                <td><%= transaction.getDate() %></td>
            </tr>
            <% 
                }
            } 
            %>
            <% if (transactions == null || transactions.isEmpty()) { %>
            <tr>
                <td colspan="5">No transactions found.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
