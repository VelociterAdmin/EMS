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
 * Servlet implementation class UpdateAddressServlet
 */
//@WebServlet("/UpdateAddressServlet")
public class UpdateAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");	//set the contentType
		PrintWriter pw = response.getWriter();     //create printwriter object
//		System.out.println("UpdateServlet");
		HttpSession session = request.getSession();	  
		
		Address add = new Address();	//create object of address class 
		add.setHouseNumber(request.getParameter("emphouseno"));		//getting address detail from welcome page and set into address class
		add.setStreetName(request.getParameter("empstreetname"));
		add.setLocalityName(request.getParameter("emplocality"));
		add.setCity(request.getParameter("empcity"));
		add.setState(request.getParameter("empstate"));
		add.setPincode(Integer.parseInt(request.getParameter("emppincode")));
		add.setCountry(request.getParameter("empcountry"));
		
		DatabaseConnection db = new DatabaseConnection();
		db.setCon();
		Connection con = db.getCon();
		String empId = (String) session.getAttribute("empId");
		
		try {
			//PreparedStatement to write for SQL queries
			PreparedStatement pt = con.prepareStatement("update address set houseno=?,streetname=?,locality=?,city=?,state=?,pincode=?,country=? where empId=?");
			pt.setString(1, add.getHouseNumber());
			pt.setString(2, add.getStreetName());
			pt.setString(3, add.getLocalityName());
			pt.setString(4, add.getCity());
			pt.setString(5, add.getState());
			pt.setInt(6, add.getPincode());
			pt.setString(7, add.getCountry());
			pt.setString(8, empId);
			
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
//				System.out.println("Update successful");
				RequestDispatcher rd = request.getRequestDispatcher("../WelcomeServlet1");
				rd.include(request, response);
				RequestDispatcher rd2 = request.getRequestDispatcher("Welcome.jsp");
				rd2.include(request, response);
				pw.print("<script>showPanel(1,'gray');</script>");
				
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

