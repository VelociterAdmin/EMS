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

import com.velociter.hibernate.componentmapping.socialmedia.SocialMedia;

/**
 * Servlet implementation class SocialMediaServlet
 */
@WebServlet("/SocialMediaServlet")
public class SocialMediaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SocialMediaServlet() {
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

		response.setContentType("text/html"); // set the content of the page as text and html
		PrintWriter writter = response.getWriter();

		SocialMedia socialObj = new SocialMedia();
	/*	String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String postType = request.getParameter("postType");
		String likeCount = request.getParameter("likeCount");
		String dislikeCount = request.getParameter("dislikeCount");
		String commentCount = request.getParameter("commentCount");  */
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobileNo = request.getParameter("mobileNo");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

	/*	socialObj.setPassword(password);
		socialObj.setConfirmPassword(confirmPassword);
		socialObj.getPost().setCommentCount(commentCount);
		socialObj.getPost().setDislikeCount(dislikeCount);
		socialObj.getPost().setLikeCount(likeCount);
		socialObj.getPost().setPostType(postType);  */

	
		socialObj.getProfile().setFirstName(firstName);
		socialObj.getProfile().setLastName(lastName);
		socialObj.getProfile().setMobileNumber(mobileNo);
		socialObj.getProfile().setDob(date);
		socialObj.getProfile().setEmail(email);
		socialObj.setPassword(password);
		socialObj.setConfirmPassword(confirmPassword);
		

		Session session = null;

		try {

			SessionFactory sessionF = new Configuration().configure().buildSessionFactory();
			System.out.println("under try");
			session = sessionF.openSession();
			
			if(socialObj.getPassword().equals( socialObj.getConfirmPassword())) {
				
				session.save(socialObj); // Save the contact object in hibernate session
			}
			
			else {
				System.out.println("password is incorrect");
			}

			

			Transaction tx = session.beginTransaction(); // begin the transaction
			tx.commit();
			
			RequestDispatcher rdObj=request.getRequestDispatcher("Welcome.jsp");
			rdObj.include(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
		}

	}

}
