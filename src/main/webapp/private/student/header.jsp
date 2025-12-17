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
				<a class="nav-btn"
					href="<%=request.getContextPath()%>/S_Home_Servlet">
					<i class="fa-solid fa-table-columns"></i>&nbsp;Dashboard
				</a> <a class="nav-btn" href="<%=request.getContextPath()%>/BookServlet">
					<i class="fa-solid fa-book"></i>&nbsp;Books
				</a> <a class="nav-btn"
					href="<%=request.getContextPath()%>/private/student/return-book.jsp">
					<i class="fa-solid fa-book-bookmark"></i>&nbsp;Return Book
				</a> <a style="color: red" class="nav-btn"
					href="<%=request.getContextPath()%>/LogOut"> <i
					class="fa-solid fa-right-from-bracket"></i>&nbsp;Logout
				</a>
			</aside>