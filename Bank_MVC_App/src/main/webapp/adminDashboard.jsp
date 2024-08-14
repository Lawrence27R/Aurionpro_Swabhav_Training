<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="adminNavbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home</title>
    <style>
    .content-section {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 60vh;
    }
    </style>
</head>
<body>
    <div class="container">
        <!-- Dynamic Content Section -->
        <div class="content-section mt-4">
            <% 
            String section = request.getParameter("section");
            if ("addCustomer".equals(section)) {
                %><jsp:include page="addCustomer.jsp" />
            <% 
            } else if ("addBankAccount".equals(section)) {
                %><jsp:include page="addBankAccount.jsp" />
            <% 
            } else if ("viewCustomers".equals(section)) {
                %><jsp:include page="viewCustomers.jsp" />
            <% 
            } else if ("viewTransactions".equals(section)) {
                %><jsp:include page="viewTransactions.jsp" />
            <% 
            } else if ("logout".equals(section)) {
                session.invalidate();
                response.sendRedirect("loginPage.jsp");
                return;
            } else {
                %><h2>Welcome to the Admin Dashboard</h2>
            <% 
            }
            %>
        </div>
    </div>
</body>
</html>
