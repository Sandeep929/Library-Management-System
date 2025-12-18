package com.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.RecenIssuesDB;
import com.db.RequestDB;
import com.pojo.IssueRequest;
import com.pojo.RecentIssues;

/**
 * Servlet implementation class Manage_Book_Request_Servlet
 */
@WebServlet("/Manage_Book_Request_Servlet")
public class Manage_Book_Request_Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String regno = request.getParameter("regno");
		String isbn = request.getParameter("isbn");
		
		if(regno == null && isbn == null) {
			request.setAttribute("msg", "not parameter recieved");
			RequestDispatcher rd = request.getRequestDispatcher("/private/staff/issue-book.jsp");
			rd.forward(request, response);
		}
		
		IssueRequest ir = new IssueRequest();
		
		ir.setRegno(regno);
		ir.setIsbn(isbn);
		
		RequestDB rdb = new RequestDB();
		
		if(rdb.deleteRequest(ir)) {
				RequestDispatcher rd = request.getRequestDispatcher("/Show_Book_Requests_Servlet");
				rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String regno = request.getParameter("regno");
		String isbn = request.getParameter("isbn");
		
		if(regno == null && isbn == null) {
			request.setAttribute("msg", "not parameter recieved");
			RequestDispatcher rd = request.getRequestDispatcher("/private/staff/issue-book.jsp");
			rd.forward(request, response);
		}
		
		RecentIssues ri = new RecentIssues();
		IssueRequest ir = new IssueRequest();
		
		ri.setRegno(regno);
		ri.setIsbn(isbn);
		LocalDate today = LocalDate.now();
        LocalDate after30 = today.plusDays(30);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String issueDate = today.format(fmt);
        String dueDate = after30.format(fmt);
		ri.setIssueDate(issueDate);
		ri.setDueDate(dueDate);
		ri.setStatus("issued");
		
		ir.setRegno(regno);
		ir.setIsbn(isbn);
		
		RecenIssuesDB ridb = new RecenIssuesDB();
		RequestDB rdb = new RequestDB();
		
		if(rdb.deleteRequest(ir)) {
			if(ridb.addRIssues(ri)) {
				RequestDispatcher rd = request.getRequestDispatcher("/Show_Book_Requests_Servlet");
				rd.forward(request, response);
			}
		}
	}

}
