<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>details</title>
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
	<h1 align="center">Welcome ${customer.name}</h1>
	<table align="center">
		<tr>
			<td><a href="GetCustomer.obj">Get Customer Details</a></td>
		</tr>
		<tr>
			<td><a href="ShowBalanceWallet.obj">ShowBalance in Wallet</a></td>
		</tr>
		<tr>
			<td><a href="ShowBalanceAccount.obj">ShowBalance in Account</a></td>
		</tr>
		<tr>
			<td><a href="DepositMoney.obj">Deposit money into Wallet</a></td>
		</tr>
		<tr>
			<td><a href="WithdrawMoney.obj">Withdraw money from Wallet</a></td>
		</tr>
		<tr>
			<td><a href="FundTransfer.obj">FundTransfer</a></td>
		</tr>
		<tr>
			<td><a href="PrintTransactions.obj">Print Transactions</a></td>
		</tr>
		<tr>
			<td><a href="ShowHome.obj">Logout</a></td>
		</tr>
	</table>
</body>
</html>