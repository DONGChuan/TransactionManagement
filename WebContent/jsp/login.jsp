<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html" />
		<title>DoBee MS - Login</title>
		<script src="js/menu.js" type="text/javascript"></script>
		
		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</head>
	
	<body>
		<!-- Header -->
		<%@ include file="header.jsp"%>
		
		<div>
			<div id="place">��ǰλ�ã�[<a href="index.jsp">��ҳ</a>] - [Ա�����ʶ��]</div>
		  <div id="menunav2">
				<div class="tit">
		 		 <h1>Ա�����ʶ��</h1>
				</div>
				<div id="shenfenshibie">
					<font color="red">${requestScope.error }</font>
					<form action="StatusRecogniseAction" method="post">
				  	<p>Ա����ţ�<input type="text" name="employeeID" value="${param.employeeID}"/></p>
				  	<p>&nbsp;</p>
				  	<p>ϵͳ���<input type="password" name="password" /></p>
				  	<p>&nbsp;</p>
				  	<p><input type="submit" value="�ύ" />
				    <input type="reset" value="����" /></p>
				    </form>
				</div>
		</div>
		</div>
		<!-- Footer -->
		<%@ include file="footer.jsp"%>
	
	</body>
</html>

