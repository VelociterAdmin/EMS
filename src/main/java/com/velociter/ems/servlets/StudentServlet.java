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

import com.velociter.hibernate.componentmapping.student.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
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

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String motherName = request.getParameter("motherName");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String houseNo = request.getParameter("houseNo");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		String state = request.getParameter("state");
		String field = request.getParameter("field");
		String instituteName = request.getParameter("instituteName");
		String boardorUniversity = request.getParameter("boardorUniversity");
		String grade = request.getParameter("grade");

		Student student = new Student();
		student.getInfo().setFirstName(firstName);
		student.getInfo().setLastName(lastName);
		student.getInfo().setFatherName(fatherName);
		student.getInfo().setMotherName(motherName);
		student.getInfo().setEmail(email);
		student.getInfo().setContact(contact);
		student.getAddress().setHouseNo(houseNo);
		student.getAddress().setStreet(street);
		student.getAddress().setCity(city);
		student.getAddress().setPincode(pincode);
		student.getAddress().setState(state);
		student.getEducation().setField(field);
		student.getEducation().setInstitueName(instituteName);
		student.getEducation().setBoardOrUniversity(boardorUniversity);
		student.getEducation().setGrade(grade);
		

		Session session = null;
		try {
			System.out.println("Start");
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			System.out.println("Inserting Records");

			session = sf.openSession();

			session.save(student);

			Transaction tx = session.beginTransaction();
			tx.commit();

			RequestDispatcher rq = request.getRequestDispatcher("Welcome.jsp");
			rq.include(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {

			session.flush();
			session.close();
		}

	}
}
