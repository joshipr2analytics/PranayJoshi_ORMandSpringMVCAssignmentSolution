<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Customer Management</title>
</head>
<body>
	<div class="w3-container w3-orange">
		<h2 align="center">Customer Relationship Management</h2>
	</div>
	<div class="container">
		<a href="addCustomer" class="btn btn-primary">Add New Customer</a><br>
		<table class="table table-condensed table-hover table-bordered">
			<thead class="thead-light">
				<tr>
					<th><center>First Name</center></th>
					<th><center>Last Name</center></th>
					<th><center>Email</center></th>
					<th><center>Action</center></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Customers}" var="customer">
					<tr>
						<td><c:out value="${customer.firstName}" /></td>
						<td><c:out value="${customer.lastName}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td><a href="updateDetails?id=${customer.id}"
							class="btn btn-success">Update</a> <a
							href="deleteDetails?id=${customer.id}" class="btn btn-danger"
							onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>