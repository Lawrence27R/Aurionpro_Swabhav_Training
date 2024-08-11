<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:out value="Lawrence"></c:out>

<c:set var="name" value = "Rodriques" scope = "session"></c:set>
<c:out value="${name}"></c:out>

<c:set var="number" value="6"></c:set>

<c:if test="${number%2 == 0}">
<h1>Even</h1>
</c:if>

<c:choose>
    <c:when test="${number % 2 == 0}">
        <h3>The number is even.</h3>
    </c:when>
    <c:otherwise>
        <h3>The number is odd.</h3>
    </c:otherwise>
</c:choose>

<c:forEach var="j" begin="1" end="5">  
   Item <c:out value="${j}"/><p>  
</c:forEach>  


</body>
</html>