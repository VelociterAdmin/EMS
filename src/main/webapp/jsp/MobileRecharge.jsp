<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mobile Recharge</title>
</head>
<body>
	<div style="width: 33.33%">
		<img src="../Resources/velociterlogo.png" />
	</div>
	<form action="MobileRechargeServlet" method="Post">

		<h1 align="center">Mobile Recharge</h1>
		<table align="center">
			<tr>
				<td>Mobile No.</td>
				<td><input type="tel"
					oninput="this.value=this.value.replace(/[^0-9]/g,'')"
					name="mobileNum" minlength="10" maxlength="10"
					pattern="[6789][0-9]{9}" title="Please enter valid phone number"
					required></td>
			</tr>
			<tr>
				<td>Operator Name</td>
				<td><select name="operatorName">
						<option value="Airtel">Airtel</option>
						<option value="Idea">Idea</option>
						<option value="BSNL">BSNL</option>
						<option value="Vi">Vi</option>
						<option value="Jio">Jio</option>
				</select></td>
			</tr>
			<tr>
				<td>Plan Name</td>
				<td><select name="planName">
						<option value="Unlimited">Unlimited</option>
						<option value="TalkTime">TalkTime</option>
						<option value="Data">Data</option>
						<option value="DataAddOn">Data Add On</option>

				</select></td>
			</tr>
			<tr>
				<td>Offer</td>
				<td><select name="offer">
						<option value="No Offer">No Offer</option>
				</select></td>
			</tr>
			<tr>
				<td>Balance</td>
				<td><input type="text" name="balance"
					oninput="this.value=this.value.replace(/[^0-9.]/g,'')"
					 pattern="[0-9]{1-5}" required></td>
			</tr>
			<tr>
				<td>Validity</td>
				<td><select name="validity">
						<option value="7days">7 days</option>
						<option value="15days">15 days</option>
						<option value="20days">20 days</option>
						<option value="24days">24 days</option>
						<option value="28days">28 days</option>
						<option value="56days">56 days</option>
						<option value="84days">84 days</option>
						<option value="90days">90 days</option>
						<option value="180days">180 days</option>
						<option value="365days">365 days</option>

				</select></td>
			</tr>
			<tr>
				<td>Data</td>
				<td><select name="data">
						<option value="1GBPerday">1GB Per/day</option>
						<option value="2GBPerday">2GB Per/day</option>
						<option value="3GB erday">3GB Per/day</option>
						<option value="1GB">1GB</option>
						<option value="2GB">2GB</option>
						<option value="3GB">3GB</option>
						<option value="5GB">5GB</option>


				</select></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit"
					value="Submit"> <input type="reset" value="Cancel"></td>

			</tr>

		</table>

	</form>

</body>
</html>