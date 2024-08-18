<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="customerNavbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Home</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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

                if (section == null) {
                    section = "";
                }

                switch (section) {
                    case "viewPassbook":
                        %><jsp:include page="viewPassbook.jsp" /> <%
                        break;
                    case "newTransaction":
                        %><jsp:include page="newTransaction.jsp" /> <%
                        break;
                    case "editProfile":
                        %><jsp:include page="editProfile.jsp" /> <%
                        break;
                    case "logout":
                        session.invalidate();
                        response.sendRedirect("logout.jsp");
                        return;
                    default:
                        %><h2>Welcome to the Customer Dashboard</h2><%
                }
            %>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
