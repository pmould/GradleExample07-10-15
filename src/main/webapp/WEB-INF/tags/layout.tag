<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="footer" fragment="true"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="<c:url value='/img/favicon.ico' />">
<title>Bort</title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/bower_components/bootstrap/dist/css/bootstrap.css' />"
	rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<link rel="icon" href="/img/favicon.ico" type="image/x-icon" /> 
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
</head>
<body>
	<nav class="navbar navbar-fixed-top navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Bort</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					  <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Employees <span class="caret"></span></a>
			          <ul class="dropdown-menu">
						<li><a href="<c:url value='/employees'/>"> View Employees</a></li>
			            <li><a href="<c:url value='/employees/new'/>"> Add New Employee</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="/employees/reports">Employee Reports</a></li>
			          </ul>
			        </li>
					  <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manage Branches <span class="caret"></span></a>
			          <ul class="dropdown-menu">
						<li><a href="<c:url value='/branches'/>"> View Branches</a></li>
			            <li><a href="<c:url value='/branches/new'/>"> Add New Branch</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="/branches/reports">Branch Reports</a></li>
			          </ul>
			        </li>
					  <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">View Branches <span class="caret"></span></a>
			          <ul class="dropdown-menu">
						<li><a href="<c:url value=''/>"> </a></li>
			            <li><a href="<c:url value=''/>"></a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="/employee/reports">Branch Reports</a></li>
			          </ul>
			        </li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!-- /.nav-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- /.navbar -->
	<div id="body" class="container" style="padding-top: 60px;">
		<div id="pageheader">
			<jsp:invoke fragment="header" />
		</div>
		<jsp:doBody />
		<hr>
		<footer>
			<jsp:invoke fragment="footer" />
			<p>&copy; Bort 2015</p>
		</footer>
	</div>
	<script
		src="<c:url value='/bower_components/jquery/dist/jquery.js' />"></script>
	<script
		src="<c:url value='/bower_components/bootstrap/dist/js/bootstrap.js' />"></script>
</body>
</html>