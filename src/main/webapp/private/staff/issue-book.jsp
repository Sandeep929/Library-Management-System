<%@page import="com.pojo.Book"%>
<%@page import="com.pojo.IssueRequest"%>
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
<%@include file ="header.jsp" %>
    
      <main class="main">
        
		<div class="card">
		  <h3 style="margin-top:0;">Issue Book</h3>
		  <table class="table">
		    <thead><tr><th>Name</th><th>RegNo</th><th>Book</th><th>ISBN</th><th>Available</th></tr></thead>
		    <tbody>
		    <%
		    	ArrayList<IssueRequest> rl = (ArrayList<IssueRequest>)request.getAttribute("request_list");
		    	ArrayList<Book> bl = (ArrayList<Book>)request.getAttribute("book_list");
		    	if(rl != null && bl != null && rl.size() > 0 && bl.size() > 0){
		    	for(int i = 0; i<rl.size(); i++){
		    		int avlbooks = 0;
					%>		      
		    	<tr>
		      	<td><%= rl.get(i).getS_name() %></td>
		      	<td><%= rl.get(i).getRegno() %></td>
		      	<td><%= rl.get(i).getB_name() %></td>
		      	<td><%= rl.get(i).getIsbn() %></td>
		      	<%
		      		for(Book b : bl){
		      			if(rl.get(i).getIsbn().equals(b.getISBN())){
		      				avlbooks = Integer.parseInt(b.getAvailavble());
		      				%>
					      	<td><%= b.getAvailavble() %></td>
					      	<%
		      			}
		      		}
		      	%>
		      	<td style="display: flex; gap:5px;">
		      			<% if(avlbooks > 0){ %>
						<form action="<%=request.getContextPath()%>/Manage_Book_Request_Servlet" method="post">
			      			<input style="display: none;" name = "isbn" value = "<%= rl.get(i).getIsbn()%>">
			      			<input style="display: none;" name = "regno" value = "<%= rl.get(i).getRegno()%>">
			      			<button style="min-width: 85px;" class="btn" type="submit">Accept</button>
		      			</form>
		      			<%
		      			}
		      			%>
						<form action="<%=request.getContextPath()%>/Manage_Book_Request_Servlet" method="get">
			      			<input style="display: none;" name = "isbn" value = "<%= rl.get(i).getIsbn()%>">
			      			<input style="display: none;" name = "regno" value = "<%= rl.get(i).getRegno()%>">
			      			<button style="min-width: 85px;" class="btn-reject" type="submit">Reject</button>
		      			</form>
		      	</td>
		      </tr>
		      		<%
					}
		      }
		    	else{
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
		</div>

      </main>
    </div>
  </div>
</body>
</html>