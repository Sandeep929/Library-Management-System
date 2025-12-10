package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.BookDB;
import com.pojo.Book;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		String category = request.getParameter("category");
		String quantity = request.getParameter("quantity");
		
		Book b = new Book();
		b.setTitle(title);
		b.setAuthor(author);
		b.setISBN(isbn);
		b.setCategory(category);
		b.setAvailavble(quantity);
		
		BookDB bdb = new BookDB();
		if(bdb.addBook(b)) {
			request.setAttribute("Status", "Book Added Sucessfully");
			RequestDispatcher rd = request.getRequestDispatcher("/BookServlet");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("Status", "Book not Added");
			RequestDispatcher rd = request.getRequestDispatcher("/BookServlet");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
