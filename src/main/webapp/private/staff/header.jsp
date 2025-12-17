<div class="container">
	<%
	Cookie cookies[] = request.getCookies();
	String username = null;
	
	for (Cookie cookie : cookies) {
		if(cookie.getName().equals("username")) {
			username = cookie.getValue();
		}
	}
	%>
    <div class="header">
      <div class="logo">📚 Library Management System</div>
      <div class="small"><%= username %></div>
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