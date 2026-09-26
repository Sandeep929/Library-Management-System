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
import com.db.RecenIssuesDB;
import com.pojo.Book;
import com.pojo.Dashboard;
import com.pojo.RecentIssues;

/**
 * Servlet implementation class Staff_Dashboard_Servlet
 */
@WebServlet("/Staff_Dashboard_Servlet")
public class Staff_Dashboard_Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		BookDB bdb = new BookDB();
		RecenIssuesDB rdb = new RecenIssuesDB();
		
		int counts[] = bdb.getBooksCounts();
		
		ArrayList<Dashboard> rl = rdb.getIssueDetails();
		if(rl == null) {
			System.out.println("Dashboard info is null");
			RequestDispatcher rdf = request.getRequestDispatcher("/private/staff/shome.jsp");
			rdf.forward(request, response);
			return;
		}
		
		request.setAttribute("d_list", rl);
		request.setAttribute("tatBooks", counts[0]);
		request.setAttribute("issBooks", counts[1]);
		request.setAttribute("availBooks", counts[2]);
		
		RequestDispatcher rdf = request.getRequestDispatcher("/private/staff/shome.jsp");
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
