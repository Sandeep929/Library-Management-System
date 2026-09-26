<<<<<<< HEAD
=======
<%@page import="com.pojo.RecentIssues"%>
<%@page import="com.pojo.Book"%>
<%@page import="java.util.ArrayList"%>
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
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
<<<<<<< HEAD
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
=======

<%@include file="header.jsp" %>
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
    
      <main class="main">
        
		<div class="card">
		  <h3 style="margin-top:0;">Return Book</h3>
<<<<<<< HEAD
		  <form>
		    <div class="form-group"><label>Loan</label>
		      <select class="select">
		        <option>Radhika P — Introduction to Java (Issued 2025-11-28)</option>
		      </select>
		    </div>
		    <div style="text-align:right;"><a class="btn" href="return-book.html">Return</a></div>
=======
		  <p style="color: blue;">${status}</p>
		  <form action="<%=request.getContextPath()%>/ReturnBookServlet">
		    <div class="form-group"><label>Loan</label>
		      <select name = "return_book" class="select">
		      	<%
		      		String Aname = (String) request.getAttribute("name");
		      		String name = URLDecoder.decode(Aname, "UTF-8");
		      		ArrayList<Book> bl = (ArrayList<Book>) request.getAttribute("bl");
		      		ArrayList<RecentIssues> ril = (ArrayList<RecentIssues>) request.getAttribute("ri");
		      		if(ril != null && bl != null && ril.size() > 0 && bl.size() > 0){
		      		for(RecentIssues ri : ril){
		      			for(Book b : bl){
		      				if(ri.getIsbn().equals(b.getISBN())){
		        			%>
		        			<option value ="<%=b.getISBN()%>"><%= name %> — <%= b.getTitle() %> (Due Date <%= ri.getDueDate() %>)</option>
		        			<%
		      					}
		      				}
		      			}
		      		}else{
		      			%>
	        			<option value = "null">Empty</option>
	        			<%
		      		}
		        %>
		      </select>
		    </div>
		    <div style="text-align:right;"><button type="submit" class="btn" >Return</button></div>
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
		  </form>
		</div>

      </main>
    </div>
  </div>
</body>
</html>