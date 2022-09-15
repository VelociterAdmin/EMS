<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../Style.css">
<title>Training Center</title>
</head>
<body>
	<img src="../Resources/velociterlogo.png" />
	<form action="TrainingServlet" method="post">

		<table align="center">
			<tr>
				<td>Student RollNo.</td>
				<td><input type="text" name="studentRollNo" required="required"></td>
			</tr>
			<tr>
				<td>Student Name</td>
				<td><input type="text" name="studentName" required="required"></td>
			</tr>
			<tr>
				<td>Course Name</td>
				<td><input type="text" name="courseName" required="required"></td>
			</tr>
			<tr>
				<td>Course Duration</td>
				<td><select name="courseDuration" required="required">
						<%
						for (int month = 1; month < 13; month++) {
						%>
						<option value="<%=month%> Month"><%=month%> Month
						</option>
						<%
						}
						%>
				</select></td>
			</tr>
			<tr>
				<td>Course Fees</td>
				<td><input type="text" name="courseFees" required="required"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"
					value="Save Course Details"> <input type="reset"
					value="Cancel"></td>
			</tr>
		</table>
	</form>
</body>
</html>