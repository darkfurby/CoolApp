<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" >
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

		
		<div class="container" style="margin-top:100px">
  <div class="jumbotron" >
    <h1>A little bit about this project</h1>      
    <p>Hello. You are probably here because You have seen this page in my CV. 
			I have created this web application to show my skills. Currently I work as System Administrator and I do
			some programming after working hours, so currently I have no commercial experience in programming. Skills gained
			so far: JavaSE, basics of JavaEE, web application is based on servlet's, MVC model, data source, javaBeans,
			DAO and CRUD. Application is connected to database MySQL and is deployed on Tomcat. Actually still developing myself
			so I don't need better Webserver to write API's.</p>
  </div>    
</div>
</body>
</html>