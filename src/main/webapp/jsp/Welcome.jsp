<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" href="../Style.css">
<title>Welcome</title>
<style>
body{ 
   
    margin: 20px;  
    padding: 20px;
    color : white;
    background-image: url('../Resources/Background.png');
    background-repeat:no-repeat;
    background-attachment:fixed;  
    background-size: cover;  
    font-family: 'Arial';  

  }  
h1{
 font-size:100px;
}
</style>

</head>

<body>

	<h1> WELCOME</h1>
<h1>
<%=
request.getAttribute("firstname")
%>
</h1><br><br>
<a href="http://localhost:8081/EMS">home</a>
</body>
</html>
