package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.velociter.ems.servlets.WelcomeServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.Employee;

/**
 * Servlet implementation class EducationServlet
 */
//@WebServlet("/EducationServlet")
public class EducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // set the content type
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); // create session

		DatabaseConnection db = new DatabaseConnection(); // create databaseConnection object
		db.setCon(); // set connection
		Connection con = db.getCon(); // establishing the connection

		Employee employee = new Employee(); // Create object of employee class
		// setting the values in education class
		employee.getEducation().setFieldName(request.getParameter("FieldName")); 
	    employee.getEducation().setNameOfSchool(request.getParameter("NameofSchool"));
		employee.getEducation().setNameOfUniversity(request.getParameter("NameofUniversity"));
		employee.getEducation().setGrades(request.getParameter("Grade"));

		String empId = (String) session.getAttribute("empId");

		try {
			// PreparedStatement to write for SQL queries
			PreparedStatement state = con.prepareStatement(
					"insert into education (eduid,fieldname,school,university,grades,empid)values(?,?,?,?,?,?)");
			state.setString(1, empId);
			state.setString(2, employee.getEducation().getFieldName());
			state.setString(3, employee.getEducation().getNameOfSchool());
			state.setString(4, employee.getEducation().getNameOfUniversity());
			state.setString(5, employee.getEducation().getGrades());
			state.setString(6, empId);

			ResultSet rs = state.executeQuery();
			// if data is inserted then dispatch to welcome page
			if (rs != null) {
				RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
				rd.include(request, response);
				RequestDispatcher rd2 = request.getRequestDispatcher("Welcome.jsp");
				rd2.include(request, response);
				out.print("<script>showPanel(2,'gray');</script>");
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
//			RequestDispatcher rdObj = request.getRequestDispatcher("Welcome.jsp");
//			rdObj.forward(request, response);

		}

	}

}
