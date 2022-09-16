<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="../Resources/vlogo.ico">
<title>Social Media</title>
<link rel="stylesheet" href="../Style.css">
</head>
<body>
	<img src="../Resources/velociterlogo.png" />
	<form action="SocialMediaServlet" method="post">
		<h1 align="center">SocialMedia</h1>
		<table align="center">

			<!--		<tr>
				<td>Post Type :</td>
				<td><input type="text" name="postType"></td>
			</tr>
			<tr>
				<td>Like Count :</td>
				<td><input type="text" name="likeCount"></td>
			</tr>
			<tr>
				<td>Dislike Count :</td>
				<td><input type="text" name="dislikeCount"></td>
			</tr>
			<tr>
				<td>Comment Count :</td>
				<td><input type="number" name="commentCount"></td>
			</tr>
			     -->

			<tr>
				<td>First Name :</td>
				<td><input type="text"
					oninput="value=value.replace(/[^a-zA-Z ]/g,'')" name="firstName"
					required></td>
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
				<td>Email :</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="date" name="date" required></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" minlength="8"
					required></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><input type="password" name="confirmPassword" minlength="8"
					required></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type="submit"
					name="submitButton" value="Register"> <input type="reset"
					value="clear"></td>
		</table>
	</form>
</body>
</html>