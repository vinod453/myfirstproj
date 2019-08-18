<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
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
	<h1 align="center">Transactions</h1>
	<table align="center">
		<tr>
			<th>Transaction id</th>
			<th>Transaction Date</th>
			<th>Transaction amount</th>
			<th>Transaction type</th>
			<th>Transaction AccountNo.</th>
		</tr>
		<core:forEach items="${transactions}" var="temp">
			<tr>
				<td>${temp.txnId}</td>
				<td>${temp.txndate}</td>
				<td>${temp.amount}</td>
				<td>${temp.txn_type}</td>
				<td>${temp.tgtAcc}</td>
			</tr>
		</core:forEach>
	</table>
	<h4 align="center">
		<a href="user.obj">Back</a>
	</h4>
</body>
</html>