<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Electronic Product</title>
</head>
<body>
	<div style="width: 33.33%">
		<img src="../Resources/velociterlogo.png" />
	</div>
	<form action="ElectronicServlet" method="post">
		<h1 align="center">Electronic Product</h1>
		<table align="center">
			<tr>
				<td>Product Name</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="productName" required></td>
			</tr>
			<tr>
				<td>Brand</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="brand" required></td>
			</tr>
			<tr>
				<td>Colour</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="colour" required></td>
			</tr>
			<tr>
				<td>Warranty</td>
				<td><select name="warranty">
				<option value="6Months">6 Months</option>
				<option value="1Year">1 Year</option>
				<option value="2Years">2 Years</option>
				<option value="3Years">3 Years</option>
				<option value="5Years">5 Years</option>
				<option value="10Years">10 Years</option>
				</select></td>
			</tr>
			<tr>
				<td>SpecialFeature</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z0-9%, ]/g,'')" name="specialFeature" required></td>
			</tr>
			<tr>
				<td>Weight in Kg</td>
				<td><input type="text" oninput="this.value=this.value.replace(/[^0-9.]/g,'')" name="productWeight" required></td>
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