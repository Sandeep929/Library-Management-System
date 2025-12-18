package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojo.User;

public class UserDB {
	Connection con = null;
	
	public UserDB() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(System.getenv("DB_URL"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public User checkUser(User u) {
		User u1 = new User();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Users where email = ? and password = ?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPass());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u1.setEmail(rs.getString("email"));
				u1.setPass(rs.getString("password"));
				u1.setRole(rs.getString("role"));
			}
			return u1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in Checking User Details");
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUserRole(String email) {
		User u = null; // Tune yaha pe hi initialize kar ke rakha tha jiske wajah se wo null nahi aa raha tha
		try {
			PreparedStatement ps = con.prepareStatement("select * from Users where email = ?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u = new User(); // Initialize yaha karna hai taaki agar user exist karta hai tab hi User Class ka instance bane
				u.setEmail(rs.getString("email"));
				u.setPass(rs.getString("password"));
				u.setRole(rs.getString("role"));
			}
			return u;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in Checking User Details");
			e.printStackTrace();
		}
		return null;
	}
	
}
