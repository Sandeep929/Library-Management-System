package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.UserDB;
import com.jwt.JwtUtil;
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
		
		UserDB dbs = new UserDB();
		
		User user = dbs.checkUser(u);
		
		if(user != null) {
			
			String token = JwtUtil.generateToken(user.getEmail(), user.getRole());
			
			System.out.println(token);
			
			Cookie jwtCookie = new Cookie("Token", token);
			Cookie role = new Cookie("role", user.getRole());
			Cookie regno = new Cookie("regno", user.getPass());
			
			jwtCookie.setPath("/");
			role.setPath("/");
			regno.setPath("/");
			
			response.addCookie(jwtCookie);
			response.addCookie(role);
			response.addCookie(regno);
			
			
			if(user.getRole().equals("student")) {
				response.sendRedirect(request.getContextPath()+"/S_Home_Servlet");
			}else {
				response.sendRedirect(request.getContextPath()+"/private/staff/shome.jsp");
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
