package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.RecenIssuesDB;
import com.pojo.RecentIssues;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Reached Return Book Servlet");
		String regno = null;
		Cookie cookies[] = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("regno")) {
				regno = cookie.getValue();
				System.out.println(regno);
			}
		}
		
		String isbn = request.getParameter("return_book");
		if(isbn.equals("null")) {
			request.setAttribute("status", "List is empty");
			RequestDispatcher rd = request.getRequestDispatcher("/private/student/return-book.jsp");
			rd.forward(request, response);
			return;
		}
		RecentIssues ri = new RecentIssues();
		ri.setIsbn(isbn);
		ri.setRegno(regno);
		
		RecenIssuesDB ridb = new RecenIssuesDB();
		if(ridb.deleteRIssues(ri)) {
			request.setAttribute("status", "Returned");
			RequestDispatcher rd = request.getRequestDispatcher("/Issued_book_list_Servlet");
			rd.forward(request, response);
			return;
		}
		else {
			request.setAttribute("status", "Not able to return");
			RequestDispatcher rd = request.getRequestDispatcher("/Issued_book_list_Servlet");
			rd.forward(request, response);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
