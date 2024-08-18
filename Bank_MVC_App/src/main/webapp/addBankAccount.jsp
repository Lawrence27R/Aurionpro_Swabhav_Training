<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, com.aurionpro.entity.Customer"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Bank Account</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="recent-customers">
            <h4>Recently Added Customers</h4>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Customer ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    List<Customer> recentCustomers = (List<Customer>) request.getAttribute("recentCustomers");
                    if (recentCustomers != null && !recentCustomers.isEmpty()) {
                        for (Customer customer : recentCustomers) {
                    %>
                    <tr>
                        <td><%= customer.getCustomerId() %></td>
                        <td><%= customer.getCustomerFName() %></td>
                        <td><%= customer.getCustomerLName() %></td>
                        <td><%= customer.getEmailId() %></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="4" class="text-center">No recent customers found.</td>
                    </tr>
                    <%
                    }
                    %>
                </tbody>
            </table>
            <form action="addBankAccount" method="get">
                <button type="submit" name="action" value="showRecent" class="btn btn-primary mb-2">Show Recent Customers</button>
            </form>
        </div>

        <h2 class="text-center">Search Customer by ID</h2>
        <form action="addBankAccount" method="get" class="form-inline justify-content-center mb-2">
            <div class="form-group mb-2">
                <input type="text" class="form-control" id="customerId" name="customerId"
                       placeholder="Enter Customer ID" required>
            </div>
            <input type="hidden" name="section" value="addBankAccount">
            <button type="submit" class="btn btn-primary mb-2 ml-2">Search</button>
        </form>

        <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
        %>
        <div class="alert alert-danger" role="alert">
            <%= errorMessage %>
        </div>
        <%
        } else {
            String firstName = (String) request.getAttribute("firstName");
            String lastName = (String) request.getAttribute("lastName");
            String email = (String) request.getAttribute("email");
            String accountNumber = (String) request.getAttribute("accountNumber");
            Boolean showAccountButton = (Boolean) request.getAttribute("showAccountButton");
            if (firstName != null || lastName != null || email != null) {
        %>
        <div class="card">
            <div class="card-header">Customer Details</div>
            <div class="card-body">
                <p><strong>First Name:</strong> <%= firstName != null ? firstName : "N/A" %></p>
                <p><strong>Last Name:</strong> <%= lastName != null ? lastName : "N/A" %></p>
                <p><strong>Email:</strong> <%= email != null ? email : "N/A" %></p>
                <%
                if (accountNumber != null) {
                %>
                <p><strong>Account Number:</strong> <%= accountNumber %></p>
                <%
                } else if (showAccountButton != null && showAccountButton) {
                %>
                <form action="addBankAccount" method="post">
                    <input type="hidden" name="customerId" value="<%= request.getParameter("customerId") %>">
                    <input type="hidden" name="section" value="addBankAccount">
                    <button type="submit" class="btn btn-primary" name="generateAccount" value="true">Generate Account Number</button>
                </form>
                <%
                }
                %>
            </div>
        </div>
        <%
            }
        }
        %>

        <div class="mt-3">
            <a href="adminDashboard.jsp" class="btn btn-info">Go to Admin Dashboard</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
