<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>企业日常事务管理系统-身份识别</title>
<link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
<script src="js/menu.js" type="text/javascript"></script>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>

<body>
<%@ include file="header.jsp"%>

</div>

<div id="indexfirst">
	<div id="place">当前位置：[<a href="index.jsp">首页</a>] - [员工身份识别]</div>
  <div id="menunav2">
		<div class="tit">
 		 <h1>员工身份识别</h1>
		</div>
		<div id="shenfenshibie">
			<font color="red">${requestScope.error }</font>
			<form action="StatusRecogniseAction" method="post">
		  	<p>员工编号：<input type="text" name="employeeID" value="${param.employeeID}"/></p>
		  	<p>&nbsp;</p>
		  	<p>系统口令：<input type="password" name="password" /></p>
		  	<p>&nbsp;</p>
		  	<p><input type="submit" value="提交" />
		    <input type="reset" value="重置" /></p>
		    </form>
		</div>
</div>
</div>
<div id="indexsec"></div>
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

