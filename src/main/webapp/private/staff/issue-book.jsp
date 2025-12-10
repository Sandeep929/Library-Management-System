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
    <a class="nav-btn" href="<%=request.getContextPath()%>/private/staff/issue-book.jsp">
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
		  <h3 style="margin-top:0;">Issue Book</h3>
		  <form>
		    <div class="form-group"><label>Student</label><select class="select"><option>Radhika P (18CS1001)</option></select></div>
		    <div class="form-group"><label>Book</label><select class="select"><option>Data Structures</option></select></div>
		    <div class="form-group"><label>Issue Date</label><input class="input" type="date" value="2025-12-01" /></div>
		    <div style="text-align:right;"><a class="btn" href="issue-book.html">Issue</a></div>
		  </form>
		</div>

      </main>
    </div>
  </div>
</body>
</html>