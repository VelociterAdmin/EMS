package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.Employee;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  //dopost is used to give and take request and response
			throws ServletException, IOException {

		response.setContentType("text/html");                 //set the content of the page as text and html
		// PrintWriter writter = response.getWriter();
		Employee employee = new Employee();
		employee.setFirstName(request.getParameter("employeeName"));
		employee.setLastName(request.getParameter("employeeLastName"));
		employee.setEmployeeId(request.getParameter("employeeId"));
		employee.setEmployeeEmailId(request.getParameter("employeeEmailId"));
		employee.setMobileNumber(request.getParameter("mobileNumber"));
		employee.setEmployeeFatherName(request.getParameter("employeeFather'sName"));
		employee.setEmployeeMotherName(request.getParameter("employeeMother'sName"));
		employee.getAddress().setHouseNumber(request.getParameter("houseNo."));
		employee.getAddress().setStreetName(request.getParameter("streetName"));
		employee.getAddress().setLocalityName(request.getParameter("locality"));
		employee.getAddress().setCity(request.getParameter("city"));
		employee.getAddress().setState(request.getParameter("state"));
		employee.getAddress().setCountry(request.getParameter("country"));
		employee.getAddress().setPincode(Integer.parseInt(request.getParameter("pincode")));
		employee.setDesignation(request.getParameter("designation"));
		employee.setUsername(request.getParameter("username"));
		employee.setPassword(request.getParameter("password"));

		/*
		 * writter.print(employee.getFirstName());
		 * writter.print(employee.getLastName());
		 * writter.print(employee.getEmployeeId());
		 * writter.print(employee.getEmployeeEmailId());
		 * writter.print(employee.getMobileNumber());
		 * writter.print(employee.getEmployeeFatherName());
		 * writter.print(employee.getEmployeeMotherName());
		 * writter.print(employee.getAddress().getHouseNumber());
		 * writter.print(employee.getAddress().getStreetName());
		 * writter.print(employee.getAddress().getLocalityName());
		 * writter.print(employee.getAddress().getCity());
		 * writter.print(employee.getAddress().getState());
		 * writter.print(employee.getAddress().getCountry());
		 * writter.print(employee.getAddress().getPincode());
		 */

		try {
			DatabaseConnection dbcObj = new DatabaseConnection(); //creating object of DatabaseConnection
			dbcObj.setCon();           //setting connection
			Connection con = dbcObj.getCon();   //establishing the connection
			PreparedStatement prepObj = con.prepareStatement(          //it gives permission to write sql query
					"insert into employee(firstname,lastname,"
					+ "empid,email,mobile_no,fathername,"
					+ "mothername,designation,username"
					+ ",password) values(?,?,?,?,?,?,?,?,?,?)");
			prepObj.setString(1, employee.getFirstName());        //setting the values in sql query from employee class
			prepObj.setString(2, employee.getLastName());
			prepObj.setString(3, employee.getEmployeeId());
			prepObj.setString(4, employee.getEmployeeEmailId());
			prepObj.setString(5, employee.getMobileNumber());
			prepObj.setString(6, employee.getEmployeeFatherName());
			prepObj.setString(7, employee.getEmployeeMotherName());
			prepObj.setString(8, employee.getDesignation());
			prepObj.setString(9, employee.getUsername());
			prepObj.setString(10, employee.getPassword());

			ResultSet resultObj = prepObj.executeQuery();  //storing the status of query

			PreparedStatement prepObj2 = con.prepareStatement(
					"insert into address(houseno,streetname,locality,city,state,country,pincode,empid) values(?,?,?,?,?,?,?,?)");
			prepObj2.setString(1, employee.getAddress().getHouseNumber());
			prepObj2.setString(2, employee.getAddress().getStreetName());
			prepObj2.setString(3, employee.getAddress().getLocalityName());
			prepObj2.setString(4, employee.getAddress().getCity());
			prepObj2.setString(5, employee.getAddress().getState());
			prepObj2.setString(6, employee.getAddress().getCountry());
			prepObj2.setInt(7, employee.getAddress().getPincode());
			prepObj2.setString(8, employee.getEmployeeId());

			ResultSet resultObj2 = prepObj2.executeQuery();
			if (resultObj != null & resultObj2 != null) {
				RequestDispatcher rdObj = request.getRequestDispatcher("Login.jsp");
				rdObj.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}