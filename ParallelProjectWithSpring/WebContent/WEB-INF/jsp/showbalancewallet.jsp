<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WalletBalance</title>
</head>
<body bgcolor="solid black">
	<h1></h1>
	<h3 align="center">Your wallet balance is : ${customer.amount}</h3>
	<h4 align="center">
		<a href="user.obj">Back</a>
	</h4>
</body>
</html>