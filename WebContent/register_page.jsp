<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
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

<div class="container" style="margin-top:100px" align="center">
  <h2>Please Register</h2>
  <form class="form-inline" action="RegisterServlet" method="post">
    <div class="form-group">
      <label for="text">Login:</label>
      <input type="text" class="form-control" placeholder="Enter login" name="user_name">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" placeholder="Enter password" name="user_password">
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" placeholder="Enter email" name="user_email">
    </div>
    <div class="radio" align="left">
      <input type="radio" name="chooseUserType" value="user">User<br>
      <!--<input type="radio" name="chooseUserType" value="foodtruck" class="disabled">Super User<br>  -->
  	  <a data-toggle="tooltip" data-placement="bottom" title="Sorry, still working on this feature, you will be still registered as simple user."><input type="radio" name="chooseUserType" value="user" class="disabled">Super User<br> </a>
    </div>
    <br>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>