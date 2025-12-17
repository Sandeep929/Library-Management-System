<%@page import="com.pojo.RecentIssues"%>
<%@page import="com.pojo.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library-Management-System</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="logo">📚 Library Management System</div>
			<div class="small">Admin</div>
		</div>
		<div class="layout">

			<aside class="sidebar">
				<a class="nav-btn"
					href="<%=request.getContextPath()%>/S_Home_Servlet">
					<i class="fa-solid fa-table-columns"></i>&nbsp;Dashboard
				</a> <a class="nav-btn" href="<%=request.getContextPath()%>/BookServlet">
					<i class="fa-solid fa-book"></i>&nbsp;Books
				</a> <a class="nav-btn"
					href="<%=request.getContextPath()%>/Issued_book_list_Servlet">
					<i class="fa-solid fa-book-bookmark"></i>&nbsp;Return Book
				</a> <a style="color: red" class="nav-btn"
					href="<%=request.getContextPath()%>/LogOut"> <i
					class="fa-solid fa-right-from-bracket"></i>&nbsp;Logout
				</a>
			</aside>

			<main class="main">
			
			<%
				Integer I = (Integer) request.getAttribute("issued");
				Integer o = (Integer) request.getAttribute("overdue");
				Integer dtw = (Integer) request.getAttribute("det");
			%>
			
				<div class="card">
					<h3 style="margin-top: 0;">Dashboard</h3>
					<p class="small">Quick stats</p>
					<div style="display: flex; gap: 12px; margin-top: 12px;">
						<div
							style="flex: 1; padding: 12px; border-radius: 8px; background: #f1f8ff;">
							<div style="font-weight: 700; font-size: 18px;"><%= I != null? I.intValue():"0" %></div>
							<div class="small">Issued Books</div>
						</div>
						<div
							style="flex: 1; padding: 12px; border-radius: 8px; background: #fefce8;">
							<div style="font-weight: 700; font-size: 18px;"><%= o != null? o.intValue():"0" %></div>
							<div class="small">Due this week</div>
						</div>
						<div
							style="flex: 1; padding: 12px; border-radius: 8px; background: #eef2f7;">
							<div style="font-weight: 700; font-size: 18px;"><%= dtw != null? dtw.intValue():"0" %></div>
							<div class="small">Overdue</div>
						</div>
					</div>
				</div>

				<table class="table">
					<thead>
						<tr>
							<th>Title</th>
							<th>Author</th>
							<th>Category</th>
							<th>ISBN</th>
							<th>Due Date</th>
						</tr>
					</thead>
					<tbody>
						<%
				ArrayList<RecentIssues> ril = (ArrayList<RecentIssues>) request.getAttribute("recent_issues");
		    	ArrayList<Book> bl = (ArrayList<Book>)request.getAttribute("book_list");
		    	if(ril != null && bl != null && ril.size() > 0 && bl.size() > 0){
		    	for(int i = 0; i<ril.size(); i++){
					%>
						<tr>
						<%
							for(Book b : bl){
								if(b.getISBN().equals(ril.get(i).getIsbn())){
									%>
								<td><%= b.getTitle() %></td>
								<td><%= b.getAuthor() %></td>
								<td><%= b.getCategory() %></td>					
								<%
								}
							}
						%>
							<td><%= ril.get(i).getIsbn() %></td>
							<td><%= ril.get(i).getDueDate() %></td>
						</tr>
						<%
		      }
		    	}else{
		    		%>
						<tr>
							<td colspan="5"
								style="text-align: center; padding: 10px; font-size: 0.9em; color: #6b6b6b; background: #f7f7f8; border: 1px dashed #e0e0e0; border-radius: 6px; font-style: italic;">
								Not available</td>
						</tr>
						<%
		    	}
		     %>
					</tbody>
				</table>

			</main>
		</div>

	</div>
</body>
</html>