package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
//@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);  
		session.removeAttribute("empid");
		session.removeAttribute("empId");
		session.removeAttribute("firstname");
		session.removeAttribute("lastname");
		session.removeAttribute("designation");
		session.removeAttribute("email");
		session.removeAttribute("empid");
		session.removeAttribute("houseno");
		session.removeAttribute("streetname");
		session.removeAttribute("locality");
		session.removeAttribute("city");
		session.removeAttribute("state");
		session.removeAttribute("pincode");
		session.removeAttribute("country");
		session.getMaxInactiveInterval();
		session.invalidate();
		
		response.sendRedirect("Login.jsp");
	}

}
