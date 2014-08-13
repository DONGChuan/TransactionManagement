<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>	
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html" />
		<title>DoBee MS - Message Detail</title>
		
		<!-- Editor -->
		<script src="//cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script>
		
		<!-- Bootstrap -->
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" />
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" />
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	</head>
	
	<body>
		<%@ include file="header.jsp"%>
		
		<ol class="breadcrumb">
			  <li><a href="index">Home</a></li>
			  <li><a href="getMessageList">Messages List</a></li>
			  <li class="active">Message Detail</li>
		</ol>

		<div>
			<div class = "row">
				<div class ="col-md-8 col-md-offset-2">
					<div class="panel panel-default">
  						<div class="panel-body">
							<div class="media">
								<a class="pull-left" href="#">
									<span class="glyphicon glyphicon-bullhorn"></span>
							  	</a>
							  	<div class="media-body">
							    	<h4 class="media-heading">${message.messageTitle}</h4>
							   		${message.messageContent}
							  	</div>
							</div>
					 	</div>
					</div>
				</div>
				<div class ="col-md-8 col-md-offset-2">
					<div class="alert alert-info" role="alert">
						Publish ID£º${message.employeeID} 
				  		Publish Time£º${message.publishTime}
					</div>
				</div>
				<div class ="col-md-8 col-md-offset-2">
					<div class="alert alert-warning" role="alert">
						Leader's repley:${empty criticism ? "Nothing here":criticism.criticismContent}
					</div>
				</div>
				<div class ="col-md-8 col-md-offset-2">
					<ul class="list-group">
					  <c:forEach items="${requestScope.replyList}" var="reply">
						  <div>
						  	<li class="list-group-item">
						  		${reply.replyContent} 
						  		<br/>
						  		<h6>
						  			Reply ID£º${reply.employeeID} Reply Time£º${reply.replyTime}
						  		</h6>
						  	</li>
						  </div>
					  </c:forEach>
					</ul>
				</div>
			</div>					  
			<div align="center">
				<ul class="pagination">
				  <li><a href="getMessage?messageID=${message.messageID}&currentPage=1">&laquo;</a></li>
					  <c:forEach varStatus="stat" begin="1" end="${page.totalPage}">
					  <li><a href="getMessage?messageID=${message.messageID}&currentPage=${stat.index}">${stat.index}</a></li>
					  </c:forEach>
				  <li><a href="getMessage?messageID=${message.messageID}&currentPage=${page.totalPage}">&raquo;</a></li>
				</ul>
			</div>

		<div class ="row">
		  	<div class ="col-md-8 col-md-offset-2">
		  		<p>Reply:</p>
		  		<div class="alert alert-danger" role="alert">${error}</div>
		  		<form action="CommitReply" method="post">

					<textarea name="editor1"></textarea>
			        <script>
			            CKEDITOR.replace( 'editor1' );
			        </script>
	        
			  		<input type="hidden" name="messageID" value="${message.messageID}"/> 
			  		<button type="reset" class="btn btn-default">Reset</button>
					<button type="submit" class="btn btn-default">Submit</button>
		  		</form>	 
		  	</div>
			<c:if test="${sessionScope.employee.lead}">
				<div class ="col-md-8 col-md-offset-2">
				  	<p>Criticism:</p>
				  	<div class="alert alert-danger" role="alert">${error}</div>
				  	<form action="CommitCriticism" method="post">
				  	
				  		<textarea name="editor1"></textarea>
				        <script>
				            CKEDITOR.replace( 'editor1' );
				        </script>
				        
				  		<input type="hidden" name="messageID" value="${message.messageID}"/> 
				  		<button type="reset" class="btn btn-default">Reset</button>
						<button type="submit" class="btn btn-default">Submit</button>
				  	</form>	 
				  </div>
			  </c:if>
			</div>
		</div>

		<!-- Footer -->
		<%@ include file="footer.jsp"%>
	</body>
</html>



