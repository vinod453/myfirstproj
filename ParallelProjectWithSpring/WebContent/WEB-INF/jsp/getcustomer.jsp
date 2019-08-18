<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerDetails</title>
</head>
<body bgcolor="solid black">
	<h1 align="center">Customer Details</h1>
	<h2 align="center">Customer Name : ${customer.name}</h2>
	<h2 align="center">Your Account balance : ${customer.balance}</h2>
	<h2 align="center">Your Wallet balance : ${customer.amount}</h2>
	<h2 align="center">Your Phone number : ${customer.phoneNumber}</h2>
	<h4 align="center">
		<a href="user.obj">Back</a>
	</h4>
</body>
</html>