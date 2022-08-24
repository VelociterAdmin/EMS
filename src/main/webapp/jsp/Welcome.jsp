<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
PrintWriter print = response.getWriter();
String eduid = (String) session.getAttribute("empEduId");

if (session.getAttribute("empId") == null) {
	response.sendRedirect("Login.jsp");
} else {
	String first = (String) session.getAttribute("firstname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" href="../Style.css">
<link rel="icon" type="image/x-icon" href="../Resources/vlogo.ico">
<title>Welcome <%=first%></title>

</head>
<body>
	<br>
	<div style="width: 33.33%">
		<img src="../Resources/velociterlogo.png" />
	</div>
	<div class="welcomeLabel" align="center">
		Welcome

		<%=session.getAttribute("firstname")%>
	</div>
	<div align="right" style="margin-top: -35px">
		<form action="LogoutServlet" method="post">
			<input type="submit" value="Logout">
		</form>
	</div>
	<br />
	<div class="tabContainer">
		<div class="buttonContainer">
			<button onclick="showPanel(0,'gray')">Personal Information</button>
			<button onclick="showPanel(1,'gray')">Address</button>
			<button onclick="showPanel(2,'gray')">Education
				Qualification</button>
		</div>
		<div class="tabPanel">
			<table>
				<tr>
					<td>FirstName :</td>
					<td><input type="text"
						value="<%=session.getAttribute("firstname")%>" disabled></td>
				</tr>
				<tr>
					<td>LastName :</td>
					<td><input type="text"
						value="<%=session.getAttribute("lastname")%>" disabled></td>
				</tr>
				<tr>
					<td>Designation :</td>
					<td><input type="text"
						value="<%=session.getAttribute("designation")%>" disabled></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="email"
						value="<%=session.getAttribute("email")%>" disabled></td>
				</tr>
				<tr>
					<td>Employee Id :</td>
					<td><input type="text"
						value="<%=session.getAttribute("empId")%>" disabled></td>
				</tr>
			</table>
		</div>
		<div class="tabPanel">
			<table id="Addresstab">
				<tr>
					<td>HouseNo :</td>
					<td><input type="text"
						value="<%=session.getAttribute("houseno")%>" disabled></td>
				</tr>
				<tr>
					<td>Street Name :</td>
					<td><input type="text"
						value="<%=session.getAttribute("streetname")%>" disabled></td>
				</tr>
				<tr>
					<td>Locality :</td>
					<td><input type="text"
						value="<%=session.getAttribute("locality")%>" disabled></td>
				</tr>
				<tr>
					<td>City :</td>
					<td><input type="text"
						value="<%=session.getAttribute("city")%>" disabled></td>
				</tr>
				<tr>
					<td>State :</td>
					<td><input type="text"
						value="<%=session.getAttribute("state")%>" disabled></td>
				</tr>
				<tr>
					<td>Pincode :</td>
					<td><input type="text"
						value="<%=session.getAttribute("pincode")%>" disabled></td>
				</tr>
				<tr>
					<td>Country :</td>
					<td><input type="text"
						value="<%=session.getAttribute("country")%>" disabled></td>
				</tr>
			</table>
		</div>
		<div class="tabPanel">
			<button onClick="AddField()">Add Field</button>
			<form action="EducationServlet" method="post">


				<table width="60%" id="EducationTable">
					<tr padding="5px">
						<td>Field Name</td>
						<td>Name of School</td>
						<td>Name of Board/University</td>
						<td>Grades</td>
					</tr>

					<%
					ArrayList<String> fieldList = (ArrayList<String>) session.getAttribute("fields");
					ArrayList<String> SchoolList = (ArrayList<String>) session.getAttribute("school");
					ArrayList<String> boardList = (ArrayList<String>) session.getAttribute("university");
					ArrayList<String> gradeList = (ArrayList<String>) session.getAttribute("grade");
					if (fieldList != null) {
					%>

					<%
					for (int i = 0; i < fieldList.size(); i++) {
					%>
					<tr>
						<td><%=fieldList.get(i)%></td>
						<td><%=SchoolList.get(i)%></td>
						<td><%=boardList.get(i)%></td>
						<td><%=gradeList.get(i)%></td>
					</tr>
					<%
					}
					%>

					<%
					}
					%>
				</table>
			</form>
		</div>
	</div>
	<a href="../ReportingEmpServlet">Reporting Employees</a>
	<script type="text/javascript" src="../Panel.js"></script>
</body>
</html>
<%
}
%>
