<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.dong.dao.MessageDAO"%>
<%@ page import="com.dong.factory.MessageDAOFactory"%>
<%@ page import="com.dong.util.Page"%>
<%@ page import="com.dong.util.PageUtil"%>
<%@ page import="com.dong.bean.Message"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html" />
		<title>DoBee MS - Homepage</title>
		<link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
		<link href="css/channel.css" type="text/css" rel="stylesheet" media="all" />
		<script src="js/menu.js" type="text/javascript"></script>
		
		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<!-- Add header for all pages -->
		<%@ include file="jsp/header.jsp"%>
		
		<div class="row">
			<div class="col-md-4">
				<div class="panel panel-primary page-header">
  					<div class="panel-heading">
						<h4>Employee Information</h4>
					</div>
					<div class="panel-body">
						<div>
							<!-- Switch -->
							<c:choose>
								<c:when test="${empty sessionScope.employee}">
									<div class="alert alert-warning" role="alert">
										No identification, please <a href="jsp/statusRecognise.jsp" class="alert-link">log in</a> firstly!
									</div>
								</c:when>
								<c:otherwise>
									<ul>
									  <li>Employee ID    ：${employee.employeeID}</li>
									  <li>Employee Name  ：${employee.employeeName}</li>
									  <li>Employee Sex   ：${employee.employeeSex ? "M" : "F"}</li>
									  <li>Employee Birth ：${employee.employeeBirth }</li>
									  <li>Employee Phone ：${employee.employeePhone }</li>
									  <li>Employee Addre ：${employee.employeePlace }</li>
									  <li>Employee Leader：${employee.lead ? 'YES' : 'NO'}</li>
									</ul>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div>
					<div class="panel panel-info page-header">
				  		<div class="panel-heading">
				  			<h4>Latest Messages</h4>
				  		</div>
				  		<div class="panel-body">
				    		<b>Our task is to make the world better and more stupid</b>
				  		</div>
						<table class="table table-striped">
		      				<thead>
		        				<tr>
		          					<th>#</th>
		          					<th>Title</th>
		          					<th>Time</th>
		        				</tr>
		      				</thead>
		      				<tbody>
		      					<%
		      					    int i = 1;
						 			MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
									Page pageX = PageUtil.createPage(6, messageDAO.findAllCount(), 1);
									List<Message> messages = messageDAO.findAllMessagee(pageX);
									for(Message message : messages) { 
								%>
		        				<tr>
		          					<td><%=i++%></td>
		          					<td><a href="GetMessage?messageID=<%=message.getMessageID()%>"><%=message.getMessageTitle()%></a></td>
		          					<td><%=message.getPublishTime()%></td>
		        				</tr>
		        				<%	
									}
								%> 
		      				</tbody>
    					</table>
					</div>
				</div>
			</div>
		
		<!-- Add footer for all pages -->
		<%@ include file="jsp/footer.jsp"%>

	</body>
</html>

