<%@page import="com.pojo.Book"%>
<%@page import="java.util.ArrayList"%>
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
        <p style="display:<%= (String)request.getAttribute("Status") != null ? "block;" : "none;"%> color: blue;">${Status}</p>
		<div class="card">
		  <h3 style="margin-top:0;">Books Management</h3>
		  <div style="display:flex;justify-content: space-between;margin-top:8px;margin-bottom:12px;">
		  	<p>Add, view, search, and manage books</p>
		  	<a class="btn" href="<%=request.getContextPath()%>/private/staff/add-books.jsp"><i class="fa-regular fa-plus"></i>&nbsp;Add New Book</a>
		  </div>
		  
		  <div style="display:flex;gap:8px;margin-top:8px;margin-bottom:12px;">
		    <input class="input" placeholder="Search by title or author" />
		    <select class="select"><option>All categories</option><option>Computer Science</option></select>
		    <a class="btn" href="<%=request.getContextPath()%>/private/staff/Sbooks.jsp">Search</a>
		  </div>
		  
		  <table class="table">
		    <thead><tr><th>Title</th><th>Author</th><th>ISBN</th><th>Category</th><th>Available</th></tr></thead>
		    <tbody>    
		    <%
		    	ArrayList<Book> bl = (ArrayList)request.getAttribute("book_list");
		    	if(bl != null){
		    	for(int i = 0; i<bl.size(); i++){
					%>		      
		    	<tr>
		      	<td><%= bl.get(i).getTitle() %></td>
		      	<td><%= bl.get(i).getAuthor() %></td>
		      	<td><%= bl.get(i).getISBN() %></td>
		      	<td><%= bl.get(i).getCategory() %></td>
		      	<td><%= bl.get(i).getAvailavble() %></td>
		      </tr>
		      <%
		      }
		    	}
		     %>
		    </tbody>
		  </table>
		  
		</div>

      </main>
    </div>
  </div>
</body>
</html>