<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("empId") == null) {
	response.sendRedirect("Login.jsp");
} else {
	String first = (String) session.getAttribute("firstname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../Style.css">
<title>Animal Details</title>
</head>
<body>
	<img src="../Resources/velociterlogo.png" />
	<form action="AnimalRegistrationServlet" method="post">
		<table align="center">
			<tr>
				<td>Animal Name:</td>
				<td><input type="text" name="AnimalName" required="required"></td>
			</tr>
			<tr>
				<td>Animal Type:</td>
				<td><input type="radio" value="Domestic" name="AnimalType"
					required="required">Domestic <input type="radio"
					value="Wild" name="AnimalType">Wild</td>
			</tr>
			<tr>
				<td>Animal Breed:</td>
				<td><input type="text" name="AnimalBreed" required="required"></td>
			</tr>
			<tr>
				<td>Animal Weight:</td>
				<td><input type="text" name="AnimalWeight" required="required"></td>
			</tr>
			<tr>
				<td>Animal Height:</td>
				<td><input type="text" name="AnimalHeight" required="required"></td>
			</tr>
			<tr>
				<td>Animal Leg Count:</td>
				<td><select name="AnimalLegs" required="required">
						<option value="2">Two</option>
						<option value="4">Four</option>
				</select></td>
			</tr>
			<tr>
				<td>Animal Reproduction Type:</td>
				<td><select name="AnimalReproduct" required="required">
						<option value="Oviporus">Oviporus(Eggs)</option>
						<option value="Viviporus">Viviporus(Younger version)</option>
				</select></td>
			</tr>
			<tr>
				<td>Animal Food:</td>
				<td><input type="text" name="AnimalFood" required="required"></td>
			</tr>
			<tr>
				<td>Animal Diet:</td>
				<td><input type="text" name="AnimalDiet" required="required"></td>
			</tr>
			<tr>
				<td>Animal LifeSpan:</td>
				<td><input type="text" name="AnimalLife" required="required"></td>
			</tr>
			<tr>
				<td>Animal Place:</td>
				<td><input type="text" name="AnimalPlace" required="required"></td>
			</tr>
			<tr>
				<td>Animal Benifits:</td>
				<td><input type="text" name="AnimalBenifits"
					required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save Animal Details"> <input type="reset"
					value="Clear"></td>
			</tr>
		</table>
	</form>
</body>
</html>


<%
}
%>