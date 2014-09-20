<%@ page language="java" import="java.util.*"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html" />
		<title>DoBee MS - Message List</title>
		<script src="js/menu.js" type="text/javascript"></script>

		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" />
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" />
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<!-- Add header for all pages -->
		<%@ include file="header.jsp"%>
			
		<ol class="breadcrumb">
			  <li><a href="index">Home</a></li>
			  <li class="active">Messages List</li>
		</ol>
		
		<div>
			<table class="table table-hover" align="center">
				<thead>
		        	<tr>
		          		<th>Message </th>
		          		<th>Publisher ID</th>
		          		<th>Publisher Time</th>
		        	</tr>
		      	</thead>
		      	<tbody>
  					<c:forEach items="${requestScope.messageList}" var="message">
						<tr>
							<td><a href="getMessage?messageID=${message.messageID}">${message.messageTitle}</a></td>
							<td>${message.employee.getEmployeeID()} </td>
							<td>${message.publishTime}</td>
						</tr>		
					</c:forEach>			
		      	</tbody>
			</table>
		<div>
			<div align="center">
			<c:choose>
				<c:when test="${page.hasPrePage}">
					<a href="getMessageList?currentPage=1">First</a> | 
					<a href="getMessageList?currentPage=${page.currentPage -1 }">Previous</a>
				</c:when>
				<c:otherwise>
					First | Previous
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.hasNextPage}">
					<a href="getMessageList?currentPage=${page.currentPage + 1 }">Next</a> | 
					<a href="getMessageList?currentPage=${page.totalPage }">Last</a>
				</c:when>
				<c:otherwise>
					Next | Last
				</c:otherwise>
			</c:choose>
			Now is ${page.currentPage} Page, Total ${page.totalPage} Pages
		  </div>
		</div>
		
		</div>
		</div>
		
		<!-- Footer -->
		<%@ include file="footer.jsp"%>

	</body>
</html>


