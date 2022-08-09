<%@page import="java.io.PrintWriter"%>
<%@page import="com.velociter.ems.pojo.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% String empid =(String) request.getAttribute("empid");  %>
	
	<% request.setAttribute("empid2", empid); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="Stylesheet" href="../Style.css">
<title>Welcome <%=request.getAttribute("firstname")%></title>

</head>
<body>
	<br>
	<div style="width:33.33%"><img src="../Resources/velociterlogo.png" /></div>
	<div style="width:33.33%;margin-left:500px;margin-top:-40px" class="welcomeLabel" align="center">
		Welcome
		<%=request.getAttribute("firstname")%>
	</div>
	<div style="margin-left:1450px;margin-top:-20px" >
		<form action="LogoutServlet" method="post">
			<input type="submit" value="Logout">
		</form>
	</div>
	<br />
	<div class="tabContainer">
		<div class="buttonContainer">
			<button onclick="showPanel(0,'gray')">Personal Information</button>
			<button onclick="showPanel(1,'gray')">Address</button>
			<button onclick="showPanel(2,'gray')">EducationQualification</button>
		</div>
		<div class="tabPanel">
			<table>
				<tr>
					<td>FirstName :</td>
					<td><input type="text"
						value="<%=request.getAttribute("firstname")%>" size="40px" disabled></td>
				</tr>
				<tr>
					<td>LastName :</td>
					<td><input type="text"
						value="<%=request.getAttribute("lastname")%>" disabled></td>
				</tr>
				<tr>
					<td>Designation :</td>
					<td><input type="text"
						value="<%=request.getAttribute("designation")%>" disabled></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="email"
						value="<%=request.getAttribute("email")%>" disabled></td>
				</tr>
				<tr>
					<td>EmployeeId :</td>
					<td><input type="text"
						value="<%=request.getAttribute("empid")%>" disabled></td>
				</tr>

			</table>
		</div>
		<div class="tabPanel">
			<table id="Addresstab">
				<tr>
					<td>HouseNo :</td>
					<td><input type="text"
						value="<%=request.getAttribute("houseno")%>" size="40px" disabled></td>
				</tr>
				<tr>
					<td>Street Name :</td>
					<td><input type="text"
						value="<%=request.getAttribute("streetname")%>" disabled></td>
				</tr>
				<tr>
					<td>Locality :</td>
					<td><input type="text"
						value="<%=request.getAttribute("locality")%>" disabled></td>
				</tr>
				<tr>
					<td>City :</td>
					<td><input type="text"
						value="<%=request.getAttribute("city")%>" disabled></td>
				</tr>
				<tr>
					<td>State :</td>
					<td><input type="text"
						value="<%=request.getAttribute("state")%>" disabled></td>
				</tr>
				<tr>
					<td>Pincode :</td>
					<td><input type="text"
						value="<%=request.getAttribute("pincode")%>" disabled></td>
				</tr>
				<tr>
					<td>Country :</td>
					<td><input type="text"
						value="<%=request.getAttribute("country")%>" disabled></td>
				</tr>
			</table>
		</div>
		<div class="tabPanel">
			Education Section in progress
			<form action="EducationServlet" method="post">
				<table>
					<tr>
						<td>Secondry :</td>
						<td><input type="text" name="secondryEdu" size="40px" required></td>
					</tr>
					<tr>
						<td>Higher Secondry :</td>
						<td><input type="text" name="highSecEdu" required></td>
					</tr>
					<tr>
						<td>Graduation :</td>
						<td><input type="text" name="graduation" required></td>
					</tr>
					<tr>
						<td>Post Graduation :</td>
						<td><input type="text" name="postGraduation" required></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save"></td>
					</tr>
				</table>
				<%
				request.setAttribute("empid", request.getAttribute("empid"));
				%>
			</form>
		</div>
	</div>

	<br>
	<br>
	<a href="http://localhost:8081/EMS">Home.</a>
	<script type="text/javascript" src="../Panel.js"></script>
</body>
</html>

