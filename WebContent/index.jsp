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
		</div>
		<div id="indexfirst">
			<div id="thenew">
				<div class="tit">
					<h1>Newest Messages</h1>
				</div>
				<div class="STYLE1" id="therecom">
					<%
				 		MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
						Page pageX = PageUtil.createPage(6, messageDAO.findAllCount(), 1);
						List<Message> messages = messageDAO.findAllMessagee(pageX);
						for(Message message : messages) { 
					%>
						<p><a href="GetMessage?messageID=<%=message.getMessageID()%>"><%=message.getMessageTitle()%></a>
						<span class="STYLE2"><%=message.getPublishTime()%></span></p>
				 		<p>&nbsp;</p>
					<%	
						}
					%> 
				</div>
			</div>
			<div id="menunav">
				<div class="tit"><h1>Employee Information</h1></div>
				<div id="employee">
					<!-- Switch -->
					<c:choose>
						<c:when test="${empty sessionScope.employee}">
							No identification, please log in firstly!
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
		<div id="indexsec"></div>
		
		<!-- Add footer for all pages -->
		<%@ include file="jsp/footer.jsp"%>
		
		<div class="end"></div>
		<script type="text/javascript">
 			startajaxtabs("jsmenu");
			var iTab=GetCookie("nets_jsmenu");
				iTab = iTab ? parseInt(iTab):parseInt(Math.random()*5);
				if(iTab!=0) getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
				iTab++;
				if(iTab>4) iTab=0;
				SetCookie("nets_jsmenu",iTab,365);
				
			function getElement(aID){
				return (document.getElementById) ? document.getElementById(aID)
			                                   : document.all[aID];
			}
		</script>
	</body>
</html>

