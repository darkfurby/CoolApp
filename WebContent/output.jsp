<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% User user =(User) request.getAttribute("user"); %>
   <% int id =(int) request.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Wynik zapytania </h1>
	<p>chuj: <%= user.getUserName() %><br>
	<p>chuj: <%= id %><br>
	<a href="index.jsp">glowna strona</a>
</body>
</html>