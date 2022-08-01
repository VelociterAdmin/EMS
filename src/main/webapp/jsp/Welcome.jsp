<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style>
body{ 
background-color:Skyblue; 
    color: blue;
     
  }  
h1{
 font-size:100px;
}
</style>

</head>

<body>

	<h1 align="center">WELCOME<h1 align="center">
<%=
request.getAttribute("firstname")
%>
</h1>
</body>
</html>
