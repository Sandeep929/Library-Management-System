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
<%@include file="header.jsp" %>
    
      <main class="main">
        
		<div class="card">
		  <h3 style="margin-top:0;">Search Books</h3>
		  <div style="display:flex;justify-content: space-between;margin-top:8px;margin-bottom:12px;">
		  	<p>View, Search</p>
		  </div>
		  
		  <div style="display:flex;gap:8px;margin-top:8px;margin-bottom:12px;">
		    <input type="text" class="input" id="searchInput" placeholder="Search by title or author" />
		    <button class="btn" onclick="searchBooks()">Search</button>
		  </div>
		  
		  <table id = "bookTable" class="table">
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
				      			<button style="min-width: 85px;" class="btn" type="submit">Get Book</button>
			      			</form>
			      		<%
						}
					}else{
						%>
						<form action="Issue_Request_Servlet">
			      		
			      			<input style="display: none;" name = "isbn" value = "<%= bl.get(i).getISBN()%>">
			      			<button style="min-width: 85px;" class="btn" type="submit">Get Book</button>
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
</body>
</html>