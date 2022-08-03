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

	<label class="welcomeLabel"> WELCOME</label>
	<br />
	<label class="Firstname"> <%=request.getAttribute("firstname")%>
	</label>
	<br />
	<a href="http://localhost:8081/EMS">Home.</a>
</body>
</html>
