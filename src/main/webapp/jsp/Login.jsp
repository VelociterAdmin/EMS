<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<% 
	response.setHeader("Cache-Control", "no-cache");
	String empId = (String) session.getAttribute("empid");
	if(empId == null){
		
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="../Style.css">
</head>
<body>
<br><img src="../Resources/velociterlogo.png"  />
	<form action="LoginServlet" method="Post">
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
<% 
	}
	else{
		response.sendRedirect("Welcome.jsp");
	}
%>