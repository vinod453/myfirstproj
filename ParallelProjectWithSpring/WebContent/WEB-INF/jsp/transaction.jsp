<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>transaction</title>
</head>
<body bgcolor="solid black">
	<h1 align="center">Transaction Details</h1>
	<table align="center">
		<tr>
			<td>Your transaction id is :</td>
			<td>${txn.txnId}</td>
		</tr>
		<tr>
			<td>Your transaction date is :</td>
			<td>${txn.txndate}</td>
		</tr>
		<tr>
			<td>Your transaction amount is :</td>
			<td>${txn.amount}</td>
		</tr>
		<tr>
			<td>Your transaction type is :</td>
			<td>${txn.txn_type}</td>
		</tr>

	</table>
	<h4 align="center">
		<a href="user.obj">Back</a>
	</h4>
</body>
</html>