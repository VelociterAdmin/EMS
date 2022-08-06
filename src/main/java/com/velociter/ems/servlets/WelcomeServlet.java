
package com.velociter.ems.servlets;

import java.io.IOException;
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

/**
 * Servlet implementation class WelcomeServlet
 */
//@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String empId = (String) request.getAttribute("empID");
		try {
			DatabaseConnection db = new DatabaseConnection(); // create DatabaseConnection class object
			db.setCon();
			Connection con = db.getCon(); // establishing the connection
			// PreparedStatement to write for SQL queries
			PreparedStatement prestate = con.prepareStatement("select * from employee where empid=?");
			prestate.setString(1, empId); // set string with indexing value
			ResultSet rs = prestate.executeQuery(); // get the data from database
			rs.next();
			request.setAttribute("firstname", rs.getString("firstname")); // set Attribute for get FirstName
			request.setAttribute("lastname", rs.getString("lastname")); // set Attribute for get lastName
			request.setAttribute("designation", rs.getString("designation"));// set Attribute for get designation
			request.setAttribute("email", rs.getString("email")); // set Attribute for get email
			request.setAttribute("empid", rs.getString("empid")); // set Attribute for get empid

			PreparedStatement prestate2 = con.prepareStatement("select * from address where empid=?");
			prestate2.setString(1, empId);
			ResultSet rs2 = prestate2.executeQuery();
			rs.next();
			request.setAttribute("houseno", rs2.getString("houseno"));
			request.setAttribute("streetname", rs2.getString("streetname"));
			request.setAttribute("locality", rs2.getString("locality"));
			request.setAttribute("city", rs2.getString("city"));
			request.setAttribute("state", rs2.getString("state"));
			request.setAttribute("pincode", rs2.getString("pincode"));
			request.setAttribute("country", rs.getString("country"));

			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp"); // request dispatch on welcome page
			rd.forward(request, response);

		} catch (SQLException e) {
//			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp"); // request dispatch on welcome page
			rd.forward(request, response);
		}
	}

}
