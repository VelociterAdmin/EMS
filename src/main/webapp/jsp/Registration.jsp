<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" href="../Style.css">
<meta charset="UTF-8">
<title>Registration</title>
<script type="text/javascript">
function verifyPassword(){
	var password = document.getElementById("p1");
	var confirmPassword = document.getElementById("p2");
	if(password!=confirmPassword){
		alert("Password does not match");
	}
	
}
</script>
</head>
<body>
	<h1 align="left">Registration Page</h1>

	<form action="RegistrationServlet" method="Post">
		<table class="ResgitrationTable">
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

					<table align="left">
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
				<td><input type="password" name="password" id="p1" required></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="confirmPassword" id="p2"
					required></td>
			</tr>


			<tr>
				<td colspan=2 align=center> <input type="submit"
					name="submitButton" value="Submit">
					<input type="reset" name="resetButton" value="Reset">
					<a href="Login.jsp">Login</a></td>
			</tr>


		</table>
	</form>
</body>
</html>