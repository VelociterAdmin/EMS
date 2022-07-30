package com.velociter.ems.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.velociter.ems.helper.DatabaseConnection;

public class LoginValidation {
	public static boolean validate(String username,String password) {
		boolean status=false;
		try {
			DatabaseConnection db=new DatabaseConnection();
			db.setCon();
			Connection con = db.getCon();
			//PreparedStatement statement=con.prepareStatement("select * from EMPLOYEE where username=? and password=?");
			PreparedStatement statement=con.prepareStatement("select * from emp where empname=? and city=?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result=statement.executeQuery();
			status=result.next();
			System.out.println(username +" "+ password);
			System.out.println(status);
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
