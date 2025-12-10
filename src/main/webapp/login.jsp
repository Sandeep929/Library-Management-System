<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library-Management-System | Login</title>
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
	<div class="container">
    <div class="header">
      <div class="logo">📚 Library Management System</div>
      <div class="small">Admin</div>
    </div>
    <div class="layout">
      
      <main class="main">
        <div class="card" style="max-width:480px;margin:40px auto;">
		  <div style="text-align:center;margin-bottom:12px;">
		    <div style="display:inline-block;background:#e0f2ff;padding:12px;border-radius:999px;font-size:28px;">📘</div>
		  </div>
		  <h2 style="text-align:center;margin:0 0 6px 0;">Sign in</h2>
			
			<%
			String err = (String) request.getAttribute("Error");
			if(err != null){
				%>
				<p class="small" style="text-align:center;color:red;margin-top:0;margin-bottom:12px;"><%= err %></p>
				<%
			}
			%>
		  
		  <form action = "<%=request.getContextPath() %>/LoginServlet" method = "post">
		    <div class="form-group">
		      <label>Username</label>
		      <input class="input" type="text" name = "userID"  value="admin@gmail.com" />
		  	  <p class="small" style="text-align:center;margin-top:0;margin-bottom:12px;"></p>
		    </div>
		    <div class="form-group">
		      <label>Password</label>
		      <input class="input" type="password" name = "pass" value="123456" />
		    </div>
		    <div style="text-align:center;">
		      <button class = "btn" type="submit">Sign in</button>
		    </div>
		    
		  </form>
		</div>
      </main>
    </div>
  </div>
</body>
</html>