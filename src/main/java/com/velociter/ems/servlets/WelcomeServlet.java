package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html"); 		//set content type
		PrintWriter out = response.getWriter();		//create object of PrintWriter
		HttpSession session = request.getSession();		//create session 

		String empid = (String) session.getAttribute("empid"); 	//getting empid
		if (session.getAttribute("empid") == null) {	//if empid is null
			response.sendRedirect("Login.jsp");			//redirect on login page
		} else {
					
			try {
				DatabaseConnection db = new DatabaseConnection(); // create DatabaseConnection class object
				db.setCon();
				Connection con = db.getCon(); // establishing the connection
				// PreparedStatement to write for SQL queries
				PreparedStatement prestate = con.prepareStatement("select * from employee where empid=?");
				prestate.setString(1, empid); // set string with indexing value
				ResultSet rs = prestate.executeQuery(); // get the data from database
				rs.next();
				// getting data from employee table in Strings
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String designation = rs.getString("designation");
				String email = rs.getString("email");
				String empId = rs.getString("empid");
				String reportingTo=rs.getString("reportingto");
				session.setAttribute("firstname", firstname); // set Attribute for get FirstName
				session.setAttribute("lastname", lastname); // set Attribute for get lastName
				session.setAttribute("designation", designation);// set Attribute for get designation
				session.setAttribute("email", email); // set Attribute for get email
				session.setAttribute("empId", empId); // set Attribute for get empid
				session.setAttribute("reportingto",reportingTo);
				
				// PreparedStatement to write for SQL queries
				PreparedStatement prestate2 = con.prepareStatement("select * from address where empid=?");
				prestate2.setString(1, empid);
				ResultSet rs2 = prestate2.executeQuery();
				rs2.next();
				session.setAttribute("houseno", rs2.getString("houseno"));
				session.setAttribute("streetname", rs2.getString("streetname"));
				session.setAttribute("locality", rs2.getString("locality"));
				session.setAttribute("city", rs2.getString("city"));
				session.setAttribute("state", rs2.getString("state"));
				session.setAttribute("pincode", rs2.getString("pincode"));
				session.setAttribute("country", rs2.getString("country"));
				// PreparedStatement to write for SQL queries
				PreparedStatement edudetail=con.prepareStatement("select * from education where empid=?");
				edudetail.setString(1,empid);
				ResultSet rs3=edudetail.executeQuery();
				//creating arraylist objects
				ArrayList<String> fields = new ArrayList<String>();
				ArrayList<String> school = new ArrayList<String>();
				ArrayList<String> board = new ArrayList<String>();
				ArrayList<String> grade = new ArrayList<String>();
				
				while(rs3.next()) {
				//adding data from employee to Arraylist			
					fields.add(rs3.getString("FieldName"));
					school.add(rs3.getString("School"));
					board.add(rs3.getString("University"));
					grade.add(rs3.getString("Grades"));
				//setting attributes
					session.setAttribute("fields", fields);
					session.setAttribute("school", school);
					session.setAttribute("university", board);
					session.setAttribute("grade", grade);
					
					
				}
//				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp"); // request dispatch on welcome page
//				rd.forward(request, response);
				response.sendRedirect("Welcome.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
				
//				RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp"); // request dispatch on welcome page
//				rd.include(request, response);
			}

		}

	}

}
