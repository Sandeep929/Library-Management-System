package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.StudentDB;
import com.pojo.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String phno = request.getParameter("phone");
		String regno = request.getParameter("regNo");
		String email = request.getParameter("email");
		
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		s.setPhoneNo(phno);
		s.setRegNo(regno);
		
		StudentDB sdb = new StudentDB();
		
		if(sdb.addStudent(s)) {
			request.setAttribute("Status", "Student Added Sucessfully");
			RequestDispatcher rd = request.getRequestDispatcher("/GetStudent");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("Status", "Student not added");
			RequestDispatcher rd = request.getRequestDispatcher("/GetStudent");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
