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
        <a class="nav-btn" href="<%=request.getContextPath()%>/private/student/home.jsp">
        <i class="fa-solid fa-table-columns"></i>&nbsp;Dashboard
    </a>
    <a class="nav-btn" href="<%=request.getContextPath()%>/private/student/books.jsp">
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
		  <h3 style="margin-top:0;">Search Books</h3>
		  <div style="display:flex;justify-content: space-between;margin-top:8px;margin-bottom:12px;">
		  	<p>View, Search</p>
		  </div>
		  
		  <div style="display:flex;gap:8px;margin-top:8px;margin-bottom:12px;">
		    <input class="input" placeholder="Search by title or author" />
		    <select class="select"><option>All categories</option><option>Computer Science</option></select>
		    <a class="btn" href="<%= request.getContextPath() %>/private/student/books.jsp">Search</a>
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
		      	<td>
		      	<%
					String msg = (String) request.getAttribute("msg");
					if(msg != null){
						%>
						<button class="btn" type="submit">Requested</button>
						<%
					}else{
						%>
						<form action="Issue_Request_Servlet">
			      		
			      			<input style="display: none;" name = "isbn" value = "<%= bl.get(i).getISBN()%>">
			      			<button class="btn" type="submit">Get Book</button>
		      			</form>
		      		<%
					}
				%>
		      		
		      	</td>
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