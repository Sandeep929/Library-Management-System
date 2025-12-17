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
		  <form>
		    <div class="form-group"><label>Loan</label>
		      <select class="select">
		        <option>Radhika P — Introduction to Java (Issued 2025-11-28)</option>
		      </select>
		    </div>
		    <div style="text-align:right;"><a class="btn" href="<%=request.getContextPath()%>/private/student/return-book.jsp">Return</a></div>
		  </form>
		</div>

      </main>
    </div>
  </div>
</body>
</html>