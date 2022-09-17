
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Ticket</title>
</head>
<body>
	<div style="width: 33.33%">
		<img src="../Resources/velociterlogo.png" />
	</div>
	<form action="MovieTicketServlet" method="post">
		<h2 align="center">Movie Ticket</h2>
		<table align="center">
			<tr>
				<td>Movie Type</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="movieType"  required></td>
			</tr>
			<tr>
				<td>Movie Name</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z0-9 .]/g,'')" name="movieName" required></td>
			</tr>

			<tr>
				<td>Screen No.</td>
				<td><select name="screenNo">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
				</select></td>
			</tr>
			<tr>
				<td>Movie Time</td>
				<td><input type="time" name="movieTime" required></td>
			</tr>
			<tr>
				<td>Seat Type</td>
				<td><select name="seatType">
						<option value="Silver">Silver</option>
						<option value="Gold">Gold</option>
						<option value="Platinum">Platinum</option>
				</select></td>
			</tr>
			<tr>
				<td>Seat No.</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z0-9 ,]/g,'')" name="seatNum" required></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" oninput="this.value=this.value.replace(/[^0-9.]/g,'')"  name="price" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"> <input
					type="reset" value="Cancel"></td>
			</tr>

		</table>
	</form>
</body>
</html>