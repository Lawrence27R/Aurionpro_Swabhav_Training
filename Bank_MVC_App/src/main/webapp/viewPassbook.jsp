<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet, java.sql.SQLException" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Your Transactions</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">
    <h2>Your Transactions</h2>
    
    <form method="get" action="ViewPassbookController" class="mb-4">
        <div class="form-row">
            <div class="form-group col-md-3">
                <label for="startDate">Start Date</label>
                <input type="date" class="form-control" id="startDate" name="startDate">
            </div>
            <div class="form-group col-md-3">
                <label for="endDate">End Date</label>
                <input type="date" class="form-control" id="endDate" name="endDate">
            </div>
            <div class="form-group col-md-3">
                <label for="typeOfTrans">Transaction Type</label>
                <select id="typeOfTrans" name="typeOfTrans" class="form-control">
                    <option value="">All</option>
                    <option value="Credit">Credit</option>
                    <option value="Debit">Debit</option>
                </select>
            </div>
            <div class="form-group col-md-3">
                <label>&nbsp;</label>
                <button type="submit" class="btn btn-primary form-control">Apply Filters</button>
            </div>
        </div>
    </form>

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
            boolean hasTransactions = transactions != null;

            if (hasTransactions) {
                try {
                    if (transactions.isBeforeFirst()) {
                        while (transactions.next()) {
            %>
            <tr>
                <td><%= transactions.getString("senderAccNum") %></td>
                <td><%= transactions.getString("receiversAccNum") %></td>
                <td><%= transactions.getString("typeOfTrans") %></td>
                <td><%= transactions.getDouble("amount") %></td>
                <td><%= transactions.getDate("date") %></td>
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

    <div class="mt-3">
        <a href="customerDashboard.jsp" class="btn btn-info">Go to Customer Dashboard</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
