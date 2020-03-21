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
			<div class="col-md-3"></div>

			<div class="col-md-6 pad-top-50">
				<h2 style="text-align: center; position: inherit; bottom: 17px;">View
					Your Blog</h2>

				<form:form action="updateBlog" modelAttribute="WriteBlogs"
					method="POST" enctype="multipart/form-data">
					<div class="row">
						<div class="col-md-8">
							<img alt="${blog.images[0].imageName}"
								src="${blog.images[0].imageUrl}" />
						</div>
						<div class="col-md-8">
							<div class="form-group">
								<label>Title:</label>
								<form:input type="text" id="title" path="title"
									class="form-control" disabled="true" />
							</div>
							<div class="form-group">
								<form:input type="hidden" path="updateBlogId"/>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label>Blogs Category :</label>
								<form:select class="form-control" disabled="true"
									path="category" id="category">
									<form:option value="${blog.category.categoryName}">${blog.category.categoryName}</form:option>
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
								</form:select>
							</div>
						</div>

					</div>
					<hr>

					<div class="form-group">
						<label>Description :</label>
						<form:textarea type="text" id="description" path="description" class="form-control"
							placeholder="Enter Description" rows="7" disabled="true"/>
					</div>
					<hr>
					<br>
					<button type="button" class="btn btn-primary"
						onclick="enableFields()">Edit</button>
					<form:button type="submit" id="updatebutton" class="btn btn-primary btn-float-right" disabled="true">Update</form:button>
				</form:form> 
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>

</html>

