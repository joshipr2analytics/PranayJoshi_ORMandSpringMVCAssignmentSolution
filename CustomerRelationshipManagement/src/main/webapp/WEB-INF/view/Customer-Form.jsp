<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<Style>
#formUpdate {
	margin-top: 20px;
}
</Style>
<title>Customer Form</title>
</head>
<body>
	<div class="w3-container" id="formUpdate">
		<div class="w3-card-4">
			<div class="w3-container w3-green">
				<h2>Add/Update Customer</h2>
			</div>
			<form action="saveDetails" method="post" class="w3-container">
				<!-- Add hidden form field to handle update -->
				<input type="hidden" name="id" value="${Customer.id}" /> <br /> <input
					type="text" name="firstName" value="${Customer.firstName}"
					class="w3-input" placeholder="First Name"> <br /> <input
					type="text" name="lastName" value="${Customer.lastName}"
					class="w3-input" placeholder="Last Name"> <br /> <input
					type="text" name="email" value="${Customer.email}" class="w3-input"
					placeholder="Email Address"> <br /> <input type="submit"
					value="SAVE" class="btn btn-info col-2" /> <br /> <br /> <a
					href="/CustomerRelationshipManagement/"
					class="btn btn-success col-4">BACK TO CUSTOMER LIST</a> <br /> <br />
			</form>

		</div>
	</div>
</body>
</html>