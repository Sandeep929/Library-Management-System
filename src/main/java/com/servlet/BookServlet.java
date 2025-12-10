package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.BookDB;
import com.pojo.Book;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDB bdb = new BookDB();
		ArrayList<Book> bl = bdb.getBooks();
		request.setAttribute("book_list", bl);
		String role = null;
		Cookie cookies[] = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("role")) {
				role = cookie.getValue();
			}
		}
		
		System.out.println(role);
		if(role.equals("student")) {
			RequestDispatcher rd = request.getRequestDispatcher("/private/student/books.jsp");
			rd.forward(request, response);
		}
		else if(role.equals("staff")) {
			RequestDispatcher rd = request.getRequestDispatcher("/private/staff/Sbooks.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
