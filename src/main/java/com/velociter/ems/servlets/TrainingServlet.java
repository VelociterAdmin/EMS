package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.velociter.hibernate.component.training.TrainingCenter;

/**
 * Servlet implementation class TrainingServlet
 */
//@WebServlet("/TrainingServlet")
public class TrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		long studentRollNo = Long.parseLong(request.getParameter("studentRollNo"));
		String studentName = request.getParameter("studentName");
		String courseName = request.getParameter("courseName");
		String courseDuration = request.getParameter("courseDuration");
		float courseFees = Float.parseFloat(request.getParameter("courseFees"));
		
		TrainingCenter center = new TrainingCenter();
		center.getStudent().setStudentRollNo(studentRollNo);
		center.getStudent().setStudentName(studentName);
		center.getCourse().setCourseName(courseName);
		center.getCourse().setCourseDuration(courseDuration);
		center.getCourse().setCourseFees(courseFees);
		
		Session session = null;
		Transaction tx = null;
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();

			session.save(center);
			tx = session.beginTransaction();
			tx.commit();
			
			out.print("CourseDetails Inserted Succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.include(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}

		}
	}
}