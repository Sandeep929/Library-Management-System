<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library-Management-System </title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
	<%
	Cookie cookies[] = request.getCookies();
	String username = null;
	
	for (Cookie cookie : cookies) {
		if(cookie.getName().equals("username")) {
			username = cookie.getValue();
		}
	}
	%>
	<div class="container">
    <div class="header">
      <div class="logo">📚 Library Management System</div>
      <div class="small"><%= username %></div>
    </div>
    <div class="layout">
      
      <main class="main">
        <div class="card" style="max-width:480px;margin:40px auto;">
		  <div style="text-align:center;margin-bottom:12px;">
		    <div style="display:inline-block;background:#e0f2ff;padding:12px;border-radius:999px;font-size:28px;">
		    <i class="fa-solid fa-user"></i>
		    </div>
		  </div>
		  <h2 style="text-align:center;margin:0 0 6px 0;">Add Student</h2>
		  <p class="small" style="text-align:center;margin-top:0;margin-bottom:12px;"></p>
		  <form action = "<%= request.getContextPath()%>/AddStudent">
		    <div class="form-group">
		      <label>Name</label>
		      <input class="input" type="text" name="name" />
		    </div>
		    <div class="form-group">
		      <label>Reg No.</label>
		      <input class="input" type="text" name="regNo" />
		    </div>
		    <div class="form-group">
		      <label>Phone</label>
		      <input class="input" type="text" name="phone" />
		    </div>
		    <div class="form-group">
		      <label>Email</label>
		      <input class="input" type="text" name="email" />
		    </div>
		    <div style="text-align:center;">
		      <button class="btn" type = "submit">Add</button>
		    </div>
		  </form>
		</div>
      </main>
    </div>
  </div>
</body>
</html>