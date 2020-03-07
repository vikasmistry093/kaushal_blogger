<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | ChangePasswordSuccess</title>
</head>
<%@ include file="loginheader.jsp"%>

<body background="/images/background-main27.png">


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
		</div>
	</div>

	<h3 class="success" style="position: absolute;
    right: 292px;
    top: 147px;
    color: Black;">
		<b>YOU'VE SUCCESSFULLY CHANGED YOUR PASSWORD !</b>
	</h3>
	<!-- <button class="success-login-btn btn btn-success ">Back to
		Login</button> -->
	<button class="success-login-btn btn btn-primary"
		onclick="location.href ='/home'">Back to Home</button>
	<div class="col-md-2"></div>
</body>
</html>