<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>
<style>
th, td {
	padding: 10px;
}

table {
	border-collapse: collapse;
	border: 2px solid black;
	padding: 10px;
}
</style>
</head>
<body bgcolor="solid black">
	<h1 align="center">Login Page</h1>
	<form:form action="validateLogin.obj" modelAttribute="customer">
		<table align="center">
			<tr>
				<td>Enter Account number</td>
				<td><form:input path="accno"></form:input></td>
			</tr>
			<tr>
				<td>Enter password</td>
				<td><form:password path="password"></form:password></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Submit" value="Login" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>