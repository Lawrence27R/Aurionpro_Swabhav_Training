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
        <div class="content-section mt-4">
            <%
                String section = request.getParameter("section");

                switch (section) {
                    case "addCustomer":
                        %><jsp:include page="addCustomer.jsp" /><%
                        break;
                    case "addBankAccount":
                        %><jsp:include page="addBankAccount.jsp" /><%
                        break;
                    case "viewCustomers":
                        %><jsp:include page="viewCustomers.jsp" /><%
                        break;
                    case "viewTransactions":
                        %><jsp:include page="viewTransactions.jsp" /><%
                        break;
                    case "logout":
                        session.invalidate();
                        response.sendRedirect("logout.jsp");
                        return;
                    default:
                        %><h2>Welcome to the Admin Dashboard</h2><%
                        break;
                }
            %>
        </div>
    </div>
</body>
</html>
