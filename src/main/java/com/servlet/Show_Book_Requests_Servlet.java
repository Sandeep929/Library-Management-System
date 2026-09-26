package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.BookDB;
import com.db.RequestDB;
import com.pojo.Book;
import com.pojo.IssueRequest;

/**
 * Servlet implementation class Issue_Book_Servlet
 */
@WebServlet("/Show_Book_Requests_Servlet")
public class Show_Book_Requests_Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDB rdb = new RequestDB();
		ArrayList<IssueRequest> irl = rdb.getRequest();
		if(irl == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/private/staff/issue-book.jsp");
			rd.forward(request, response);
			return;
		}
		BookDB bdb = new BookDB();
		ArrayList<Book> bl = bdb.getBooks();
		
		if(bl == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/private/staff/issue-book.jsp");
			rd.forward(request, response);
			return;
		}
		
		request.setAttribute("request_list", irl);
		request.setAttribute("book_list", bl);
		RequestDispatcher rdf = request.getRequestDispatcher("/private/staff/issue-book.jsp");
		rdf.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
