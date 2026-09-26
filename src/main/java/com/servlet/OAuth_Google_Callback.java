package com.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.StudentDB;
import com.db.UserDB;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.jwt.JwtUtil;
import com.pojo.Student;
import com.pojo.User;





/**
 * Servlet implementation class OAuth_Google_Callback
 */
@WebServlet("/OAuth_Google_Callback")
public class OAuth_Google_Callback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String USERINFO_URl = "https://www.googleapis.com/oauth2/v2/userinfo";
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession(false);
		 
	     if (session == null) {
	         response.sendRedirect(request.getContextPath() + "/login.jsp");
	         return;
	     }
	     
	     OAuth20Service service = (OAuth20Service) session.getAttribute("oauth20Service");
	        if (service == null) {
	            response.sendRedirect(request.getContextPath() + "/login.jsp");
	            return;
	        }
	        
	        String code = request.getParameter("code");
	        if (code == null) {
	            response.getWriter().write("Code not received");
	            return;
	        }
	        
	        try {
	        	OAuth2AccessToken accessToken = service.getAccessToken(code);
	        	
	        	OAuthRequest oauthReq = new OAuthRequest(Verb.GET, USERINFO_URl);
	        	
	        	service.signRequest(accessToken, oauthReq);
	        	
	        	Response oauthRes = service.execute(oauthReq);
	        	
	        	String body = oauthRes.getBody();
	        	
	        	ObjectMapper mapper = new ObjectMapper();
	        	
	        	JsonNode node = mapper.readTree(body);
	        	
	        	String email = node.has("email") ? node.get("email").asText() : null;
	        	
	        	String name = node.has("name") ? node.get("name").asText() : null;
	        	
	        	if(email == null) {
	        		response.getWriter().write("Email not found");
	                return;
	        	}
	        	
	        	UserDB u = new UserDB();
	        	
	        	User u1 = u.getUserRole(email);
	        	
	        	if(u1 == null) {
	        		String value = URLEncoder.encode("User does not exist");
	        		Cookie cookie = new Cookie("response", value);
	        		response.addCookie(cookie);
	        		response.sendRedirect(request.getContextPath()+"/login.jsp");
	        		return;
	        	}
	        	
	        	String r = u1.getRole();
	        	
	        	String token = JwtUtil.generateToken(email, r);
	        	
	        	Cookie jwtCookie = new Cookie("AUTH_TOKEN", token);
	        	Cookie role = new Cookie("role", u1.getRole());
				Cookie regno = new Cookie("regno", u1.getPass());
				Cookie username = new Cookie("username", u1.getEmail());
				
				if(u1.getRole().equals("student")) {
					StudentDB sdb = new StudentDB();
					Student s = new Student();
					s = sdb.searchStudent(u1.getPass());
					name = s.getName();
					String value = URLEncoder.encode(name);
					Cookie Sname = new Cookie("name", value);
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
	           
	            
	            if(r.equals("student")) {
					response.sendRedirect(request.getContextPath()+"/S_Home_Servlet");
				}else {
					response.sendRedirect(request.getContextPath()+"/Staff_Dashboard_Servlet");
				}
	            
	        }catch (Exception e) {
	            throw new ServletException("Error during Google OAuth callback", e);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
