<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
PrintWriter print = response.getWriter();
String eduid = (String) session.getAttribute("empEduId");
ArrayList<String> fieldList = (ArrayList<String>) session.getAttribute("fields");
ArrayList<String> SchoolList = (ArrayList<String>) session.getAttribute("school");
ArrayList<String> boardList = (ArrayList<String>) session.getAttribute("university");
ArrayList<String> gradeList = (ArrayList<String>) session.getAttribute("grade");
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
			<form action="UpdateServlet" id="divinfo" method="Post">
				<table>
					<tr>

						<td>FirstName :</td>
						<td><input type="text" name="empfname" id="firstname"
							value="<%=session.getAttribute("firstname")%>" disabled></td>
						<td id="fnamecol"><button id="fneditbtn"
								onclick="Editfirstname()">Edit</button></td>

					</tr>

					<tr>

						<td>LastName :</td>
						<td><input type="text" name="emplname" id="lastname"
							value="<%=session.getAttribute("lastname")%>" disabled></td>
						<td id="lnamecol"><button id="lneditbtn"
								onclick="Editlastname()">Edit</button></td>

					</tr>
					<tr>

						<td>Designation :</td>
						<td><input type="text" name="empdesign" id="designation"
							value="<%=session.getAttribute("designation")%>" disabled></td>
						<td id="desigcol"><button id="designbtn"
								onclick="Editdesignation()">Edit</button></td>

					</tr>
					<tr>

						<td>Email :</td>
						<td><input type="email" name="empemail" id="email"
							value="<%=session.getAttribute("email")%>" disabled></td>
						<td id="emailcol"><button id="emailbtn" onclick="Editemail()">Edit</button></td>

					</tr>
					<tr>

						<td>Employee Id :</td>
						<td><input type="text" id="empId"
							value="<%=session.getAttribute("empId")%>" disabled></td>

					</tr>
				</table>
			</form>
		</div>
		<div class="tabPanel">
			<form action="UpdateAddServlet" id="divAdd" method="Post">
				<table id="Addresstab">

					<tr>

						<td>HouseNo :</td>
						<td><input type="text" name="emphouseno" id="houseno"
							value="<%=session.getAttribute("houseno")%>" disabled></td>
						<td id="housecol"><button id="housebtn"
								onclick="EditHouseno()">Edit</button></td>

					</tr>
					<tr>

						<td>Street Name :</td>
						<td><input type="text" name="empstreetname" id="streetname"
							value="<%=session.getAttribute("streetname")%>" disabled></td>
						<td id="streetcol"><button id="streetbtn"
								onclick="EditStreetname()">Edit</button></td>

					</tr>
					<tr>

						<td>Locality :</td>
						<td><input type="text" name="emplocality" id="locality"
							value="<%=session.getAttribute("locality")%>" disabled></td>
						<td id="localcol"><button id="localitybtn"
								onclick="EditLocality()">Edit</button></td>

					</tr>
					<tr>

						<td>City :</td>
						<td><input type="text" name="empcity" id="city"
							value="<%=session.getAttribute("city")%>" disabled></td>
						<td id="citycol"><button id="citybtn" onclick="EditCity()">Edit</button></td>

					</tr>
					<tr>
						<td>State :</td>
						<td><input type="text" name="empstate" id="state"
							value="<%=session.getAttribute("state")%>" disabled></td>
						<td id="statecol"><button id="statebtn" onclick="EditState()">Edit</button></td>
					</tr>
					<tr>
						<td>Pin-Code :</td>
						<td><input type="text" name="emppincode" id="pincode"
							value="<%=session.getAttribute("pincode")%>" disabled></td>
						<td id="pincodecol"><button id="pincodebtn"
								onclick="EditPincode()">Edit</button></td>
					</tr>
					<tr>
						<td>Country :</td>
						<td><input type="text" name="empcountry" id="country"
							value="<%=session.getAttribute("country")%>" disabled></td>
						<td id="countrycol"><button id="countrybtn"
								onclick="EditCountry()">Edit</button></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="tabPanel" id="divEdu">
			<%
			if (fieldList == null) {
			%>
			<button onClick="AddField()" id="addbtn">Add Field</button>
			<%
			}
			%>
			<form method="post" action="EducationServlet" id="formEdu">
				<table width="60%" id="EducationTable">
					<tr padding="5px">
						<td>Field Name</td>
						<td>Name of School</td>
						<td>Name of Board/University</td>
						<td>Grades</td>

					</tr>

					<%
					if (fieldList != null) {
					%>

					<%
					for (int i = 0; i < fieldList.size(); i++) {
					%>
					<tr>
						<td><input type="text" name="field<%=i%>" id="fieldId<%=i%>"
							value="<%=fieldList.get(i)%>" disabled></td>
						<td><input type="text" name="school<%=i%>"
							id="schoolId<%=i%>" value="<%=SchoolList.get(i)%>" disabled></td>
						<td><input type="text" name="board<%=i%>" id="boardId<%=i%>"
							value="<%=boardList.get(i)%>" disabled></td>
						<td><input type="text" name="grade<%=i%>" id="gradeId<%=i%>"
							value="<%=gradeList.get(i)%>" disabled></td>
						<td><button onclick="editEdu<%=i%>()" id="edit<%=i%>">Edit</button></td>
					</tr>
					<%
					}
					%>

					<%
					}
					%>

					<tr id="insertEdu">

					</tr>
				</table>
			</form>
			<%
			if (fieldList != null) {
			%>
			<button style="margin-left: 900px;" id="addbtn" onclick="AddField()">Add
				Field</button>

			<%
			}
			%>
		</div>
	</div>
	<script>
	var addbtn=document.getElementById("addbtn");
	<%if (fieldList != null) {%>
	var x = <%=fieldList.size()%>;
	if(x==4){
	addbtn.remove();
	}<%} else {%>
	var x=0;
	
	<%}%>
	</script>
	</script>
	<%
	if (session.getAttribute("reportingto") == null) {
	%>
	<a href="../ReportingEmpServlet">Reporting Employees</a>
	<%
	}
	%>
	<script type="text/javascript" src="../Panel.js"></script>
	<table style="width: 100%; text-align: center;">
		<tr>
			<td><a href="OnlineShopping.jsp">Online Shopping</a></td>
			<td><a href="SocialMedia.jsp">Social Media</a></td>
			<td><a href="OnlineMarriageRegistration.jsp">Online Marriage
					Registration</a></td>
			<td><a href="OnlineFlightBooking.jsp">Online Flight Booking</a></td>
			<td><a href="CustomerRegistration.jsp">Customer Registration</a></td>
		<tr>
			<td><a href="SongDetails.jsp">Song PlayList</a></td>
			<td><a href="AnimalDetails.jsp">Animal Details</a></td>
			<td><a href="Order.jsp">Order Online</a></td>
			<td><a href="Dish.jsp">Food Factory</a></td>
			<td><a href="TrainingCenter.jsp">Training Center</a></td>
		</tr>
		<tr>
			<td><a href="MobileRecharge.jsp">MobileRecharge</a></td>
			<td><a href="Dress.jsp">Dress Order</a></td>
			<td><a href="Electronic.jsp">Electronic Product</a></td>
			<td><a href="MovieTicket.jsp">Movie Ticket</a></td>
			<td><a href="Student.jsp">Student </a></td>
		</tr>
	</table>
</body>
</html>
<%
}
%>
