<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html" />
		<title>企业日常事务管理系统-消息列表</title>
		<script src="js/menu.js" type="text/javascript"></script>

		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<!-- Add header for all pages -->
		<%@ include file="header.jsp"%>
		
		<ol class="breadcrumb">
			  <li><a href="index.jsp">Home</a></li>
			  <li class="active">Messages List</li>
		</ol>
		
		<div>>
		<dl>
		<c:forEach items="${requestScope.messageList}" var="message">
			<dt>>><a href="GetMessage?messageID=${message.messageID}">${message.messageTitle}</a></dt>
			<dd>
			  <div align="right">发布人ID：${message.employeeID} 
			  		发布时间：${message.publishTime}</div>
			</dd>
		</c:forEach>
		</dl>
		<div>
		  <div align="center">
			<c:choose>
				<c:when test="${page.hasPrePage}">
					<a href="GetMessageList?currentPage=1">首页</a> | 
			<a href="GetMessageList?currentPage=${page.currentPage -1 }">上一页</a>
				</c:when>
				<c:otherwise>
					首页 | 上一页
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.hasNextPage}">
					<a href="GetMessageList?currentPage=${page.currentPage + 1 }">下一页</a> | 
			<a href="GetMessageList?currentPage=${page.totalPage }">尾页</a>
				</c:when>
				<c:otherwise>
					下一页 | 尾页
				</c:otherwise>
			</c:choose>
			当前为第${page.currentPage}页,共${page.totalPage}页
		  </div>
		</div>
		
		</div>
		</div>
		<%@ include file="footer.jsp"%>

	</body>
</html>


