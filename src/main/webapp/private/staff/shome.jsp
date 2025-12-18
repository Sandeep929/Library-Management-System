<%@page import="com.pojo.Dashboard"%>
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
      <%
				Integer tatBooks = (Integer) request.getAttribute("tatBooks");
				Integer issBooks = (Integer) request.getAttribute("issBooks");
				Integer availBooks = (Integer) request.getAttribute("availBooks");
	   %>
        
		<div class="card">
		  <h3 style="margin-top:0;">Dashboard</h3>
		  <p class="small">Quick stats</p>
		  <div style="display:flex;gap:12px;margin-top:12px;">
		    <div style="flex:1;padding:12px;border-radius:8px;background:#f1f8ff;">
		      <div style="font-weight:700;font-size:18px;"><%= tatBooks != null ? tatBooks.intValue() :"0" %></div>
		      <div class="small">Total Books</div>
		    </div>
		    <div style="flex:1;padding:12px;border-radius:8px;background:#fefce8;">
		      <div style="font-weight:700;font-size:18px;"><%= issBooks != null ? issBooks.intValue() :"0" %></div>
		      <div class="small">Issued</div>
		    </div>
		    <div style="flex:1;padding:12px;border-radius:8px;background:#eef2f7;">
		      <div style="font-weight:700;font-size:18px;"><%= availBooks != null ? availBooks.intValue() : "0" %></div>
		      <div class="small">Available</div>
		    </div>
		  </div>
		</div>
		
		<div class="card">
		  <h4 style="margin-top:0;">Recent Issues</h4>
		  <table class="table">
		    <thead>
		    	<tr>
		    		<th>User</th>
		    		<th>Book</th>
		    		<th>Issue Date</th>
		    		<th>Due</th>
		    		<th>Status</th>
		    	</tr>
		    </thead>
		    <tbody>
		      <%
		    	ArrayList<Dashboard> rl = (ArrayList<Dashboard>)request.getAttribute("d_list");
		    	if(rl != null && rl.size() > 0){
		    	for(int i = 0; i<rl.size(); i++){
					%>		      
		    	<tr>
		      		<td><%= rl.get(i).getName() %></td>
		      		<td><%= rl.get(i).getB_name() %></td>
		      		<td><%= rl.get(i).getIssueDate() %></td>
		      		<td><%= rl.get(i).getDueDate() %></td>
		      		<td><span class = "badge"><%= rl.get(i).getStatus() %></span></td>
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