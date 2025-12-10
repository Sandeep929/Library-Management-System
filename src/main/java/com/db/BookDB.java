package com.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojo.Book;
import com.pojo.Student;

public class BookDB {
	
	Connection con = null;
	public BookDB() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(System.getenv("DB_URL"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<Book> getBooks(){
		ArrayList<Book> bl = new ArrayList<Book>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from books");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setTitle(rs.getString("Title"));
				b.setAuthor(rs.getString("Author"));
				b.setISBN(rs.getString("ISBN"));
				b.setCategory(rs.getString("Category"));
				b.setAvailavble(rs.getString("Available"));
				
				bl.add(b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bl;
	}
	

	public Book getBook(String isbn) {
		Book b = new Book();
		try {
			PreparedStatement ps = con.prepareStatement("select * from books where isbn = ?");
			ps.setString(1, isbn);
			
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				
				b.setAuthor(rs.getString("author"));
				b.setAvailavble(rs.getString("available"));
				b.setCategory(rs.getString("category"));
				b.setISBN(rs.getString("isbn"));
				b.setTitle(rs.getString("title"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean addBook(Book book) {
		boolean b = false;
		
		try {
			PreparedStatement ps = con.prepareStatement("Insert into books (Title, Author, ISBN, Category, Available) values (?,?,?,?,?)");
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getISBN());
			ps.setString(4, book.getCategory());
			ps.setInt(5, Integer.parseInt(book.getAvailavble()));
			
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

	
	public Student getStudent(String regno) {
		Student s = new Student();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Student where RegNo = ?");
			ps.setString(1, regno);
			
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				
				s.setName(rs.getString("name"));
				s.setRegNo(rs.getString("RegNO"));
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return s;
	}
	
	
	
	public boolean storeRequest(Book b, Student s) {
		try {
			PreparedStatement ps = con.prepareStatement("Insert into Request (s_name,RegNo,b_name,ISBN,Available) values s_name = ?, RegNo =?, b_name=?, ISBN = ?, Available = ? ");
			
			ps.setString(1, s.getName());
			ps.setString(2, s.getRegNo());
			ps.setString(3, b.getTitle());
			ps.setString(4, b.getISBN());
			ps.setString(5, b.getAvailavble());
			
			int x = ps.executeUpdate();
			System.out.println(x);
			if(x > 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

}
