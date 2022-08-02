package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection con;           //connection is an interface

	public Connection getCon() {
		return con;
	}

	public void setCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //registering and loading the driver
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system"); //establishing connection
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

}
