<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<Style>
td {
	color: black;
	padding: 20px;
	font-size: 15px;
	font-family: 'Arial';
}

input[type="text"], input[type="password"], input[type="number"] {
	width: 90%;
}

body {
	background-color: lightblue;
}
</Style>
<h1 align="center">Registration Page</h1>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<form action="RegistrationServlet" method="Post">
		<table align="center">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="employeeName" required></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="employeeLastName" required></td>
			</tr>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="employeeId" required></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><input type="email" name="employeeEmailId" required></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobileNumber" required></td>
			</tr>
			<tr>
				<td>Father's Name</td>
				<td><input type="text" name="employeeFather'sName" required></td>
			</tr>
			<tr>
				<td>Mother's Name</td>
				<td><input type="text" name="employeeMother'sName" required></td>
			</tr>
			<tr>
				<td colspan="2" align=center>Address</td>
			</tr>
			<tr>
				<td></td>
				<td>

					<table align="center">
						<tr>
							<td>House no</td>
							<td><input type="text" name="houseNo." required></td>
						</tr>
						<tr>
							<td>Street Name</td>
							<td><input type="text" name="streetName" required></td>
						</tr>
						<tr>
							<td>Locality</td>
							<td><input type="text" name="locality" required></td>
						</tr>
						<tr>
							<td>City</td>
							<td><input type="text" name="city" required></td>
						</tr>
						<tr>
							<td>State</td>
							<td><input type="text" name="state" required></td>
						</tr>
						<tr>
							<td>Pin Code</td>
							<td><input type="number" name="pincode" required></td>
						</tr>
						<tr>
							<td>Country</td>
							<td><input type="text" name="country" required></td>
						</tr>


					</table>

				</td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" name="designation" required></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" required></td>


			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="confirmPassword" required></td>
			</tr>


			<tr>
				<td colspan=2 align=center><br> <input type="submit"
					name="submitButton" value="Submit"> <input type="reset"
					name="resetButton" value="Reset"></br> <a href="login.jsp">Login</a></td>
			</tr>


		</table>
	</form>
</body>
</html>