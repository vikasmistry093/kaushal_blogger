<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | Blog_Success</title>
</head>
<%@ include file="header.jsp"%>
<body background="/images/background-main27.png">

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
		</div>
	</div>

	<h2 class="success" style="position: absolute;
    right: 377px;
    top: 147px;
    color: black;">
		<b>${successMsg}</b>
	</h2>
	
<button class="success-login-btn btn btn-primary" onclick="callHome()" >Back to Home</button>


	<div class="col-md-4"></div>
</body>
</html>
