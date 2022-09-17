<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
</head>
<body>
	<div style="width: 33.33%">
		<img src="../Resources/velociterlogo.png" />
	</div>
	<form action="StudentServlet" method="post">
		<h2 align="center">Student Details</h2>
		<table align="center">
			<tr>
				<td>FirstName</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="firstName" required></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')"  name="lastName" required></td>
			</tr>

			<tr>
				<td>FatherName</td>
				<td><input type="text"oninput="value=value.replace(/[^a-zA-Z ]/g,'')"  name="fatherName" required></td>
			</tr>
			<tr>
				<td>MotherName</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="motherName" required></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email"  name="email" required></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td><input type="tel" name="contact"
					oninput="this.value=this.value.replace(/[^0-9]/g,'').replace(/(\..*)\./g,'$1')"
					minlength="10" maxlength="10" pattern="[6789][0-9]{9}"
					title="Please enter valid phone number" required></td>

			</tr>
			<tr>
				<td>House No</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z0-9 -]/g,'')" name="houseNo" required></td>
			</tr>
			<tr>
				<td>Street</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z0-9 -]/g,'')" name="street" required></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="city" required></td>
			</tr>
			<tr>
				<td>Pincode</td>
				<td><input type="text"
					oninput="this.value=this.value.replace(/[^0-9]/g,'')"
					name="pincode" minlength="6" maxlength="6"  required></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z .]/g,'')" name="state" required></td>
			</tr>
			<tr>
				<td>Field</td>
				<td><select name="field">
						<option value="Secondary">Secondary</option>
						<option value="Higher-Secondary">Higher-Secondary</option>
						<option value="Graduation">Graduation</option>
						<option value="Post-Graduation">Post-Graduation</option>
				</select></td>
			</tr>
			<tr>
				<td>Institute Name</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="instituteName" required></td>
			</tr>
			<tr>
				<td>Board/University</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="boardorUniversity" required></td>
			</tr>
			<tr>
				<td>Grade</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="grade" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" required> <input
					type="reset" value="Cancel"></td>
			</tr>

		</table>
	</form>

</body>
</html>