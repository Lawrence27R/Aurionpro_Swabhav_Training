<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet, java.sql.SQLException" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>View Customers</title>
<!-- Bootstrap CSS -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
<!--     <h2 class="text-center">View Customers</h2> -->

    <!-- Filter Options -->
    <form action="viewCustomers" method="get" class="form-inline mb-4">
        <div class="form-group mr-2">
            <label for="sortBy" class="mr-2">Sort By:</label>
            <select id="sortBy" name="sortBy" class="form-control">
                <option value="balance">Maximum Balance</option>
                <option value="accountNumber">Ascending Account Number</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Apply Filter</button>
    </form>

    <!-- Customer Table -->
    <table class="table table-striped">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Account Number</th>
                <th>Balance</th>
            </tr>
        </thead>
        <tbody>
            <% 
            // Retrieve the result set and error message from the request attributes
            ResultSet rs = (ResultSet) request.getAttribute("customers");
            String errorMessage = (String) request.getAttribute("errorMessage");

            // Display error message if any
            if (errorMessage != null) {
            %>
                <tr>
                    <td colspan="4" class="text-danger"><%= errorMessage %></td>
                </tr>
            <% 
            } else {
                try {
                    if (rs != null) {
                        while (rs.next()) {
                            String firstName = rs.getString("customerFName");
                            String lastName = rs.getString("customerLName");
                            String accountNumber = rs.getString("customerAccountNum");
                            double balance = rs.getDouble("customerBalance");
            %>
            <tr>
                <td><%= firstName %></td>
                <td><%= lastName %></td>
                <td><%= accountNumber %></td>
                <td><%= balance %></td>
            </tr>
            <% 
                        }
                    } else {
            %>
                <tr>
                    <td colspan="4">No customers found.</td>
                </tr>
            <% 
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Display the SQL error message
            %>
                <tr>
                    <td colspan="4" class="text-danger">Error: <%= e.getMessage() %></td>
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
