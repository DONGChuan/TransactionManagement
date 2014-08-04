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
			<ol class="breadcrumb">
			  	<li><a href="index.jsp">Home</a></li>
				<li class="active">Login</li>
			</ol>
			<div class="row">
			<div class="col-md-6 col-md-offset-3">
		  	<div class="panel panel-info">
				<div class="panel-heading">
					<h4>Employee identification</h4>
				</div>
				<div class="panel-body">
					<p></p>
					<p></p>
					<div>
						<font color="red">${requestScope.error}</font>
						<form class="form-horizontal" role="form" action="StatusRecogniseAction" method="post">
							<div class="form-group">
	    						<label class="col-sm-2 control-label">User ID</label>
	    						<div class="col-xs-4">
	      							<input type="text" class="form-control" placeholder="User ID" name="employeeID" value="${param.employeeID}"/>
	    						</div>
	  						</div>
	  						<div class="form-group">
	    						<label class="col-sm-2 control-label">Password</label>
	    						<div class="col-xs-4">
	      							<input type="password" class="form-control" placeholder="Password" name="password"/>
	    						</div>
	 						 </div>
						    <div class="form-group">
						    	<div class="col-sm-offset-2 col-sm-10">
						    		<button type="reset" class="btn btn-default">Reset</button>
						      		<button type="submit" class="btn btn-default">Login</button>
						    	</div>
	 						</div>					
					    </form>
					</div>
				</div>
				</div>
			</div>
			</div>
		</div>
		<p></p>
		<p></p>
		<p></p>
		<!-- Footer -->
		<%@ include file="footer.jsp"%>
	
	</body>
</html>

