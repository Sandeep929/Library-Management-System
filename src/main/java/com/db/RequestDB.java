package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.IssueRequest;



public class RequestDB {
	
	Connection con = null;
	public RequestDB() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(System.getenv("DB_URL"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<IssueRequest> getRequest(){
		ArrayList<IssueRequest> ir = new ArrayList<IssueRequest>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from request");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				IssueRequest r = new IssueRequest();
				r.setS_name(rs.getString("s_name"));
				r.setRegno(rs.getString("regno"));
				r.setB_name(rs.getString("b_name"));
				r.setIsbn(rs.getString("isbn"));
				
				ir.add(r);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ir;
	}
	
	public boolean deleteRequest(IssueRequest ir) {
		boolean b = false;
		
		try {
			PreparedStatement ps = con.prepareStatement("Delete from request where regno = ? and isbn = ?");
			ps.setString(1, ir.getRegno());
			ps.setString(2, ir.getIsbn());
			
			
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
