<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="../Resources/vlogo.ico">
<title>Online Shopping</title>
<link rel="stylesheet" href="../Style.css">
</head>
<body>
	<img src="../Resources/velociterlogo.png" />
	<form action="OnlineShoppingServlet" method="post">
		<h1 align="center">Online Shopping</h1>
		<table align="center">
			<tr>
				<td>Product Type :</td>
				<td><input type="text"
					oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="productType"
					required></td>
			</tr>
			<tr>
				<td>Product Name :</td>
				<td><input type="text" name="productName" required></td>
			</tr>
			<tr>
				<td>Product Brand :</td>
				<td><input type="text" name="productBrand" required></td>
			</tr>
			<tr>
				<td>Product Colour :</td>
				<td><input type="text"
					oninput="value=value.replace(/[^a-zA-Z ]/g,'')"
					name="productColour" required></td>
			</tr>
			<tr>
				<td>Weight In Kg :</td>
				<td><input type="text"
					oninput="this.value=this.value.replace(/[^0-9 .]/g,'')"
					name="productWeight" required></td>
			</tr>
			<tr>
				<td>Product Price :</td>
				<td><input type="text"
					oninput="this.value=this.value.replace(/[^0-9.]/g,'').replace(/(\..*)\./g,'$1')"
					name="productPrice" required></td>
			</tr>
			<tr>
				<td>Product Warranty :</td>
				<td><input type="text"
					oninput="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'')"
					name="productWarranty" required></td>
			</tr>
			<!-- 	<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Mobile Number :</td>
				<td><input type="text" name="mobileNo"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="mobileNo"></td>
			</tr>
			<tr>
				<td>House No :</td>
				<td><input type="text" name="houseNo"></td>
			</tr>
			<tr>
				<td>Street Name :</td>
				<td><input type="text" name="streetName"></td>
			</tr>
			<tr>
				<td>Area Name :</td>
				<td><input type="text" name="areaName"></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><input type="text" name="country"></td>
			</tr>
			<tr>
				<td>PinCode :</td>
				<td><input type="text" name="pinCode"></td>
			</tr>  -->
			<td colspan=2 align=center><input type="submit"
				name="submitButton" value="Submit"> <input type="reset"
				value="clear"></td>
		</table>
	</form>

</body>
</html>