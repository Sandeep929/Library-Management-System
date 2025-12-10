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
    <a class="nav-btn" href="<%=request.getContextPath()%>/private/student/home.jsp">
        <i class="fa-solid fa-table-columns"></i>&nbsp;Dashboard
    </a>
    <a class="nav-btn" href="<%=request.getContextPath()%>/BookServlet">
        <i class="fa-solid fa-book"></i>&nbsp;Books
    </a>
    
    <a class="nav-btn" href="<%=request.getContextPath()%>/private/student/return-book.jsp">
        <i class="fa-solid fa-book-bookmark"></i>&nbsp;Return Book
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

      </main>
    </div>
 
  </div>
</body>
</html>