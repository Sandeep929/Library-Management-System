<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library-Management-System</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<div class="container">
    <div class="header">
      <div class="logo">📚 Library Management System</div>
      <div class="small">Admin</div>
    </div>
    <div class="layout">
      
      <aside class="sidebar">
    <a class="nav-btn" href="<%=request.getContextPath()%>/private/staff/shome.jsp">
        <i class="fa-solid fa-table-columns"></i>&nbsp;Dashboard
    </a>
    <a class="nav-btn" href="<%=request.getContextPath()%>/BookServlet">
        <i class="fa-solid fa-book"></i>&nbsp;Books
    </a>
    <a class="nav-btn" href="<%=request.getContextPath()%>/Show_Book_Requests_Servlet">
        <i class="fa-solid fa-book-open"></i>&nbsp;Issue Book
    </a>
    <a class="nav-btn" href="<%=request.getContextPath()%>/GetStudent">
        <i class="fa-solid fa-users"></i>&nbsp;Students
    </a>
    <a style="color:red" class="nav-btn" href="<%=request.getContextPath()%>/LogOut">
        <i class="fa-solid fa-right-from-bracket"></i>&nbsp;Logout
    </a>
</aside>
    
      <main class="main">
        
		<div class="card">
		  <h3 style="margin-top:0;">Dashboard</h3>
		  <p class="small">Quick stats</p>
		  <div style="display:flex;gap:12px;margin-top:12px;">
		    <div style="flex:1;padding:12px;border-radius:8px;background:#f1f8ff;">
		      <div style="font-weight:700;font-size:18px;">124</div>
		      <div class="small">Total Books</div>
		    </div>
		    <div style="flex:1;padding:12px;border-radius:8px;background:#fefce8;">
		      <div style="font-weight:700;font-size:18px;">38</div>
		      <div class="small">Issued</div>
		    </div>
		    <div style="flex:1;padding:12px;border-radius:8px;background:#eef2f7;">
		      <div style="font-weight:700;font-size:18px;">86</div>
		      <div class="small">Available</div>
		    </div>
		  </div>
		</div>
		
		<div class="card">
		  <h4 style="margin-top:0;">Recent Issues</h4>
		  <table class="table">
		    <thead><tr><th>User</th><th>Book</th><th>Issue Date</th><th>Due</th><th>Status</th></tr></thead>
		    <tbody>
		      <tr><td>Radhika P</td><td>Introduction to Java</td><td>2025-11-28</td><td>2025-12-12</td><td><span class="badge">Issued</span></td></tr>
		      <tr><td>Aman S</td><td>Data Structures</td><td>2025-11-20</td><td>2025-12-04</td><td><span class="badge">Overdue</span></td></tr>
		    </tbody>
		  </table>
		</div>

      </main>
    </div>
 
  </div>
</body>
</html>