<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<form action="RegistrationServlet" method="Post">
	<table align="center">
		<tr>
			<td>First Name</td>
			<td><input type="text" name="employeeName"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="employeeLastName"></td>
		</tr>
		<tr>
			<td>Employee ID</td>
			<td><input type="text" name="employeeId"></td>
		</tr>
		<tr>
			<td>Email Address</td>
			<td><input type="text" name="employeeEmailId"></td>
		</tr>
		<tr>
			<td>Mobile Number</td>
			<td><input type="text" name="mobileNumber"></td>
		</tr>
		<tr>
			<td>Father's Name</td>
			<td><input type="text" name="employeeFather'sName"></td>
		</tr>
		<tr>
			<td>Mother's Name</td>
			<td><input type="text" name="employeeMother'sName"></td>
		</tr>
		<tr>
			<td colspan="2">Address</td>
		</tr>
		<tr>
			<td></td>
			<td>

				<table align="center">
					<tr>
						<td>House no</td>
						<td><input type="text" name="houseNo."></td>
					</tr>
					<tr>
						<td>Street Name</td>
						<td><input type="text" name="streetName"></td>
					</tr>
					<tr>
						<td>Locality</td>
						<td><input type="text" name="locality"></td>
					</tr>
					<tr>
						<td>City</td>
						<td><input type="text" name="city"></td>
					</tr>
					<tr>
						<td>State</td>
						<td><input type="text" name="state"></td>
					</tr>
					<tr>
						<td>Pin Code</td>
						<td><input type="number" name="pincode"></td>
					</tr>
					<tr>
						<td>Country</td>
						<td><input type="text" name="country"></td>
					</tr>


				</table>

			</td>
		</tr>
		<tr>
			<td>Designation</td>
			<td><input type="text" name="designation"></td>
		</tr>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username"></td>


		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><input type="password" name="confirmPassword"></td>
		</tr>
		<table align="center">

			<tr>
				<td><br> <input type="submit" name="submitButton"
					value="Submit"></br></td>
				<td><br> <input type="reset" name="resetButton"
					value="Reset"></br>
					<a href="login.jsp">Login</a>
					</td>	
			</tr>
		</table>
		</form>


	</table>
</html>