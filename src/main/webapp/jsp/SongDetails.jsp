<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("empId") == null) {
	response.sendRedirect("Login.jsp");
} else {
	String first = (String) session.getAttribute("firstname");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../Style.css">
<title>Song Details Database</title>
</head>
<body>
	<img src="../Resources/velociterlogo.png" />
	<form action="SongDetailsServlet" method="post">
		<table style="text-align: left;" align="center">
			<tr>
				<th>Song Name</th>
				<td><input type="text" name="songName" required="required"></td>
			</tr>
			<tr>
				<th>Song Type</th>
				<td><select name="songType" required="required">
						<option value="Pop">Pop</option>
						<option value="Rock">Rock</option>
						<option value="Disco">Disco</option>
						<option value="Classic">Classic</option>
				</select></td>
			</tr>
			<tr>
				<th>Song Duration</th>
				<td><input type="text" name="songDur" required="required"></td>
			</tr>
			<tr>
				<th>Singer Name 1</th>
				<td><input type="text" name="singerName1" required="required"></td>
			</tr>
			<tr>
				<th>Singer Name 1</th>
				<td><input type="text" name="singerName2" required="required"></td>
			</tr>
			<tr>
				<th>Writer Name</th>
				<td><input type="text" name="writerName" required="required"></td>
			</tr>
			<tr>
				<th colspan="2" align="center"><input type="submit"
					value="Save Song Details"> <input type="reset"
					value="Clear"></th>

			</tr>
		</table>
	</form>
</body>
</html>

<%
}
%>