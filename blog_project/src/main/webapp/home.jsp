<html>
<head>
<%@include file="imports.jsp" %>


<meta charset="UTF-8">
<title>MyFirstBlog | Home</title>
</head>
<%@ include file="header.jsp" %>

<body background="/images/background-main27.png">

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3 pad-top-50">
				<img class="advertisement-img" src="/images/giphy.webp" />
			</div>

			<div class="col-md-6 pad-top-50">
				<c:if test="${blogs.size() == 0}">
					<h3>No Data to Display</h3>
				</c:if>
				<c:if test="${blogs.size() != 0}">
					<c:forEach var="blog" items="${blogs}">
					<%-- <c:set var ="countOfBlog" scope="session" value="${0}"/> --%>
						<div class="card blogs-card-height">
							<div class="card-body">
								<div class="row">
									<div class="col-md-3">
										<img class="card-img-top rounded blogs-image"
											src="/images/cricketers_book_bodyimage.jpg" alt="Card image">
									</div>
									<div class="col-md-9">
										<h4>${blog.title}</h4>
										<p class="card-text">${fn:substring(blog.description, 0, 50)}...</p>
										<a href="/viewblog/${blog.blogId}" class="btn btn-primary btn-float-right">View
											Blog</a>
									</div>
								</div>
							</div>
						</div>
						<br>
						<!--....................PREVIOUS AND NEXT BUTTON..................-->
						<a href="#" class=" previous-home-button previous round">&#8249;</a>
						<a href="#" class=" next-home-button next round">&#8250;</a>
						<!--....................PREVIOUS AND NEXT BUTTON..................-->
					</c:forEach>
				</c:if>
			</div>
			<div class="col-md-3 pad-top-50">
				<img class="advertisement-img" src="/images/advertise-image1.jpeg">
			</div>
		</div>
	</div>
	<br>

	<%@include file="footer.jsp" %>


</body>
</html>
