<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="footer" fragment="true"%>
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
		src="<c:url value='/bower_components/jquery/dist/js/jquery.js' />"></script>
	<script
		src="<c:url value='/bower_components/bootstrap/dist/js/bootstrap.js' />"></script>
</body>
</html>