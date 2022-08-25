package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.Address;
import com.velociter.ems.pojo.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
//@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");	//set contentType
		PrintWriter pw = response.getWriter();  //create PrintWriter object
//		System.out.println("UpdateServlet");
		HttpSession session = request.getSession(); 	//create session object
		Employee emp = new Employee();            //create employee class object
		//get the personal information from welcome page and set into employee class
		emp.setFirstName(request.getParameter("empfname"));
		emp.setLastName(request.getParameter("emplname"));
		emp.setDesignation(request.getParameter("empdesign"));
		emp.setEmployeeEmailId(request.getParameter("empemail"));
		
		// create object of DatabaseConnection
		DatabaseConnection db = new DatabaseConnection();
		db.setCon();
		Connection con = db.getCon();	//establish the connection
		String empId = (String) session.getAttribute("empId"); 	//getting empid
		try {
			// PreparedStatement to write for SQL queries
			PreparedStatement ps = con
					.prepareStatement("update employee set firstname=?,lastname=?,designation=?,email=? where empId=?");
			
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getDesignation());
			ps.setString(4, emp.getEmployeeEmailId());
			ps.setString(5, empId);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
//				System.out.println("Update successful");
				//including welcomeServlet
				RequestDispatcher rd = request.getRequestDispatcher("../WelcomeServlet1");
				rd.include(request, response);
				RequestDispatcher rd2 = request.getRequestDispatcher("Welcome.jsp");
				rd2.include(request, response);
				pw.print("<script>showPanel(0,'gray');</script>");
				
			} else {
//				System.out.println("Update unsuccessful");
				RequestDispatcher rd = request.getRequestDispatcher("../WelcomeServlet1");
				rd.include(request, response);
			}
			
		
		} catch (SQLException e) {
			e.getStackTrace();

		}
	}

}
