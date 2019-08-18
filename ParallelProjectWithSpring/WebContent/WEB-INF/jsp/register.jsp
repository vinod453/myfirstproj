<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegisterPage</title>
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
	<h1 align="center">Register Page</h1>
	<form:form action="ValidateUser.obj" method="post"
		modelAttribute="customer">
		<table align="center">
			<tr>
				<td>Enter Name</td>
				<td><input name="name" required value="${customer.name}"></td>
				<td><font color="red"><form:errors path="name" /></font></td>
			</tr>
			<tr>
				<td>Enter amount to deposit</td>
				<td><input name="balance" required value="${customer.balance}"></td>
				<td><font color="red"><form:errors path="balance" /></font></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input name="password" required
					value="${customer.password}"></td>
				<td><font color="red"><form:errors path="password" /></font></td>
			</tr>
			<form:form modelAttribute="address">
				<tr>
					<td>Enter FlatNo</td>
					<td><input name="flatno" required value="${address.flatno}"></td>
					<td><font color="red"><form:errors path="flatno" /></font></td>
				</tr>
				<tr>
					<td>Enter Street</td>
					<td><input name="street" required value="${address.street}"></td>
					<td><font color="red"><form:errors path="street" /></font></td>
				</tr>
				<tr>
					<td>Enter City</td>
					<td><input name="city" required value="${address.city}"></input></td>
					<td><font color="red"><form:errors path="city" /></font></td>
				</tr>
				<tr>
					<td>Enter Pincode</td>
					<td><input name="pincode" required value="${address.pincode}"></input></td>
					<td><font color="red"><form:errors path="pincode" /></font></td>
				</tr>
			</form:form>
			<tr>
				<td>Enter Aadhar Card</td>
				<td><input name="aadharCard" required
					value="${customer.aadharCard}"></td>
				<td><font color="red"><form:errors path="aadharCard" /></font></td>
			</tr>
			<tr>
				<td>Enter PAN card</td>
				<td><input name="panCard" required value="${customer.panCard}"></td>
				<td><font color="red"><form:errors path="panCard" /></font></td>
			</tr>
			<tr>
				<td>Enter Phone Number</td>
				<td><input name="phoneNumber" required
					value="${customer.phoneNumber}"></td>
				<td><font color="red"><form:errors path="phoneNumber" /></font></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Submit" value="Register" /></td>
				<td></td>
			</tr>
		</table>
	</form:form>
</body>
</html>