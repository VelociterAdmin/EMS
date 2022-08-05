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
	<div class="tabContainer">
		<div class="buttonContainer">
			<button onclick="showPanel(0,'gray')">Personal Information</button>
			<button onclick="showPanel(1,'4caf50')">Address</button>
			<button onclick="showPanel(2,'ff5736')">EducationQualification</button>
		</div>
		<div class="tabPanel">
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
		</div>
		<div class="tabPanel">
			<table id="Addresstab">
				<tr>
					<td>HouseNo.</td>
					<td><%=request.getAttribute("houseno")%></td>
				</tr>
				<tr>
					<td>Street Name</td>
					<td><%=request.getAttribute("streetname")%></td>
				</tr>
				<tr>
					<td>Locality</td>
					<td><%=request.getAttribute("locality")%></td>
				</tr>
				<tr>
					<td>City</td>
					<td><%=request.getAttribute("city")%></td>
				</tr>
				<tr>
					<td>State</td>
					<td><%=request.getAttribute("state")%></td>
				</tr>
				<tr>
					<td>Pincode</td>
					<td><%=request.getAttribute("pincode")%></td>
				</tr>
				<tr>
					<td>Country</td>
					<td><%=request.getAttribute("country")%></td>
				</tr>
			</table>
		</div>
		<div class="tabPanel">
		Education Section in progress
		
		</div>
	</div>

	<br>
	<br>
	<a href="http://localhost:8081/EMS">Home.</a>
</body>
</html>
<script>
	var tabButtons = document
			.querySelectorAll(".tabContainer .buttonContainer button");
	var tabPanels = document.querySelectorAll(".tabContainer  .tabPanel");

	function showPanel(panelIndex, colorCode) {
		tabButtons.forEach(function(node) {
			node.style.backgroundColor = "";
			node.style.color = "";
		});
		tabButtons[panelIndex].style.backgroundColor = colorCode;
		tabButtons[panelIndex].style.color = "white";
		tabPanels.forEach(function(node) {
			node.style.display = "none";
		});
		tabPanels[panelIndex].style.display = "block";
		tabPanels[panelIndex].style.backgroundColor = colorCode;
	}
	//showPanel(0, 'gray');
</script>