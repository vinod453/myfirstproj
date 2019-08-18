<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registeredPage</title>
</head>
<body bgcolor="solid black">
	<form action="validateLogin.obj" method="post">
		<h2 align="center">
			Your account number :<input type="number" name="accno"
				value="${customer.accno}" readonly />
		</h2>
		<h2 align="center">
			Your account password : <input type="text" name="password"
				value="${customer.password}" readonly />
		</h2>
		<h3 align="center">
			<input type="submit">
		</h3>
	</form>
</body>
</html>