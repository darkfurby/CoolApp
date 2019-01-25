<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% if(request.getUserPrincipal() != null) { } %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Content Page</title>
</head>
<body style="height:1500px">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      
      <a class="navbar-brand" href="index.jsp">Main Page</a>
    </div>
    <ul class="nav navbar-nav">
    <li><a href="login_page.jsp">Log in</a></li>
      <li><a href="register_page.jsp">Register new account</a></li>
      <li><a href="admin_page.jsp">Admin Panel</a></li>
      <li><a href="main_page.jsp">Content page, if you are logged in</a></li>
      <li><a href="about_me.jsp">About Me</a></li>
      <li><a href="https://github.com/darkfurby/CoolApp">My GIT repo</a></li> 
         
    </ul>
  </div>
</nav>
	
	
	<div id="demo"  style="margin-top:100px">
		<div class="jumbotron">
    <h1 style="text-align:center">Welcome to My Page! </h1>
    <p style="text-align:center">Please login to get access to the content. If you don't have account,
     please register and confirm your account with code that will come to your email account.</p>
    
	</div>
	</div>
	
 <br>
	<!-- <a href="test_conn.jsp">test polaczenia z baza</a><br> -->
	
	<br>
	

</body>
</html>