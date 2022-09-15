<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../Style.css">
<title>Dish Details</title>
</head>
<body>
	<img src="../Resources/velociterlogo.png" />
	<form action="DishServlet" method="post">
		<table align="center">
			<tr>
				<td>Dish Name:</td>
				<td><input type="text" name="dishName" required="required"></td>
			</tr>
			<tr>
				<td>Dish Type:</td>
				<td><input type="text" name="dishType" required="required"></td>
			</tr>
			<tr>
				<td>Dish Price:</td>
				<td><input type="text" name="dishPrice"
					oninput="this.value =this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
					required="required"></td>
			</tr>
			<tr>
				<td>Dish GST:</td>
				<td><input type="text"
					oninput="this.value =this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
					name="GST" required="required"></td>
			</tr>
			<tr>
				<td>Dish Discount:</td>
				<td><input type="text"
					oninput="this.value =this.value.replace(/[^0-9.]/g, '');"
					name="dishDiscount" required="required"></td>
			</tr>
			<tr>
				<td>Dish Total:</td>
				<td><input type="text" name="dishTotal"
					oninput="this.value =this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
					required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save Dish Details"> <input type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>