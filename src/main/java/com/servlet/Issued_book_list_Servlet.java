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
import com.db.RecenIssuesDB;
import com.pojo.Book;
import com.pojo.RecentIssues;

/**
 * Servlet implementation class Issued_book_list_Servlet
 */
@WebServlet("/Issued_book_list_Servlet")
public class Issued_book_list_Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String regno = null;
		String name = null;
		Cookie cookies[] = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("regno")) {
				regno = cookie.getValue();
				System.out.println(regno);
			}
			if(cookie.getName().equals("name")) {
				name = cookie.getValue();
				System.out.println(name);
			}
		}
		
		RecenIssuesDB ridb = new RecenIssuesDB();
		ArrayList<RecentIssues> ri = ridb.getIssueInfo(regno);
		if(ri==null) {
			RequestDispatcher rd = request.getRequestDispatcher("/private/student/return-book.jsp");
			rd.forward(request, response);
			return;
		}
		
		BookDB bdb = new BookDB();
		ArrayList<Book> bl = bdb.getBooks();
		
		if(bl == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/private/student/return-book.jsp");
			rd.forward(request, response);
			return;
		}
		
		request.setAttribute("name", name);
		request.setAttribute("regno", regno);
		request.setAttribute("ri", ri);
		request.setAttribute("bl", bl);
		
		RequestDispatcher rd = request.getRequestDispatcher("/private/student/return-book.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
