package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.StudentDB;
import com.db.UserDB;
import com.jwt.JwtUtil;
import com.pojo.Student;
import com.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("userID");
		String pass = request.getParameter("pass");
		
		User u = new User();
		u.setEmail(email);
		u.setPass(pass);
		
		String name = null;
		
		UserDB dbs = new UserDB();
		
		User user = dbs.checkUser(u);
		
		if(user != null) {
			
			String token = JwtUtil.generateToken(user.getEmail(), user.getRole());
			
			System.out.println(token);
			
			
			Cookie jwtCookie = new Cookie("Token", token);
			Cookie role = new Cookie("role", user.getRole());
			Cookie regno = new Cookie("regno", user.getPass());
			Cookie username = new Cookie("username", user.getEmail());
			
			if(user.getRole().equals("student")) {
				StudentDB sdb = new StudentDB();
				Student s = new Student();
				s = sdb.searchStudent(u.getPass());
				name = s.getName();
				Cookie Sname = new Cookie("name", name);
				Sname.setPath("/");
				response.addCookie(Sname);
			}
			
			jwtCookie.setPath("/");
			role.setPath("/");
			regno.setPath("/");
			username.setPath("/");
			
			response.addCookie(jwtCookie);
			response.addCookie(role);
			response.addCookie(regno);
			response.addCookie(username);
			
			
			if(user.getRole().equals("student")) {
				response.sendRedirect(request.getContextPath()+"/S_Home_Servlet");
			}else {
				response.sendRedirect(request.getContextPath()+"/Staff_Dashboard_Servlet");
			}
		}else {
			System.out.println("Error in DBase");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
	}
			
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
