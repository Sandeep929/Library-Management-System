package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.Student;



public class StudentDB {
	
	Connection con = null;
	public StudentDB(){
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(System.getenv("DB_URL"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> getStudents(){
		ArrayList<Student> sl = new ArrayList<Student>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Student");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setRegNo(rs.getString("RegNo"));
				s.setName(rs.getString("Name"));
				s.setPhoneNo(rs.getString("PhoneNo"));
				s.setEmail(rs.getString("Email"));
				
				sl.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sl;
	}
	
	public boolean addStudent(Student s) {
		boolean b = false;
		
		try {
			PreparedStatement ps = con.prepareStatement("Insert into Student (Name, RegNo, PhoneNo, Email) values (?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getRegNo());
			ps.setString(3, s.getPhoneNo());
			ps.setString(4, s.getEmail());
			
			int count = ps.executeUpdate();
			if(count > 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b;
	}
}
