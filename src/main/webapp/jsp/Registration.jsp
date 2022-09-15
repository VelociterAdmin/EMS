<%@page import="com.velociter.ems.helper.Operation"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Operation op = new Operation();
ArrayList<String> list = op.getCountries();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="Stylesheet" href="../Style.css">
<link rel="icon" type="image/x-icon" href="../Resources/vlogo.ico">
<meta charset="UTF-8">
<title>Registration</title>
<style type="text/css">
input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

input[type=number] {
	-moz-appearance: textfield;
}
</style>
</head>
<body>
	<br>
	<img src="../Resources/velociterlogo.png" />

	<form action="RegistrationServlet" method="Post">
		<table class="ResgitrationTable">
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="employeeName" required></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="employeeLastName" required></td>
			</tr>
			<tr>
				<td>Employee ID :</td>
				<td><input type="text" name="employeeId" required></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="employeeEmailId"
					style="text-transform: lowercase;"
					onkeyup="this.value = this.value.toLowerCase();" required></td>
			</tr>
			<tr>
				<td>Mobile Number :</td>
				<td><input type="text" name="mobileNumber" required></td>
			</tr>
			<tr>
				<td>Father's Name :</td>
				<td><input type="text" name="employeeFatherName" required></td>
			</tr>
			<tr>
				<td>Mother's Name :</td>
				<td><input type="text" name="employeeMotherName" required></td>
			</tr>
			<tr>
				<td>Reporting To :</td>
				<td><input type="text" name="reportingTo"></td>
			</tr>
			<tr>
				<td colspan="2" align=center>Address</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<table>
						<tr>
							<td>House Number :</td>
							<td><input type="text" name="houseNo" required></td>
						</tr>
						<tr>
							<td>Street Name :</td>
							<td><input type="text" name="streetName" required></td>
						</tr>
						<tr>
							<td>Locality :</td>
							<td><input type="text" name="locality" required></td>
						</tr>
						<tr>
							<td>City :</td>
							<td><input type="text" name="city" required></td>
						</tr>
						<tr>
							<td>State :</td>
							<td><input type="text" name="state" required></td>
						</tr>
						<tr>
							<td>Pin Code :</td>
							<td><input type="number" name="pincode" required></td>
						</tr>
						<tr>
							<td>Country :</td>
							<td><select name="country" required>
									<option value="">Select Country</option>
									<%
									for (String showCountry : list) {
									%>
									<option value="<%=showCountry%>"><%=showCountry%></option>
									<%
									}
									%>
							</select></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><select name="designation" required>
						<option value="Employee">Employee</option>
						<option value="Manager">Manager</option>
				</select></td>
			</tr>
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username"
					style="text-transform: lowercase;"
					onkeyup="this.value = this.value.toLowerCase();" required></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" id="p1" required></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><input type="password" name="confirmPassword" id="p2"
					required></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type="submit"
					name="submitButton" value="Register"> <input type="reset"
					name="resetButton" value="Reset"> <a href="Login.jsp">Login</a></td>
			</tr>
		</table>
	</form>
</body>
</html>