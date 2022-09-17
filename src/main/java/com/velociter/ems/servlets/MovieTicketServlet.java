package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

import com.velociter.hibernate.componentmapping.movie.MovieTicket;

/**
 * Servlet implementation class MovieTicketServlet
 */
@WebServlet("/MovieTicketServlet")
public class MovieTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String movieType = request.getParameter("movieType");
		String movieName = request.getParameter("movieName");
		int screenNo = Integer.parseInt(request.getParameter("screenNo"));
		String movieTime = request.getParameter("movieTime");
		String seatType = request.getParameter("seatType");
		String seatNum = request.getParameter("seatNum");
		float price = Float.parseFloat(request.getParameter("price"));

		MovieTicket movie = new MovieTicket();
		movie.setMovieType(movieType);
		movie.getTckt().setMovieName(movieName);
		movie.getTckt().setScreenNo(screenNo);
		movie.getTckt().setMovieTime(movieTime);
		movie.getTckt().setSeatType(seatType);
		movie.getTckt().setSeatNum(seatNum);
		movie.getTckt().setPrice(price);

		Session session = null;
		try {
			System.out.println("Start");
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			System.out.println("Inserting Records");

			session = sf.openSession();

			session.save(movie);

			Transaction tc = session.beginTransaction();
			tc.commit();
			
			RequestDispatcher rq = request.getRequestDispatcher("Welcome.jsp");
			rq.include(request, response);
			
		} catch (Exception e) {

			System.err.println(e.getMessage());

		} finally {

			session.flush();
			session.close();
		}
	}

}
