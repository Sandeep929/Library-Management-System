package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.Dashboard;
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
	

	public boolean deleteRIssues(RecentIssues ri) {
		boolean b = false;
		
		try {
			PreparedStatement ps = con.prepareStatement("Delete from recent_issues where regno = ? and isbn = ?");
			ps.setString(1, ri.getRegno());
			ps.setString(2, ri.getIsbn());
			
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
	
	public ArrayList<Dashboard> getIssueDetails() {
		ArrayList<Dashboard> rl = new ArrayList<Dashboard>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select name, title, issuedate, duedate, status"
														+ " from recent_issues"
														+ " INNER JOIN student on recent_issues.regno = student.regno"
														+ " INNER JOIN books on recent_issues.isbn = books.isbn");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Dashboard d = new Dashboard();
				d.setName(rs.getString("name"));
				d.setB_name(rs.getString("title"));
				d.setIssueDate(rs.getString("issuedate"));
				d.setDueDate(rs.getString("duedate"));
				d.setStatus(rs.getString("status"));
				
				rl.add(d);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in getting Dashboard Information");
			e.printStackTrace();
		}
		
		return rl;
	}

}
	
