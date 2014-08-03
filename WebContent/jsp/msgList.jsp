<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>企业日常事务管理系统-消息列表</title>
		<link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
		<link href="css/channel.css" type="text/css" rel="stylesheet" media="all" />
		<script src="js/menu.js" type="text/javascript"></script>
		<style type="text/css">
		<!--
		.STYLE2 {	color: #CCCCCC;
			font-size: 14px;
		}
		-->
		</style>
		
		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</head>
	<body>
		<!-- Add header for all pages -->
		<%@ include file="header.jsp"%>
		
		<div id="place">当前位置：[<a href="index.jsp">首页</a>] - [消息列表]</div>
		<div id="channelcont">
		<div id="channelleft">
		<div class="channelinleft">
		<div class="channeltit"></div>
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
		<div class="end"></div>
		<script type=text/javascript>
		startajaxtabs("jsmenu");
		
		var iTab=GetCookie("nets_jsmenu");
			iTab = iTab ? parseInt(iTab):parseInt(Math.random()*5);
			if(iTab!=0) getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
			iTab++;
			if(iTab>4) iTab=0;
			SetCookie("nets_jsmenu",iTab,365);
		function getElement(aID)
		{
		  return (document.getElementById) ? document.getElementById(aID)
		                                   : document.all[aID];
		}
		</script>
	</body>
</html>


