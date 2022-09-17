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

import com.velociter.hibernate.componentmapping.electronic.ElectronicProduct;

/**
 * Servlet implementation class ElectronicServlet
 */
@WebServlet("/ElectronicServlet")
public class ElectronicServlet extends HttpServlet {
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

		String productName = request.getParameter("productName");
		String brand = request.getParameter("brand");
		String colour = request.getParameter("colour");
		String warranty = request.getParameter("warranty");
		String specialFeature = request.getParameter("specialFeature");
		String productWeight = request.getParameter("productWeight");
		float price = Float.parseFloat(request.getParameter("price"));

		ElectronicProduct product = new ElectronicProduct();
		product.setProductName(productName);
		product.getProduct().setBrand(brand);
		product.getProduct().setColour(colour);
		product.getProduct().setProductWeight(productWeight);
		product.getProduct().setSpecialFeature(specialFeature);
		product.getProduct().setWarranty(warranty);
		product.getProduct().setPrice(price);

		Session session = null;
		try {
			System.out.println("Start");
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			System.out.println("Inserting Records");

			session = sf.openSession();

			session.save(product);

			Transaction tx = session.beginTransaction();
			tx.commit();

			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {

			session.flush();
			session.close();
		}

	}
}
