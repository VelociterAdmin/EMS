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

import com.velociter.hibernate.componentmapping.customer.Customer;

/**
 * Servlet implementation class CustomerRegistrationServlet
 */
@WebServlet("/CustomerRegistrationServlet")
public class CustomerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writter = response.getWriter();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobileNo = request.getParameter("mobileNo");
		String houseNo = request.getParameter("houseNo");
		String streetName = request.getParameter("streetName");
		String areaName = request.getParameter("areaName");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String pinCode = request.getParameter("pinCode");

		Customer customer = new Customer();
		customer.setFirst(firstName);
		customer.setLast(lastName);
		customer.setMobileNo(mobileNo);
		customer.getAddress().setHouseNo(houseNo);
		customer.getAddress().setStreetName(streetName);
		customer.getAddress().setAreaName(areaName);
		customer.getAddress().setCity(city);
		customer.getAddress().setCountry(country);
		customer.getAddress().setPinCode(Integer.parseInt(pinCode));
		

		Session session = null;

		try {

			SessionFactory sessionF = new Configuration().configure().buildSessionFactory();
			System.out.println("under try");
			session = sessionF.openSession();

			session.save(customer);

			Transaction tran = session.beginTransaction();
			tran.commit();
			
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
