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
import javax.servlet.http.HttpSession;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.Employee;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
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

	// validate() to check username
	public static boolean validateUsername(String username, HttpServletRequest request, HttpServletResponse response,
			PrintWriter writer) throws ServletException, IOException {
		boolean status = false;
		try {
			DatabaseConnection db = new DatabaseConnection(); // create DatabaseConnection class object
			db.setCon();
			Connection con = db.getCon(); // establishing the connection
			// PreparedStatement to write for SQL queries
			PreparedStatement statement = con.prepareStatement("select password from employee where username=?");
			statement.setString(1, username); // set the UserName
			ResultSet result = statement.executeQuery(); // get the data from database
			status = result.next();

		} catch (SQLException e) {
			e.printStackTrace();
			writer.print(e);
//			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//			rd.include(request, response);
		}
		return status;
	}

	// validate() to check password
	public static boolean validatePassword(String password,String username, HttpServletRequest request) {
		boolean checkpassword = false;
		try {
			DatabaseConnection db = new DatabaseConnection(); // create DatabaseConnection class object
			db.setCon();
			Connection con = db.getCon(); // establishing the connection
			PreparedStatement prestate = con.prepareStatement("select empid from employee where password=? and username=?");
			prestate.setString(1, password); // set the password
			prestate.setString(2, username); // set the username
			
			ResultSet set = prestate.executeQuery(); // get the data from database
			checkpassword = set.next(); // storing the status of ResulSet
//			request.setAttribute("empID", set.getString("empid")); // set attribute of employeeID

			if (checkpassword) {
				HttpSession session = request.getSession();
				String id = set.getString("empid");
				session.setAttribute("empid", id);
//				System.out.println("id = "+id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkpassword;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // set the content of the pages
		PrintWriter writer = response.getWriter(); // create PrintWriter object for writing on page
		Employee employee = new Employee(); // create employee object
		employee.setUsername(request.getParameter("Username")); // set the username into employee class
		employee.setPassword(request.getParameter("Password")); // set the password into employee class

		if (validateUsername(employee.getUsername(), request, response, writer)) { // passing the username and password
																					// to validate()
			if (validatePassword(employee.getPassword(),employee.getUsername(), request)) {

				// if username and password is correct then dispatch to the welcome page
				RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
				rd.forward(request, response);
			} else {
				// if password is wrong then include on login page
				writer.print("<div class='errorMsg' align='center'>Password is Incorrect</div>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
		} else {
			// if username is wrong then include on login page
			writer.print("<div class='errorMsg' align='center'>Username is Incorrect</div>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
	}


}