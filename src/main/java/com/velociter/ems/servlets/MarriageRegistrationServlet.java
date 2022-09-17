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

import com.velociter.hibernate.componentmapping.onlinemarriage.MarriageRegistration;

/**
 * Servlet implementation class MarriageRegistrationServlet
 */
@WebServlet("/MarriageRegistrationServlet")
public class MarriageRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MarriageRegistrationServlet() {   
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

		response.setContentType("text/html");
		PrintWriter writter = response.getWriter();

		MarriageRegistration marriage = new MarriageRegistration();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String motherName = request.getParameter("motherName");
		String religion = request.getParameter("religion");
		String fatherName = request.getParameter("fatherName");
		String cast = request.getParameter("cast");
		String mobileNo = request.getParameter("mobileNo");
		String email = request.getParameter("email");
		String job = request.getParameter("job");
		float salary = Float.parseFloat(request.getParameter("salary"))  ;
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String weight = request.getParameter("weight");
		String height = request.getParameter("height");
		
		
		

		String collegeStudied = request.getParameter("collegeStudied");
		String qualification = request.getParameter("qualification"); 

		String houseNo = request.getParameter("houseNo");
		String streetName = request.getParameter("streetName");
		String areaName = request.getParameter("areaName");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		int pinCode = Integer.parseInt(request.getParameter("pinCode"));

		marriage.setFirstName(firstName);
		marriage.setLastName(lastName);
		marriage.setMotherName(motherName);
		marriage.setFatherName(fatherName);
		marriage.setReligion(religion);
		marriage.setCast(cast);
		marriage.setMobileNo(mobileNo);
		marriage.setEmail(email);
		marriage.setJob(job);
		marriage.setSalary(salary);
		marriage.setDob(dob);
		marriage.setGender(gender);
		marriage.setHeight(height);
		marriage.setWeight(weight);

		marriage.getQualification().setCollegeStudied(collegeStudied);
		marriage.getQualification().setQualification(qualification);  

		marriage.getAddress().setHouseNo(houseNo);
		marriage.getAddress().setStreetName(streetName);
		marriage.getAddress().setAreaName(areaName);
		marriage.getAddress().setCity(city);
		marriage.getAddress().setCountry(country);
		marriage.getAddress().setPinCode(pinCode);

		Session session = null;

		try {

			SessionFactory sessionF = new Configuration().configure().buildSessionFactory();
			System.out.println("under try");
			session = sessionF.openSession();

			session.save(marriage);

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
