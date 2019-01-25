<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> aby potwierdzić rejestracje konta, podaj kod </h1>
	<form action="ConfirmUserServlet" method="get">
	Podaj usera: <br><input type="text" name="user">
	Podaj kod: <br><input type="text" name="code">
	<input type="submit" value="potwierdz kod">
	</form>
</body>
</html>