<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | UpdateBlog</title>
</head>
<%@ include file="header.jsp"%>

<body background="/images/background-main27.png">

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>

			<div class="col-md-6 pad-top-50">
				<h2 style="text-align: center; position: inherit; bottom: 17px;">Update Your Blog</h2>

				<div class="row">
					<div class="col-md-8">
						<img alt="${blog.images[0].imageName}"
							src="${blog.images[0].imageUrl}" />
					</div>
					<div class="col-md-8">
						<div class="form-group">
							<label>Title:</label> <input type="text" class="form-control"
								value="${blog.title}">
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label>Blogs Category :</label> <select class="form-control">
								<option value="${blog.category.categoryName}">${blog.category.categoryName}</option>
								<%-- <form:select class="form-control" path="category">
									<form:option value="fashion">Fashion </form:option>
									<form:option value="food">Food </form:option>
									<form:option value="cricket">Cricket</form:option>
									<form:option value="photo">Photo</form:option>
									<form:option value="adventure">Adventure </form:option>
									<form:option value="travel">Travel </form:option>
									<form:option value="music">Music </form:option>
									<form:option value="lifestyle">Lifestyle </form:option>
									<form:option value="diy">DIY</form:option>
									<form:option value="fitness">Fitness</form:option>
								</form:select> --%>
							</select>
						</div>
					</div>

				</div>
				<hr>

				<div class="form-group">
					<label>Description :</label>
					<textarea class="form-control" rows="7">${blog.description}</textarea>
				</div>
				<hr>
				<br>
				<button type="button" class="btn btn-primary" onclick="callHome()">Back</button>
				<button type="button" class="btn btn-primary btn-float-right">Update</button>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>

</html>

