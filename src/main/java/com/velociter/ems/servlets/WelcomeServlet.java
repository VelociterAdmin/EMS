
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
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
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
			ResultSet set = prestate.executeQuery(); // get the data from database
			set.next();
			request.setAttribute("firstname", set.getString("firstname")); // set Attribute for get FirstName
			request.setAttribute("lastname", set.getString("lastname")); // set Attribute for get lastName
			request.setAttribute("designation", set.getString("designation"));// set Attribute for get designation
			request.setAttribute("email", set.getString("email")); // set Attribute for get email
			request.setAttribute("empid", set.getString("empid")); // set Attribute for get empid

			PreparedStatement prestate2 = con.prepareStatement("select * from address where empid=?");
			prestate2.setString(1, empId);
			ResultSet set2 = prestate2.executeQuery();
			set2.next();
			request.setAttribute("houseno", set2.getString("houseno"));
			request.setAttribute("streetname", set2.getString("streetname"));
			request.setAttribute("locality", set2.getString("locality"));
			request.setAttribute("city", set2.getString("city"));
			request.setAttribute("state", set2.getString("state"));
			request.setAttribute("pincode", set2.getString("pincode"));
			request.setAttribute("country", set2.getString("country"));

			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp"); // request dispatch on welcome page
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
