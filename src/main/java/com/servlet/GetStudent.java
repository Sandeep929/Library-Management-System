package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.db.StudentDB;
import com.pojo.Student;


/**
 * Servlet implementation class GetStudent
 */
@WebServlet("/GetStudent")
public class GetStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDB sdb = new StudentDB();
		ArrayList<Student> sl = sdb.getStudents();
		request.setAttribute("stud_list", sl);
		
			RequestDispatcher rd = request.getRequestDispatcher("/private/staff/students.jsp");
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
