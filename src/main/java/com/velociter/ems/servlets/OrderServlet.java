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

import com.velociter.hibernate.component.order.Order;

/**
 * Servlet implementation class OrderServlet
 */
//@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String itemName = request.getParameter("ItemName");
		String itemtype = request.getParameter("ItemType");
		float itemPrice = Float.parseFloat(request.getParameter("ItemPrice"));
		int itemQty = Integer.parseInt(request.getParameter("ItemQty"));
		String customerName = request.getParameter("CustomerName");
		String streetName = request.getParameter("StreetName");
		String areaName = request.getParameter("Areaname");
		String cityName = request.getParameter("CityName");
		String stateName = request.getParameter("StateName");
		String countryName = request.getParameter("CountryName");
		int pincode = Integer.parseInt(request.getParameter("Pincode"));

		Order order = new Order();
		order.getItem().setItemName(itemName);
		order.getItem().setItemType(itemtype);
		order.getItem().setItemPrice(itemPrice);
		order.getItem().setItemQuantity(itemQty);
		order.getCustomer().setCustomerName(customerName);
		order.getCustomer().getAddress().setStreet(streetName);
		order.getCustomer().getAddress().setAreaName(areaName);
		order.getCustomer().getAddress().setCity(cityName);
		order.getCustomer().getAddress().setState(stateName);
		order.getCustomer().getAddress().setCountry(countryName);
		order.getCustomer().getAddress().setPinCode(pincode);
		Session session = null;
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
			session.save(order);
			Transaction tx = session.beginTransaction();
			tx.commit();
			out.print("OrderDetails Inserted Succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
	}

}
