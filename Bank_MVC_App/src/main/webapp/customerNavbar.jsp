<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="customerDashboard.jsp">AurionPro Bank</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="customerDashboard.jsp?section=viewPassbook">View Passbook</a></li>
                <li class="nav-item"><a class="nav-link" href="customerDashboard.jsp?section=newTransaction">New Transaction</a></li>
                <li class="nav-item"><a class="nav-link" href="customerDashboard.jsp?section=editProfile">Edit Profile</a></li>
                <li class="nav-item"><a class="nav-link" href="customerDashboard.jsp?section=logout">LogOut</a></li>
            </ul>
        </div>
    </nav>
</body>
</html>
