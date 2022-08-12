package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Operation {
	public ArrayList<String> getCountries() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			DatabaseConnection db = new DatabaseConnection(); // create DatabaseConnection class object
			db.setCon();
			Connection con = db.getCon(); // establishing the connection
//			Country country = new Country();
			PreparedStatement statement = con.prepareStatement("select countryname from country");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		Operation o = new Operation();
		ArrayList<String> a = o.getCountries();
		System.out.println("list :");
		for(String s: a) {
			System.out.println(s);
		}
	}
}
