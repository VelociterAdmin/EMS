package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.Employee;

/**
 * Servlet implementation class RegistrationServlet
 */
//@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) // dopost is used to give and take
			throws ServletException, IOException { // request and response

		response.setContentType("text/html"); // set the content of the page as text and html
		PrintWriter writter = response.getWriter();

		Employee employee = new Employee();
		employee.setFirstName(request.getParameter("employeeName"));
		employee.setLastName(request.getParameter("employeeLastName"));
		employee.setEmployeeId(request.getParameter("employeeId"));
		employee.setEmployeeEmailId(request.getParameter("employeeEmailId"));
		employee.setMobileNumber(request.getParameter("mobileNumber"));
		employee.setEmployeeFatherName(request.getParameter("employeeFatherName"));
		employee.setEmployeeMotherName(request.getParameter("employeeMotherName"));
		employee.getAddress().setHouseNumber(request.getParameter("houseNo"));
		employee.getAddress().setStreetName(request.getParameter("streetName"));
		employee.getAddress().setLocalityName(request.getParameter("locality"));
		employee.getAddress().setCity(request.getParameter("city"));
		employee.getAddress().setState(request.getParameter("state"));
		employee.getAddress().setCountry(request.getParameter("country"));
		employee.getAddress().setPincode(Integer.parseInt(request.getParameter("pincode")));
		employee.setDesignation(request.getParameter("designation"));
		employee.setUsername(request.getParameter("username"));
		employee.setPassword(request.getParameter("confirmPassword"));
		employee.setReportingTo(request.getParameter("reportingTo"));
		try {
			DatabaseConnection dbcObj = new DatabaseConnection(); // creating object of DatabaseConnection
			dbcObj.setCon(); // setting connection
			Connection con = dbcObj.getCon(); // establishing the connection
			PreparedStatement prepObj1 = con.prepareStatement(
					"SELECT EMPID,EMAIL,USERNAME FROM EMPLOYEE WHERE EMPID=? OR EMAIL=? OR USERNAME=? ");
			prepObj1.setString(1, employee.getEmployeeId());
			prepObj1.setString(2, employee.getEmployeeEmailId());
			prepObj1.setString(3, employee.getUsername());
			ResultSet rsSelect = prepObj1.executeQuery();
			if (rsSelect.next()) {
				if (rsSelect.getString("EMPID").equalsIgnoreCase(employee.getEmployeeId())) {
					writter.print("<div class='errorMsg' align='center'>EmployeeId :"+ employee.getEmployeeId() + " is already registered....</div>");
					RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
					rd.include(request, response);
					
				} else {
					if (rsSelect.getString("USERNAME").equalsIgnoreCase(employee.getUsername())) {
						writter.print("<div class='errorMsg' align='center'>Username :"+ employee.getUsername() + " is already registered...</div>");
						RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
						rd.include(request, response);
					} else {
						if (rsSelect.getString("EMAIL").equalsIgnoreCase(employee.getEmployeeEmailId())) {
							writter.print("<div class='errorMsg' align='center'>Email :"+ employee.getEmployeeEmailId() + " is already registered...</div>");
							RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
							rd.include(request, response);
						}

					}

				}
			} else {

				PreparedStatement prepObj = con.prepareStatement( // it gives permission to write sql query
						"insert into employee(firstname,lastname,empid,email,mobile_no,fathername,mothername,designation,username,password,reportingto) values(?,?,?,?,?,?,?,?,?,?,?)");
				prepObj.setString(1, employee.getFirstName()); // setting the values in sql query from employee class
				prepObj.setString(2, employee.getLastName());
				prepObj.setString(3, employee.getEmployeeId());
				prepObj.setString(4, employee.getEmployeeEmailId());
				prepObj.setString(5, employee.getMobileNumber());
				prepObj.setString(6, employee.getEmployeeFatherName());
				prepObj.setString(7, employee.getEmployeeMotherName());
				prepObj.setString(8, employee.getDesignation());
				prepObj.setString(9, employee.getUsername());
				prepObj.setString(10, employee.getPassword());
				prepObj.setString(11, employee.getReportingTo());

				ResultSet resultObj = prepObj.executeQuery(); // storing the status of query

				PreparedStatement prepObj2 = con.prepareStatement(
						"insert into address(addid,houseno,streetname,locality,city,state,country,pincode,empid) values(?,?,?,?,?,?,?,?,?)");
				prepObj2.setString(1, employee.getEmployeeId());
				prepObj2.setString(2, employee.getAddress().getHouseNumber());
				prepObj2.setString(3, employee.getAddress().getStreetName());
				prepObj2.setString(4, employee.getAddress().getLocalityName());
				prepObj2.setString(5, employee.getAddress().getCity());
				prepObj2.setString(6, employee.getAddress().getState());
				prepObj2.setString(7, employee.getAddress().getCountry());
				prepObj2.setInt(8, employee.getAddress().getPincode());
				prepObj2.setString(9, employee.getEmployeeId());

				ResultSet resultObj2 = prepObj2.executeQuery();
				if (resultObj != null & resultObj2 != null) {
//					writter.print("<script>alert('Employee Registered Successfull...')</script>");
					RequestDispatcher rdObj = request.getRequestDispatcher("Login.jsp");
					rdObj.forward(request, response);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
//			RequestDispatcher rdObj = request.getRequestDispatcher("Registration.jsp");
//			rdObj.forward(request, response);
		}
	}
}