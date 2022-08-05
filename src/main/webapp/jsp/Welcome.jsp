<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" href="../Style.css">
<title>Welcome <%=request.getAttribute("firstname")%></title>
</head>
<body>

	<label class="welcomeLabel">Welcome</label>

	<label class="Firstname"> <%=request.getAttribute("firstname")%>
	</label>
	<br />
	<table>
		<tr>
			<td>FirstName</td>
			<td><%=request.getAttribute("firstname")%></td>
			</tr>
		<tr>
			<td>LastName</td>
			<td><%=request.getAttribute("lastname")%></td>
			</tr>
		<tr>
			<td>Designation</td>
			<td><%=request.getAttribute("designation")%></td>
			</tr>
		<tr>
			<td>EmailAddress</td>
			<td><%=request.getAttribute("email")%></td>
			</tr>
		<tr>
			<td>EmployeeId</td>
			<td><%=request.getAttribute("empid")%></td>
			</tr>
			</table>
			<br><br>
			<a href="http://localhost:8081/EMS">Home.</a>
</body>
</html>