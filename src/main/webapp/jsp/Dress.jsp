<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dress Order</title>
</head>
<body>
	<div style="width: 33.33%">
		<img src="../Resources/velociterlogo.png" />
	</div>
	<form action="DressServlet" method="Post">
		<h2 align="center">Dress Order</h2>
		<table align="center">
			<tr>
				<td>Category</td>
				<td><select name="category">
				<option value="Mens">Mens</option>
				<option value="Womens">Womens</option>
				<option value="Childrens">Childrens</option>
			
				</select></td>
			</tr>
			<tr>
				<td>Dress Type</td>
				<td><select name="dressType">
				<option value="Traditional">Traditional</option>
				<option value="Western">Western</option>
				<option value="Formal">Formal</option>
				<option value="Casual">Casual</option>
				</select></td>
			</tr>
			<tr>
				<td>Dress Name</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z -]/g,'')" name="dressName" required></td>
			</tr>
			<tr>
				<td>Dress Brand</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="dressBrand" required></td>
			</tr>
			<tr>
				<td>Dress Quality</td>
				<td><select name="dressQuality">
				<option value="cotton">Cotton</option>
				<option value="linen">Linen</option>
				<option value="silk">Silk</option>
				<option value="rayon">Rayon</option>
				<option value="nylon">Nylon</option>
				<option value="polyester">Polyester</option>
				<option value="rubber">Rubber</option>
				<option value="woolen">Woolen</option>
				</select></td>
			</tr>
			<tr>
				<td>Dress Size</td>
				<td><select name="dressSize">
				<option value="S">S</option>
				<option value="L">L</option>
				<option value="M">M</option>
				<option value="XL">XL</option>
				<option value="XXL">XXL</option>
				</select></td>
			</tr>
			<tr>
				<td>Dress Color</td>
				<td><input type="text" oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="dressColour" required></td>
			</tr>
			<tr>
				<td>Dress Price</td>
				<td><input type="text" oninput="this.value=this.value.replace(/[^0-9.]/g,'')" name="dressPrice" required></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit"
					value="Submit"> <input type="reset" value="Cancel"></td>

			</tr>

		</table>

	</form>

</body>
</html>