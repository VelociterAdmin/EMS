package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.velociter.hibernate.componentmapping.dress.Dress;

/**
 * Servlet implementation class DressDetailsServlet
 */
@WebServlet("/DressDetailsServlet")
public class DressDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   
	   Session session = null;
	   try {
		   SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		   
		   session=sessionfactory.openSession();
		   
		   Query query=session.createQuery("From Dress");
		   List<Dress> list=query.list();
		   
		   Dress dress = new Dress();
		   
		   
		   
	   }catch(Exception e) {
		   e.printStackTrace();
		   
		   
	   }
	 
	}

}
