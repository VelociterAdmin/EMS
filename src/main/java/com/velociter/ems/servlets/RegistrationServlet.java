package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		response.setContentType("text/html");
		PrintWriter writter = response.getWriter();
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

		/**
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


	}

}
