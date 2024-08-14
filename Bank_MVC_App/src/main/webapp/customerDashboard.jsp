<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="customerNavbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Home</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <!-- Dynamic Content Section -->
        <div class="content-section mt-4">
            <%
                // Get the 'section' parameter from the URL
                String section = request.getParameter("section");
                
                // Load the appropriate content based on the 'section' parameter
                if ("viewPassbook".equals(section)) {
                    %><jsp:include page="viewPassbook.jsp" /> <%
                } else if ("newTransaction".equals(section)) {
                    %><jsp:include page="newTransaction.jsp" /> <%
                } else if ("editProfile".equals(section)) {
                    %><jsp:include page="editProfile.jsp" /> <%
                } else if ("logout".equals(section)) {
                    session.invalidate(); // Invalidate the session
                    response.sendRedirect("loginPage.jsp"); // Redirect to the login page
                    return;
                } else {
                    // Default content or a welcome message
                    %><p>Welcome to the Customer DashBoard.</p> <%
                }
            %>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
