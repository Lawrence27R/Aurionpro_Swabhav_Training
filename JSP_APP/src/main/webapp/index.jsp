<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<b>

<%-- Scriplet Tag --%>
<% 
out.print(new Date());
%>

<%-- Expression Tag --%>
<h1><%= new java.util.Date()  %></h1>

<%-- Declaration Tag --%>
<%! String name = "Lawrence"; %>

<h2>Welcome :<%= name %> </h2>
</b>

    <%@ include file = "insert.jsp" %>
</body>
</html>