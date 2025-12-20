package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

/**
 * Servlet implementation class OAuth_Google_Login_Servlet
 */
@WebServlet("/OAuth_Google_Login_Servlet")
public class OAuth_Google_Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String CLIENT_ID = System.getenv("CLIENT_ID");
	private static final String CLIENT_SECRET = System.getenv("CLIENT_SECRET");
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String CALLBACK_URL = "http://localhost:8080"+request.getContextPath()+"/OAuth_Google_Callback";
		System.out.println(CALLBACK_URL);
		
		final String CALLBACK_URL = "http://localhost:8080" + request.getContextPath() +"/OAuth_Google_Callback";
		
		OAuth20Service service = new ServiceBuilder(CLIENT_ID)
				.apiSecret(CLIENT_SECRET)
				.defaultScope("openid email profile")
				.callback(CALLBACK_URL)
				.build(GoogleApi20.instance());
		
		HttpSession session = request.getSession();
		session.setAttribute("oauth20Service", service);
		
		
		String authorizationUrl = service.getAuthorizationUrl();
		
		response.sendRedirect(authorizationUrl);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
