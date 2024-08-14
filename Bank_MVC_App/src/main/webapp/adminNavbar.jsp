<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="adminDashboard.jsp">AurionPro Bank</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="adminDashboard.jsp?section=addCustomer">Add New Customer</a></li>
                <li class="nav-item"><a class="nav-link" href="adminDashboard.jsp?section=addBankAccount">Add Bank Account</a></li>
                <li class="nav-item"><a class="nav-link" href="adminDashboard.jsp?section=viewCustomers">View Customers</a></li>
                <li class="nav-item"><a class="nav-link" href="adminDashboard.jsp?section=viewTransactions">View Transactions</a></li>
                <li class="nav-item"><a class="nav-link" href="adminDashboard.jsp?section=logout">LogOut</a></li>
            </ul>
        </div>
    </nav>
</body>
</html>
