package com.velociter.ems.servlets;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.velociter.ems.servlets.WelcomeServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.Employee;

/**
 * Servlet implementation class EducationServlet
 */
@WebServlet("/EducationServlet")
public class EducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//ystem.out.println("eduS ="+request.getAttribute("empid2"));
		WelcomeServlet wcObj=new WelcomeServlet();
		DatabaseConnection db=new DatabaseConnection();
		db.setCon();
		Connection con=db.getCon();
		Employee employee=new Employee();
		employee.getEducation().setSecondary(request.getParameter("secondryEdu"));
		employee.getEducation().setHigherSecondary(request.getParameter("highSecEdu"));
		employee.getEducation().setGraduation(request.getParameter("graduation"));
		employee.getEducation().setPostGraduation(request.getParameter("postGraduation"));
		String empId=(String) request.getAttribute("empid2"); 
		
		try {
			PreparedStatement state=con.prepareStatement("insert into education (eduid,secondary,highersecondary,graduation,postgraduation,empid)values(?,?,?,?,?,?)");
			state.setString(1,(String) request.getAttribute("empid2"));
			state.setString(2, employee.getEducation().getSecondary());
			state.setString(3, employee.getEducation().getHigherSecondary());
			state.setString(4, employee.getEducation().getGraduation());
			state.setString(5, employee.getEducation().getPostGraduation());
			state.setString(6,(String) request.getAttribute("empid2"));
			
			
			ResultSet rs=state.executeQuery();
			
			if (rs!= null) {
				RequestDispatcher rdObj = request.getRequestDispatcher("Welcome.jsp");
				rdObj.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
