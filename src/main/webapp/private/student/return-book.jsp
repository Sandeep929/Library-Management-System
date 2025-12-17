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
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<%@include file="header.jsp" %>
    
      <main class="main">
        
		<div class="card">
		  <h3 style="margin-top:0;">Return Book</h3>
		  <p style="color: blue;">${status}</p>
		  <form action="<%=request.getContextPath()%>/ReturnBookServlet">
		    <div class="form-group"><label>Loan</label>
		      <select name = "return_book" class="select">
		      	<%
		      		ArrayList<Book> bl = (ArrayList<Book>) request.getAttribute("bl");
		      		ArrayList<RecentIssues> ril = (ArrayList<RecentIssues>) request.getAttribute("ri");
		      		if(ril != null && bl != null && ril.size() > 0 && bl.size() > 0){
		      		for(RecentIssues ri : ril){
		      			for(Book b : bl){
		      				if(ri.getIsbn().equals(b.getISBN())){
		        			%>
		        			<option value ="<%=b.getISBN()%>">${name} — <%= b.getTitle() %> (Due Date <%= ri.getDueDate() %>)</option>
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
		  </form>
		</div>

      </main>
    </div>
  </div>
</body>
</html>