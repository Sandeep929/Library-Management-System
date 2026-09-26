package com.servlet;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.net.URLEncoder;

>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
import com.db.UserDB;
import com.jwt.JwtUtil;
=======
import com.db.StudentDB;
import com.db.UserDB;
import com.jwt.JwtUtil;
import com.pojo.Student;
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
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
		
<<<<<<< HEAD
=======
		String name = null;
		
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
		UserDB dbs = new UserDB();
		
		User user = dbs.checkUser(u);
		
		if(user != null) {
			
			String token = JwtUtil.generateToken(user.getEmail(), user.getRole());
			
			System.out.println(token);
			
<<<<<<< HEAD
			Cookie jwtCookie = new Cookie("Token", token);
			Cookie role = new Cookie("role", user.getRole());
			Cookie regno = new Cookie("regno", user.getPass());
=======
			
			Cookie jwtCookie = new Cookie("Token", token);
			Cookie role = new Cookie("role", user.getRole());
			Cookie regno = new Cookie("regno", user.getPass());
			Cookie username = new Cookie("username", user.getEmail());
			
			if(user.getRole().equals("student")) {
				StudentDB sdb = new StudentDB();
				Student s = new Student();
				s = sdb.searchStudent(u.getPass());
				name = s.getName();
				String value = URLEncoder.encode(name, "UTF-8");
				Cookie Sname = new Cookie("name", value);
				Sname.setPath("/");
				response.addCookie(Sname);
			}
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
			
			jwtCookie.setPath("/");
			role.setPath("/");
			regno.setPath("/");
<<<<<<< HEAD
=======
			username.setPath("/");
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
			
			response.addCookie(jwtCookie);
			response.addCookie(role);
			response.addCookie(regno);
<<<<<<< HEAD
			
			
			if(user.getRole().equals("student")) {
				response.sendRedirect(request.getContextPath()+"/private/student/home.jsp");
			}else {
				response.sendRedirect(request.getContextPath()+"/private/staff/shome.jsp");
=======
			response.addCookie(username);
			
			
			if(user.getRole().equals("student")) {
				response.sendRedirect(request.getContextPath()+"/S_Home_Servlet");
			}else {
				response.sendRedirect(request.getContextPath()+"/Staff_Dashboard_Servlet");
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
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
