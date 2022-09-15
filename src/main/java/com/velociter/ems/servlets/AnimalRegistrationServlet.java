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
import org.hibernate.pretty.Printer;

import com.velociter.hibernate.component.animal.Animal;

/**
 * Servlet implementation class AnimalRegistrationServlet
 */
//@WebSevlet("/AnimalRegistrationServlet")
public class AnimalRegistrationServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String animalName = request.getParameter("AnimalName");
		String animalType = request.getParameter("AnimalType");
		String animalBreed = request.getParameter("AnimalBreed");
		String animalWeight = request.getParameter("AnimalWeight");
		String animalheight = request.getParameter("AnimalHeight");
		int animalLegs = Integer.parseInt(request.getParameter("AnimalLegs"));
		String animalReprod = request.getParameter("AnimalReproduct");
		String animalFood = request.getParameter("AnimalFood");
		String animalDiet = request.getParameter("AnimalDiet");
		String lifeSpan = request.getParameter("AnimalLife");
		String benifits = request.getParameter("AnimalBenifits");
		String Place = request.getParameter("AnimalPlace");

		Animal animal = new Animal();
		animal.setAnimalName(animalName);
		animal.setAnimalBreed(animalBreed);
		animal.setAnimalType(animalType);
		animal.setAnimalWieght(animalWeight);
		animal.setAnimalHeight(animalheight);
		animal.setLegs(animalLegs);
		animal.setFood(animalFood);
		animal.setDietType(animalDiet);
		animal.setLifeSpan(lifeSpan);
		animal.setReproductType(animalReprod);
		animal.getWildAnimal().setPlace(Place);
		animal.getDomesticAnimal().setPurposeOfCapturing(benifits);

		Session session = null;
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
			session.save(animal);
			
			Transaction tx = session.beginTransaction();
			tx.commit();
			
			out.print("AnimalDetails Inserted Succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}
}