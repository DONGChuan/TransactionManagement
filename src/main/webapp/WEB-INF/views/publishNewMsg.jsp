<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html" />
		<title>企业日常事务管理系统-发布新消息</title>
		<script src="js/menu.js" type="text/javascript"></script>
			
		<!-- <!-- Bootstrap -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
	</head>
	<body>
		<!-- Add header for all pages -->
		<%@ include file="header.jsp"%>

		<div>当前位置：[<a href="index.jsp">首页</a>] - [发布新消息]</div>
		<div>
		<div>
		<div>
			<div>
				<p>
					<font color="red">${requestScope.error}</font>
				</p>
				<form action="MsgPublish" method="post">
			  <p>消息标题：
			    <input type="text" name="title" size="50"/>
			  </p>
			  <p>消息内容：</p>
			  <p>
			    <FCK:editor instanceName="content" basePath="/fckeditor" toolbarSet="myToolbar" height="400" width="750"></FCK:editor>
			  </p>
			  <p align="center">
			    <input type="submit" value="Submit" />
			    <input type="reset" value="Reset" />
			  </p>
			  </form>
			</div>
		</div>
		</div>
		</div>
		<%@ include file="footer.jsp"%>
	</body>
</html>



