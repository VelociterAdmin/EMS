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

import com.velociter.hibernate.componentmapping.dress.Dress;

/**
 * Servlet implementation class DressServlet
 */
@WebServlet("/DressServlet")
public class DressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 String category = request.getParameter("category");
		 String dressType = request.getParameter("dressType");
		 String dressName = request.getParameter("dressName");
		 String dressBrand = request.getParameter("dressBrand");
		 String dressQuality = request.getParameter("dressQuality");
		 String dressSize = request.getParameter("dressSize");
		 String dressColour = request.getParameter("dressColour");
		 float dressPrice = Float.parseFloat(request.getParameter("dressPrice"));
		 
		 Dress dress = new Dress();
		 dress.setCategory(category);
		 dress.setDressType(dressType);
		 dress.getDd().setDressName(dressName);
		 dress.getDd().setDressBrand(dressBrand);
		 dress.getDd().setDressColour(dressColour);
		 dress.getDd().setDressSize(dressSize);
		 dress.getDd().setDressQuality(dressQuality);
		 dress.getDd().setDressPrice(dressPrice);
		 
		 Session session=null;
			try {
				System.out.println("Start");
				SessionFactory sf = new Configuration().configure().buildSessionFactory();
				System.out.println("Inserting Records");
				
				session = sf.openSession();

				session.save(dress);
				
				
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
				
				
	
		
	