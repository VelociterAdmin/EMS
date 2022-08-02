package com.velociter.ems.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.Employee;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// doPost method used for providing request and get response
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // set the content of the pages
		PrintWriter writer = response.getWriter(); // create PrintWriter object for writing on page

		Employee employee = new Employee(); // create employee object

		employee.setUsername(request.getParameter("Username")); // set the username into employee class
		employee.setPassword(request.getParameter("Password")); // set the password into employee class

		if (validate(employee.getUsername(), employee.getPassword(), request)) { // passing the username and password to
																					// validate()
			request.setAttribute("username", employee.getUsername()); // Set attribute username from employee class
			request.setAttribute("password", employee.getPassword()); // Set attribute password from employee class

			// if username and password is correct then dispatch to the welcome page
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		} else {
			// if username and password is wrong then include on login page
			writer.print("Username or Password is wrong");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);

		}
	}

	// validate() to check username and password
	public static boolean validate(String username, String password, HttpServletRequest request) {
		boolean status = false;
		try {
			DatabaseConnection db = new DatabaseConnection(); // create DatabaseConnection class object
			db.setCon();
			Connection con = db.getCon(); // establishing the connection
			// PreparedStatement to write for sql queries
			PreparedStatement statement = con.prepareStatement("select firstname from employee where username=? and password=?");
			statement.setString(1, username); // set the username
			statement.setString(2, password); // set the password
			ResultSet result = statement.executeQuery(); // get the data from database
			status = result.next();

			request.setAttribute("firstname", result.getString(1)); // set Attribute for get firstname

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
