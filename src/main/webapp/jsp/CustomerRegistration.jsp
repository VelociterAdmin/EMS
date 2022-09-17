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
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="../Resources/vlogo.ico">
<title>Flight Booking</title>
<link rel="stylesheet" href="../Style.css">
</head>
<body>
	<img src="../Resources/velociterlogo.png" />
	<form action="CustomerRegistrationServlet" method="post">
		<h1 align="center">Customer Registration</h1>
		<table align="center">


			<tr>
				<td>First Name :</td>
				<td><input type="text"
					oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="firstName"
					name="firstName" required></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text"
					oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="lastName"
					required></td>
			</tr>
			<tr>
				<td>Mobile No :</td>
				<td><input type="tel"
					oninput="this.value=this.value.replace(/[^0-9]/g,'').replace(/(\..*)\./g,'$1')"
					name="mobileNo" minlength="10" maxlength="10"
					pattern="[6789][0-9]{9}"
					title="Please enter the valid phone number" required></td>
			</tr>
			<tr>
				<td>House No :</td>
				<td><input type="text" name="houseNo" required></td>
			</tr>
			<tr>
			<tr>
				<td>Street Name :</td>
				<td><input type="text" name="streetName" required></td>
			</tr>
			<tr>
				<td>Area Name :</td>
				<td><input type="text" name="areaName" required></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><input type="text"
					oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="city"
					required></td>
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
			<tr>
				<td>PinCode :</td>
				<td><input type="text"
					oninput="this.value=this.value.replace(/[^0-9]/g,'').replace(/(\..*)\./g,'$1')"
					name="pinCode" minlength="6" maxlength="6" required></td>
			</tr>
			<td colspan=2 align=center><input type="submit"
				name="submitButton" value="Register"> <input type="reset"
				value="clear"></td>


		</table>
	</form>
</body>
</html>