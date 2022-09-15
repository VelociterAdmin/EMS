package com.velociter.ems.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.velociter.ems.helper.DatabaseConnection;

/**
 * Servlet implementation class ReportingEmpServlet
 */
//@WebServlet("/ReportingEmpServlet")
public class ReportingEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportingEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		DatabaseConnection dbCon = new DatabaseConnection();
		dbCon.setCon();
		Connection con = dbCon.getCon();
		HttpSession session = request.getSession();
		String reportingTo = (String) session.getAttribute("empId");
		if (true) {

			try {
				
				PreparedStatement psObj = con.prepareStatement(
						"Select FIRSTNAME,LASTNAME,DESIGNATION,EMAIL,EMPID,MOBILE_NO from Employee where REPORTINGTO=?");
				psObj.setString(1, reportingTo);
				ResultSet rsObj = psObj.executeQuery();
				ArrayList<String> firstname = new ArrayList<String>();
				ArrayList<String> lastname = new ArrayList<String>();
				ArrayList<String> designation = new ArrayList<String>();
				ArrayList<String> email = new ArrayList<String>();
				ArrayList<String> empid = new ArrayList<String>();
				ArrayList<String> mobilenumber = new ArrayList<String>();

				while (rsObj.next()) {
					firstname.add(rsObj.getString("firstname"));
					lastname.add(rsObj.getString("lastname"));
					designation.add(rsObj.getString("designation"));
					email.add(rsObj.getString("email"));
					empid.add(rsObj.getString("empid"));
					mobilenumber.add(rsObj.getString("mobile_no"));

				}
				session.setAttribute("firstnames", firstname);
				session.setAttribute("lastnames", lastname);
				session.setAttribute("designations", designation);
				session.setAttribute("emails", email);
				session.setAttribute("empids", empid);
				session.setAttribute("mobile_nos", mobilenumber);

//				RequestDispatcher rd = request.getRequestDispatcher("/jsp/ReportingEmployees.jsp");
//				rd.forward(request, response);
			    response.sendRedirect("jsp/ReportingEmployees.jsp");

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}
}
