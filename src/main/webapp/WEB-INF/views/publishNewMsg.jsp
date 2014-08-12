<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html" />
		<title>DoBee MS - New Message</title>
		
		<!-- Editor -->
		<script src="//cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script>
		
		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" />
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" />
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
	</head>
	<body>
		<!-- Add header for all pages -->
		<%@ include file="header.jsp"%>

		<div>
			<ol class="breadcrumb">
			  	<li><a href="index">Home</a></li>
				<li class="active">Publish New Message</li>
			</ol>  
		</div>
		
		<div>
			<div>
				<div>
					<p>
						<font color="red">${requestScope.error}</font>
					</p>
					<form action="MsgPublish" method="post">
				  		<p>Message Title£º
				    	<input type="text" name="title" size="50"/>
				  		</p>
				  		<p>Message Content£º</p>
	
					    <textarea name="editor1"></textarea>
				        <script>
				            CKEDITOR.replace( 'editor1' );
				        </script>
					  
					  	<p align="center">
					    	<button type="reset" class="btn btn-default">Reset</button>
							<button type="submit" class="btn btn-default">Submit</button>
					  	</p>
				  	</form>
				</div>
			</div>
		</div>

		
		<%@ include file="footer.jsp"%>
	</body>
</html>



