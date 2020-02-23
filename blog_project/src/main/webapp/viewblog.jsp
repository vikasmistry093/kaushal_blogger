<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | ViewBlog</title>
</head>
<%@ include file="header.jsp"%>

<body background="/images/background-main27.png">

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8 pad-top-50">
				
				<div>
					<img alt="${blog.images[0].imageName}" src="${blog.images[0].imageUrl}">
				</div>

				<div>
					<h2>${blog.title}</h2>
				</div>
				
				<div>
					<p>${blog.description}</p>
				</div>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div>
</body>
</html>

