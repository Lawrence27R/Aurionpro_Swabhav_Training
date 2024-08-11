<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>

<h2>User List</h2>

<table border="1">
<tr>
    <th>User Id</th>
    <th>Username</th>
    <th>Password</th>
</tr>

<c:forEach var="user" items="${users}">
<tr>
    <td>${user.getUserId()}</td>
    <td>${user.getUsername()}</td>
    <td>${user.getPassword()}</td>
</tr>
</c:forEach>
</table>

</body>
</html>
