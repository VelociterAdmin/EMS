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
<title>Order</title>
</head>
<body>
	<img src="../Resources/velociterlogo.png" />
	<form action="OrderServlet" method="post">
		<table align="center">
			<tr>
				<td>Item Name:</td>
				<td><input type="text" name="ItemName" required="required"></td>
			</tr>
			<tr>
				<td>Item Type:</td>
				<td><input type="text" name="ItemType" required="required"></td>
			</tr>
			<tr>
				<td>Item Price:</td>
				<td><input type="text"
					oninput="this.value = this.value.replace(/[^0-9]/g, '')"
					name="ItemPrice" required="required"></td>
			</tr>
			<tr>
				<td>Item Quantity:</td>
				<td><input type="text" name="ItemQty" required="required"></td>
			</tr>
			<tr>
				<td>Customer Name:</td>
				<td><input type="text" name="CustomerName" required="required"></td>
			</tr>
			<tr>
				<td>Customer StreetName:</td>
				<td><input type="text" name="StreetName" required="required"></td>
			</tr>
			<tr>
				<td>Customer AreaName:</td>
				<td><input type="text" name="Areaname" required="required"></td>
			</tr>
			<tr>
				<td>Customer CityName:</td>
				<td><input type="text" name="CityName" required="required"></td>
			</tr>
			<tr>
				<td>Customer StateName:</td>
				<td><input type="text" name="StateName" required="required"></td>
			</tr>
			<tr>
				<td>Customer CountryName:</td>
				<td><input type="text" name="CountryName" required="required"></td>
			</tr>
			<tr>
				<td>Customer Pincode:</td>
				<td><input type="text" name="Pincode" maxlength="6"
					required="required"
					oninput="this.value=this.value.replace(/[^0-9.]/g, '');"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save Order Details"> <input type="reset"
					value="Clear"></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%
}
%>