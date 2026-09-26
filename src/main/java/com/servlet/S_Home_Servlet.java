package com.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
 * Servlet implementation class S_Home_Servlet
 */
@WebServlet("/S_Home_Servlet")
public class S_Home_Servlet extends HttpServlet {
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int issued = 0;
		int overdue = 0;
		int dtw = 0;
		Cookie cookies[] = request.getCookies();
		String regno = null;
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("regno")) {
				regno = cookie.getValue();
			}
		}
		
		
		if(regno == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		RecenIssuesDB rdb = new RecenIssuesDB();
		ArrayList<RecentIssues> irl = rdb.getIssueInfo(regno);
		if(irl == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/private/student/home.jsp");
			rd.forward(request, response);
			return;
		}
		issued = irl.size();
		for (RecentIssues recentIssues : irl) {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			// Convert formatted String -> LocalDate
		    String dueDateStr = recentIssues.getDueDate(); // e.g. "14-01-2026"
		    LocalDate dueDate = LocalDate.parse(dueDateStr, fmt);
		    LocalDate today = LocalDate.now();
		    // Overdue?
		    if (dueDate.isBefore(today)) {
		        overdue++;
		    }

		    // Due This Week (within next 7 days)
		    if (!dueDate.isBefore(today) && dueDate.isBefore(today.plusDays(7))) {
		        dtw++;
		    }
		}
		
		BookDB bdb = new BookDB();
		ArrayList<Book> bl = bdb.getBooks();
		
		if(bl == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/private/student/home.jsp");
			rd.forward(request, response);
			return;
		}
		
		request.setAttribute("issued", issued);
		request.setAttribute("overdue", overdue);
		request.setAttribute("dtw", dtw);
		request.setAttribute("recent_issues", irl);
		request.setAttribute("book_list", bl);
		RequestDispatcher rdf = request.getRequestDispatcher("/private/student/home.jsp");
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
