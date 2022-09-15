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

import com.velociter.hibernate.component.foodfactory.FoodFactory;

/**
 * Servlet implementation class DishServlet
 */
//@WebServlet("/DishServlet")
public class DishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String dishName = request.getParameter("dishName");
		String dishType = request.getParameter("dishType");
		float dishPrice =Float.parseFloat( request.getParameter("dishPrice"));
		float gst = Float.parseFloat(request.getParameter("GST"));
		float dishDiscount = Float.parseFloat(request.getParameter("dishDiscount"));
		float dishTotal= Float.parseFloat(request.getParameter("dishTotal"));
		
		FoodFactory food = new FoodFactory();
		food.getDish().setDishName(dishName);
		food.getDish().setDishType(dishType);
		food.getPrice().setDishPrice(dishPrice);
		food.getPrice().setGst(gst);
		food.getPrice().setDishDiscount(dishDiscount);
		food.getPrice().setTotal(dishTotal);
		
		Session session = null;
		
		try {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			session = sf.openSession();
			
			session.save(food);
			
			Transaction tx = session.beginTransaction();
			
			tx.commit();
			
			out.print("DishDetails Inserted Succesfully");
			
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			
			rd.include(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}
	}

}