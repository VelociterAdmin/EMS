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

import com.velociter.hibernate.componentmapping.recharge.MobileRecharge;

/**
 * Servlet implementation class MobileRechargeServlet
 */
@WebServlet("/MobileRechargeServlet")
public class MobileRechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String mobileNum=request.getParameter("mobileNum");
		String operatorName=request.getParameter("operatorName");
		String planName=request.getParameter("planName");
		float balance=Float.parseFloat(request.getParameter("balance"));
		String validity=request.getParameter("validity");
		String data=request.getParameter("data");
		String offer=request.getParameter("offer");
		
		MobileRecharge mob=new MobileRecharge();
		mob.setMobileNum(mobileNum);
		mob.setOperatorName(operatorName);
		mob.getPlan().setPlanName(planName);
		mob.getPlan().setBalance(balance);
		mob.getPlan().setValidity(validity);
		mob.getPlan().setData(data);
		mob.getPlan().setOffer(offer);
	
		Session session=null;
		try {
			System.out.println("Start");
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			System.out.println("Inserting Records");
			session = sf.openSession();

			session.save(mob);
			
			
			Transaction tx = session.beginTransaction();
			tx.commit();
			
			RequestDispatcher rq=request.getRequestDispatcher("Welcome.jsp");
			rq.include(request, response);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {

			session.flush();
			session.close();
		}

	}
			
			
}
	
