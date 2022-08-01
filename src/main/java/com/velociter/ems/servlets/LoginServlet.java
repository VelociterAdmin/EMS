package com.velociter.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.velociter.ems.helper.DatabaseConnection;
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
		
		Employee employee= new Employee();
		
		employee.setUsername(request.getParameter("Username"));
		employee.setPassword(request.getParameter("Password"));
		
	
		if(validate(employee.getUsername(), employee.getPassword(),request)) {
			request.setAttribute("username", employee.getUsername());
			request.setAttribute("password", employee.getPassword());
			
            RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
            rd.forward(request, response);
		}
		else {
			writer.print("failed");
			 RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	            rd.include(request, response);

		}
	}
	public static boolean validate(String username,String password,HttpServletRequest request) {
		boolean status=false;
		try {
			DatabaseConnection db=new DatabaseConnection();
			db.setCon();
			Connection con = db.getCon();
			PreparedStatement statement=con.prepareStatement("select Firstname from employee where username=? and password=?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result=statement.executeQuery();
			status=result.next();
			System.out.println(result.getString(1));
			request.setAttribute("firstname", result.getString(1));
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
