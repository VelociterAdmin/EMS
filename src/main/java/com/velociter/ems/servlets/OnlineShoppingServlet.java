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

import com.velociter.hibernate.componentmapping.onlineshopping.Shopping;

/**
 * Servlet implementation class OnlineShoppingServlet
 */
@WebServlet("/OnlineShoppingServlet")
public class OnlineShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OnlineShoppingServlet() {
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

		Shopping shop = new Shopping();
		String productType = request.getParameter("productType");
		shop.setProductType(productType);

		String productName = request.getParameter("productName");
		shop.setProductName(productName);

		String productBrand = request.getParameter("productBrand");
		shop.setProductBrand(productBrand);

		String productColour = request.getParameter("productColour");
		shop.setProductColour(productColour);

		String productWeight = request.getParameter("productWeight");
		shop.setProductWeight(productWeight);

		System.out.println(productColour +" "+productWeight);
		
		float productPrice = Float.parseFloat(request.getParameter("productPrice"));
		shop.setProductPrice(productPrice);

		String productWarranty = request.getParameter("productWarranty");
		shop.setProductWarranty(productWarranty);

/*		String firstName = request.getParameter("firstName");
		shop.getCustomer().setFirstName(firstName);

		String lastName = request.getParameter("lastName");
		shop.getCustomer().setLastName(lastName);

		String mobileNo = request.getParameter("mobileNo");
		shop.getCustomer().setMobileNo(mobileNo);

		String email = request.getParameter("email");
		shop.getCustomer().setEmail(email);

		String houseNo = request.getParameter("houseNo");
		shop.getCustomer().getAddress().setHouseNo(houseNo);

		String streetName = request.getParameter("streetName");
		shop.getCustomer().getAddress().setStreetName(streetName);

		String areaName = request.getParameter("areaName");
		shop.getCustomer().getAddress().setAreaName(areaName);

		String city = request.getParameter("city");
		shop.getCustomer().getAddress().setCity(city);

		String country = request.getParameter("country");
		shop.getCustomer().getAddress().setCountry(country);

		int pinCode = Integer.parseInt(request.getParameter("pinCode"));
		shop.getCustomer().getAddress().setPinCode(pinCode);               */

		Session session = null;

		try {

			SessionFactory sessionF = new Configuration().configure().buildSessionFactory();
			System.out.println("under try");
			session = sessionF.openSession();

			session.save(shop);

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
