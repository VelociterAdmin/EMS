<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"href="../Style.css">
</head>
<body>

	<form  action="LoginServlet" method="Post">
		<table class="LoginTable">
		


			<tr>
				<td>Username</td>
				<td><input type="text" name="Username" required></td>
				
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="Password" required></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit" value="Login">
					<input type="reset" value="Cancel"><br> <br> <a
					href="Registration.jsp">Register now</a></td>
			</tr>

		</table>
		
	</form>

</body>
</html>
