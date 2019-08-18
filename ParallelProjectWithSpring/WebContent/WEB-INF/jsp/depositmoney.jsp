<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DepositMoney</title>
<style>
th, td {
	padding: 10px;
}

table {
	border-collapse: collapse;
	border: 5px solid black;
	padding: 10px;
}
</style>
</head>
<body bgcolor="solid black">
	<h1 align="center">Deposit Money</h1>
	<form:form action="DepositMoneyToWallet.obj" method="post">
		<table align="center">
			<tr>
				<td>Enter the amount to deposit</td>
				<td><input name="amount" /></td>
			</tr>
			<tr>
				<td colspan=2 align="right"><input type="submit"
					value="Deposit"></td>
			</tr>
		</table>
	</form:form>
	<h4 align="center">
		<a href="user.obj">Back</a>
	</h4>
</body>
</html>