<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, com.aurionpro.data.BankMvcAppDB" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Transaction</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2 class="mt-4">Make a Transaction</h2>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        String successMessage = (String) request.getAttribute("successMessage");
    %>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger"><c:out value="${errorMessage}"/></div>
    </c:if>
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success"><c:out value="${successMessage}"/></div>
    </c:if>

    <form action="NewTransactionController" method="post">
        <div class="form-group">
            <label for="transactionType">Select Transaction Type:</label>
            <select id="transactionType" name="transactionType" class="form-control" onchange="this.form.submit()">
                <option value="credit" ${'credit'.equals(request.getParameter("transactionType")) ? 'selected' : ''}>Credit</option>
                <option value="debit" ${'debit'.equals(request.getParameter("transactionType")) ? 'selected' : ''}>Debit</option>
            </select>
        </div>

        <div class="form-group">
            <label for="amount">Enter Amount:</label>
            <input type="text" id="amount" name="amount" class="form-control" value="${request.getParameter("amount") != null ? request.getParameter("amount") : ''}">
        </div>

        <c:choose>
            <c:when test="${'debit'.equals(request.getParameter("transactionType"))}">
                <div class="form-group">
                    <label for="debitType">Debit To:</label>
                    <select id="debitType" name="debitType" class="form-control" onchange="this.form.submit()">
                        <option value="self" ${'self'.equals(request.getParameter("debitType")) ? 'selected' : ''}>Self</option>
                        <option value="other" ${'other'.equals(request.getParameter("debitType")) ? 'selected' : ''}>Other Account</option>
                    </select>
                </div>
                
                <c:choose>
                    <c:when test="${'other'.equals(request.getParameter("debitType"))}">
                        <div class="form-group">
                            <label for="receiverAccountNum">Receiver Account Number:</label>
                            <input type="text" id="receiverAccountNum" name="receiverAccountNum" class="form-control" value="${request.getParameter("receiverAccountNum") != null ? request.getParameter("receiverAccountNum") : ''}">
                        </div>
                    </c:when>
                </c:choose>
            </c:when>
        </c:choose>

        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-secondary">Cancel</button>
    </form>

    <div class="mt-3">
        <a href="customerDashboard.jsp" class="btn btn-info">Go to Customer Dashboard</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
