package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.velociter.hibernate.componentmapping.flightbooking.Flight;

/**
 * Servlet implementation class flightBookingServlet
 */
@WebServlet("/flightBookingServlet")
public class flightBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public flightBookingServlet() {
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

		response.setContentType("text/html"); // set the content type
		PrintWriter out = response.getWriter();

		String currentLocation = request.getParameter("currentLocation");
		String destination = request.getParameter("destination");
		String date = request.getParameter("date");

		Flight flight = new Flight();
		flight.getTicket().setCurrentLocation(currentLocation);
		flight.getTicket().setDestination(destination);
		flight.getTicket().setDate(date);
		Session session = null;

		try {

			SessionFactory sessionF = new Configuration().configure().buildSessionFactory();
			System.out.println("under try");
			session = sessionF.openSession();

			session.save(flight);

			Transaction tran = session.beginTransaction();
			tran.commit();

			RequestDispatcher rdObj = request.getRequestDispatcher("Welcome.jsp");
			rdObj.include(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}

	}

}
