<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
body  
{  
    margin: 20px;  
    padding: 20px;  
    background-color:Skyblue;  
    font-family: 'Arial';  
}  

</style>

</head>
<body>

	<form  action="LoginServlet" method="Post">
		<table align="center">


			<tr>
				<td>Username</td>
				<td><input type="text" name="Username"></td>
				<br>
				<br>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="Password"></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit" value="login">
					<input type="reset" value="Cancel"><br> <br> <a
					href="Registration.jsp">Register now</a></td>
			</tr>

		</table>
	</form>

</body>
</html>
