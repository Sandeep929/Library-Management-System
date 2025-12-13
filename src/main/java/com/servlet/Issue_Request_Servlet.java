package com.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.BookDB;
import com.pojo.Book;
import com.pojo.Student;

/**
 * Servlet implementation class Issue_Request_Servlet
 */
@WebServlet("/Issue_Request_Servlet")
public class Issue_Request_Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String isbn = request.getParameter("isbn");
		
		BookDB bdb = new BookDB();
		
		Book b =  bdb.getBook(isbn);
		
		String regno = null;
		
		Cookie cookies[] = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("regno")) {
				regno = cookie.getValue();
				System.out.println(regno);
			}
		}
		
		Student s = bdb.getStudent(regno);
		System.out.println(s.getName());
		if(bdb.storeRequest(b, s)) {
			request.setAttribute("msg", "Requested");
			request.setAttribute("ISBN", isbn);
			RequestDispatcher rd = request.getRequestDispatcher("/BookServlet");
			rd.forward(request, response);
		}else {
			System.out.println("Not Store in DB");
			RequestDispatcher rd = request.getRequestDispatcher("/BookServlet");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
