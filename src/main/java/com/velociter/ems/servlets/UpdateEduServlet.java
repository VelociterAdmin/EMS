package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.Education;

/**
 * Servlet implementation class UpdateEduServlet
 */
//@WebServlet("/UpdateEduServlet")
public class UpdateEduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("html/text");
		PrintWriter pwObj=response.getWriter();
		System.out.println("UpdateEducationServlet");
		HttpSession session= request.getSession();
		Education edu=new Education();
		
		System.out.println(request.getParameter("board0"));
//		
//		edu.setFieldName(request.getParameter("field"));
//		
//		DatabaseConnection dbCon = new DatabaseConnection();
//		dbCon.setCon();
//		Connection con = dbCon.getCon();
//		try {
//			PreparedStatement preObj= con.prepareStatement("update education set school=?,university=?,grades=?, where empId=?,fieldname=?");
//			
//			
//			
//		}
//		catch(SQLException e) {
//			e.getStackTrace();
//			
//			
//		}
	}

}
