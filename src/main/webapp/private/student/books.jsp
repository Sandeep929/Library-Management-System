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
=======
<%@include file="header.jsp" %>
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
    
      <main class="main">
        
		<div class="card">
		  <h3 style="margin-top:0;">Search Books</h3>
		  <div style="display:flex;justify-content: space-between;margin-top:8px;margin-bottom:12px;">
		  	<p>View, Search</p>
		  </div>
		  
		  <div style="display:flex;gap:8px;margin-top:8px;margin-bottom:12px;">
<<<<<<< HEAD
		    <input class="input" placeholder="Search by title or author" />
		    <select class="select"><option>All categories</option><option>Computer Science</option></select>
		    <a class="btn" href="<%= request.getContextPath() %>/private/student/books.jsp">Search</a>
		  </div>
		  
		  <table class="table">
=======
		    <input type="text" class="input" id="searchInput" placeholder="Search by title or author" />
		    <button class="btn" onclick="searchBooks()">Search</button>
		  </div>
		  
		  <table id = "bookTable" class="table">
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
		    <thead><tr><th>Title</th><th>Author</th><th>ISBN</th><th>Category</th><th>Available</th></tr></thead>
		    <tbody>
		    <%
		    	ArrayList<Book> bl = (ArrayList)request.getAttribute("book_list");
		    	if(bl != null){
		    	for(int i = 0; i<bl.size(); i++){
<<<<<<< HEAD
=======
		    		int bookCount = Integer.parseInt(bl.get(i).getAvailavble());
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
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
<<<<<<< HEAD
					if(msg != null){
						%>
						<button class="btn" type="submit">Requested</button>
						<%
=======
					String isbn = (String) request.getAttribute("ISBN");
					if(msg != null && isbn != null){
						if(bl.get(i).getISBN().equals(isbn)){
						%>
						<button class="btn" type="submit">Requested</button>
						<%
						}
						else{
							%>
							<form action="Issue_Request_Servlet">
				      		
				      			<input style="display: none;" name = "isbn" value = "<%= bl.get(i).getISBN()%>">
				      			<button <%= bookCount == 0 ? "disabled=\"disabled\"": "" %> style="min-width: 85px;" class="btn" type="submit">Get Book</button>
			      			</form>
			      		<%
						}
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
					}else{
						%>
						<form action="Issue_Request_Servlet">
			      		
			      			<input style="display: none;" name = "isbn" value = "<%= bl.get(i).getISBN()%>">
<<<<<<< HEAD
			      			<button class="btn" type="submit">Get Book</button>
=======
			      			<button <%= bookCount == 0 ? "disabled=\"disabled\"": "" %> style="min-width: 85px;" class="btn" type="submit">Get Book</button>
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
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
<<<<<<< HEAD
=======
  <script>
function searchBooks() {
    let input = document.getElementById("searchInput").value.toLowerCase();
    let rows = document.querySelectorAll("#bookTable tbody tr");

    rows.forEach(row => {
        let text = row.innerText.toLowerCase();
        row.style.display = text.includes(input) ? "" : "none";
    });
}
</script>
>>>>>>> c25f3e3714481c220e44f0de2b739e00bffad54c
</body>
</html>