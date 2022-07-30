package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.velociter.ems.pojo.Employee;
import com.velociter.ems.pojo.LoginValidation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		//writer.print("<h1>Welcome to register </h1>");
		Employee employee= new Employee();
		
		employee.setUsername(request.getParameter("Username"));
		employee.setPassword(request.getParameter("Password"));
		
	
		if(LoginValidation.validate(employee.getUsername(), employee.getPassword())) {
			writer.print("Success");
            RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
            rd.forward(request, response);
		}
		else {
			writer.print("failed");
			 RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	            rd.include(request, response);

		}
	}

}
