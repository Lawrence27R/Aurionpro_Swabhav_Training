<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, com.aurionpro.data.BankMvcAppDB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Transaction</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="mt-4">Make a Transaction</h2>

    <% 
        String errorMessage = (String) request.getAttribute("errorMessage");
        String successMessage = (String) request.getAttribute("successMessage");
        if (errorMessage != null) {
    %>
        <div class="alert alert-danger"><%= errorMessage %></div>
    <% 
        }
        if (successMessage != null) {
    %>
        <div class="alert alert-success"><%= successMessage %></div>
    <% 
        }
    %>

    <form action="NewTransactionController" method="post">
        <div class="form-group">
            <label for="transactionType">Select Transaction Type:</label>
            <select id="transactionType" name="transactionType" class="form-control" onchange="this.form.submit()">
                <option value="credit" <%= "credit".equals(request.getParameter("transactionType")) ? "selected" : "" %>>Credit</option>
                <option value="debit" <%= "debit".equals(request.getParameter("transactionType")) ? "selected" : "" %>>Debit</option>
            </select>
        </div>

        <div class="form-group">
            <label for="amount">Enter Amount:</label>
            <input type="text" id="amount" name="amount" class="form-control" value="<%= request.getParameter("amount") != null ? request.getParameter("amount") : "" %>">
        </div>

        <div class="form-group" style="<%= "debit".equals(request.getParameter("transactionType")) ? "" : "display:none;" %>">
            <label for="debitType">Debit To:</label>
            <select id="debitType" name="debitType" class="form-control" onchange="this.form.submit()">
                <option value="self" <%= "self".equals(request.getParameter("debitType")) ? "selected" : "" %>>Self</option>
                <option value="other" <%= "other".equals(request.getParameter("debitType")) ? "selected" : "" %>>Other Account</option>
            </select>
        </div>

        <div class="form-group" style="<%= "debit".equals(request.getParameter("transactionType")) && "other".equals(request.getParameter("debitType")) ? "" : "display:none;" %>">
            <label for="receiverAccountNum">Receiver Account Number:</label>
            <input type="text" id="receiverAccountNum" name="receiverAccountNum" class="form-control" value="<%= request.getParameter("receiverAccountNum") != null ? request.getParameter("receiverAccountNum") : "" %>">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-secondary">Cancel</button>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
