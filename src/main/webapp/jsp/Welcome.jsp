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
	<div class="welcomeLabel" align="center">
	Welcome <%=request.getAttribute("firstname")%>
	</div>
	<div align="right" style="margin-top:-35px">
		<form>
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
						value="<%=request.getAttribute("firstname")%>" disabled></td>
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
					<td><%=request.getAttribute("houseno")%></td>
				</tr>
				<tr>
					<td>Street Name :</td>
					<td><%=request.getAttribute("streetname")%></td>
				</tr>
				<tr>
					<td>Locality :</td>
					<td><%=request.getAttribute("locality")%></td>
				</tr>
				<tr>
					<td>City :</td>
					<td><%=request.getAttribute("city")%></td>
				</tr>
				<tr>
					<td>State :</td>
					<td><%=request.getAttribute("state")%></td>
				</tr>
				<tr>
					<td>Pincode :</td>
					<td><%=request.getAttribute("pincode")%></td>
				</tr>
				<tr>
					<td>Country :</td>
					<td><%=request.getAttribute("country")%></td>
				</tr>
			</table>
		</div>
		<div class="tabPanel">
			Education Section in progress
			<form action="#" method="post">
				<table>
					<tr>
						<td>Secondry :</td>
						<td><input type="text" name="secondryEdu" required></td>
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
			</form>
		</div>
	</div>

	<br>
	<br>
	<a href="http://localhost:8081/EMS">Home.</a>
	<script type="text/javascript" src="../Panel.js"></script>
</body>
</html>
