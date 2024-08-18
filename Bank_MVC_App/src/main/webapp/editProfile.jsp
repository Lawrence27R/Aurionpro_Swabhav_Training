<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, com.aurionpro.data.BankMvcAppDB"%>
<%
Integer customerId = (Integer) session.getAttribute("customerId");
BankMvcAppDB db = new BankMvcAppDB();
ResultSet rs = db.getCustomerById(customerId.toString());

String firstName = "";
String lastName = "";
String email = "";
String password = "";
String showPassword = request.getParameter("showPassword");

if (rs.next()) {
    firstName = rs.getString("customerFName");
    lastName = rs.getString("customerLName");
    email = rs.getString("emailId");
    password = rs.getString("customerPassword");
}

String passwordInputType = "password";
if (showPassword != null && showPassword.equals("on")) {
    passwordInputType = "text";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View/Edit Profile</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <form action="editProfile.jsp" method="post">
            <div class="form-group">
                <label for="firstName">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="<%=firstName%>">
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="<%=lastName%>">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="<%=email%>">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="<%=passwordInputType%>" class="form-control" id="password" name="password" value="<%=password%>">
                <div class="form-check mt-2">
                    <input type="checkbox" class="form-check-input" id="showPassword" name="showPassword"
                        <%= (showPassword != null && showPassword.equals("on")) ? "checked" : "" %>
                        onchange="this.form.submit()">
                    <label class="form-check-label" for="showPassword">Show Password</label>
                </div>
            </div>
            <button type="submit" class="btn btn-success">Update Profile</button>
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
