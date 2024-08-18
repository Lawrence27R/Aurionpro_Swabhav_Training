<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Customer</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <%
            String success = request.getParameter("success");
            String error = request.getParameter("error");
            if ("true".equals(success)) {
        %>
            <div class="alert alert-success">Customer added successfully!</div>
        <%
            } else if (error != null) {
                String errorMessage = "Error adding customer.";
                if ("emailExists".equals(error)) errorMessage = "Email ID already exists.";
                else if ("invalidName".equals(error)) errorMessage = "First and last name must contain only alphabets.";
                else if ("invalidPassword".equals(error)) errorMessage = "Password must be at least 8 characters long and contain at least one special character.";
        %>
            <div class="alert alert-danger"><%= errorMessage %></div>
        <%
            }
        %>

        <form action="AddCustomerController" method="post">
            <div class="form-group">
                <label for="firstname">First Name:</label>
                <input type="text" class="form-control" id="firstname" name="firstname" required>
            </div>
            <div class="form-group">
                <label for="lastname">Last Name:</label>
                <input type="text" class="form-control" id="lastname" name="lastname" required>
            </div>
            <div class="form-group">
                <label for="email">Email ID:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-secondary">Cancel</button>
        </form>

        <div class="mt-3">
            <a href="adminDashboard.jsp" class="btn btn-info">Go to Admin Dashboard</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
