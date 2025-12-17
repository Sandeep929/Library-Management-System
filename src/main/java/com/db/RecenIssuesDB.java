package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.RecentIssues;
import com.pojo.Student;


public class RecenIssuesDB {

	Connection con = null;
	public RecenIssuesDB() {
		super();
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(System.getenv("DB_URL"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<RecentIssues> getIssueInfo(String regno){
		ArrayList<RecentIssues> il = new ArrayList<RecentIssues>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from recent_issues where regno = ?");
			ps.setString(1, regno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RecentIssues ri = new RecentIssues();
				ri.setIsbn(rs.getString("isbn"));
				ri.setDueDate(rs.getString("duedate"));
				il.add(ri);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return il;
	}
	
	
	public ArrayList<RecentIssues> getIssueInfo(){
		ArrayList<RecentIssues> il = new ArrayList<RecentIssues>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from recent_issues");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RecentIssues ri = new RecentIssues();
				ri.setIsbn(rs.getString("isbn"));
				ri.setDueDate(rs.getString("duedate"));
				il.add(ri);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return il;
	}
	
	public boolean addRIssues(RecentIssues ri) {
		boolean b = false;
		
		try {
			PreparedStatement ps = con.prepareStatement("Insert into recent_issues (regno, isbn, issuedate, duedate, status) values (?,?,?,?,?)");
			ps.setString(1, ri.getRegno());
			ps.setString(2, ri.getIsbn());
			ps.setString(3, ri.getIssueDate());
			ps.setString(4, ri.getDueDate());
			ps.setString(5, ri.getStatus());
			
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
	
<<<<<<< HEAD
	public boolean deleteRIssues(RecentIssues ri) {
		boolean b = false;
		
		try {
			PreparedStatement ps = con.prepareStatement("Delete from recent_issues where regno = ? and isbn = ?");
			ps.setString(1, ri.getRegno());
			ps.setString(2, ri.getIsbn());
			
			int count = ps.executeUpdate();
			if(count > 0) {
				b = true;
=======
	public ArrayList<RecentIssues> getIssueBook(){
		ArrayList<RecentIssues> il = new ArrayList<RecentIssues>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from recent_issues");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RecentIssues ri = new RecentIssues();
				ri.setIsbn(rs.getString("isbn"));
				ri.setDueDate(rs.getString("duedate"));
				il.add(ri);
>>>>>>> aafb070ef23f9599fff1b2c787b1f79da5de1ca2
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		return b;
	}
=======
		return il;
	}
	
	
>>>>>>> aafb070ef23f9599fff1b2c787b1f79da5de1ca2
}
