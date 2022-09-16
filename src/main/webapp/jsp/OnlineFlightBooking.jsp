<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="flightBookingServlet" method="post">
		<h1 align="center">Flight Booking</h1>
		<table align="center">

			<tr>
				<td>Current Location</td>
				<td><input type="text"
					oninput="value=value.replace(/[^a-zA-Z ]/g,'')"
					name="currentLocation" required></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><input type="text"
					oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="destination"
					required></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><input type="date" name="date" required></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type="submit"
					name="submitButton" value="Submit"> <input type="reset"
					value="clear"></td>
		</table>
	</form>
</body>
</html>