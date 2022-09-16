
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" href="../Style.css">
<link rel="icon" type="image/x-icon" href="../Resources/vlogo.ico">
<title>Reporting Employees</title>
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
		ArrayList<String> mobilenumberList = (ArrayList<String>) session.getAttribute("mobile_nos");
		%>


	</table>
	<table border=2 style="width: 100%;">
		<tr
			style="background-color: #ff8040; height: 50px; text-align: center; color: black">

			<td>EmployeeId</td>

			<td>First Name</td>

			<td>Last Name</td>

			<td>Email</td>

			<td>Mobile Number</td>

			<td>Designation</td>




		</tr>
		<%
		if (firstnameList != null) {
			for (int i = 0; i < firstnameList.size(); i++) {
		%>
		<tr style="text-align: center">
			<td><%=empidList.get(i)%></td>
			<td><%=firstnameList.get(i)%></td>
			<td><%=lastnameList.get(i)%></td>
			<td><%=emailList.get(i)%></td>
			<td><%=mobilenumberList.get(i)%></td>
			<td><%=designationList.get(i)%></td>
		</tr>
		<%
		}
		}
		%>

	</table>
	<a href="Welcome.jsp">Welcome page</a>
</body>
</html>