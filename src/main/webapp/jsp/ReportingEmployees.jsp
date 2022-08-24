<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" href="../Style.css">
<link rel="icon" type="image/x-icon" href="../Resources/vlogo.ico">
<title>Reporting Employees </title>
</head>
<body>
	<br>
	<img src="../Resources/velociterlogo.png" />
	<table>
		<%
		ArrayList<String> firstnameList = (ArrayList<String>) session.getAttribute("firstnames");
	    ArrayList<String> lastnameList = (ArrayList<String>) session.getAttribute("lastnames");
	    ArrayList<String> designationList = (ArrayList<String>) session.getAttribute("designations");
	    ArrayList<String> emailList = (ArrayList<String>) session.getAttribute("emails");
	    ArrayList<String> empidList = (ArrayList<String>) session.getAttribute("empids");
	    
	%>
		

	</table>
	<table border=2>
		<tr>
			<td>First Name</td>

			<td>Last Name</td>

			<td>designation</td>

			<td>Email</td>

			<td>EmployeeId</td>

		</tr>
		<%
		if(firstnameList!=null){
					for (int i = 0; i < firstnameList.size(); i++) {
					%>
		<tr>
			<td><%=firstnameList.get(i)%></td>
			<td><%=lastnameList.get(i)%></td>
			<td><%=designationList.get(i)%></td>
			<td><%=emailList.get(i)%></td>
			<td><%=empidList.get(i)%></td>
		</tr>
		<%
					}
		}
	%>
		
	</table>
</body>
</html>