<%@page import="com.pojo.Student"%>
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
		  <h3 style="margin-top:0;">Students</h3>
		  <p style="display:<%= (String)request.getAttribute("Status") != null ? "block;" : "none;"%> color: blue;">${Status}</p>
		  <table class="table">
		    <thead><tr><th>Name</th><th>Reg No</th><th>Phone</th></tr></thead>
		    <tbody>
		    <%
		    	ArrayList<Student> sl = (ArrayList) request.getAttribute("stud_list");
		    	if(sl!=null){
		    	for(int i = 0; i<sl.size(); i++){
			%>		    		
		      <tr>
		    	<td><%= sl.get(i).getName() %></td>
		    	<td><%= sl.get(i).getRegNo() %></td>
		    	<td><%= sl.get(i).getPhoneNo() %></td>
		      </tr>
		    <%
		    	}
		    }
		     %>
		   	</tbody>
		  </table>
		  <div style="margin-top:12px;">
		    <a class="btn" href="<%=request.getContextPath() %>/private/staff/add-student.jsp">Add Student</a>
		  </div>
		</div>

      </main>
    </div>
  </div>

</body>
</html>