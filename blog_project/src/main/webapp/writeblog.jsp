<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | WriteBlog</title>
</head>
<%@ include file="header.jsp"%>

<body background="/images/background-main27.png">

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>

			<div class="col-md-6 pad-top-50">
				<h2 style="text-align: center;">Write Your Blog</h2>

				<form:form action="createNewBlog" modelAttribute="WriteBlogs"
					method="POST" enctype="multipart/form-data">
					<div class="row">
						<div class="col-md-8">
							<div class="form-group">
								<label>Title:</label>
								<form:input type="text" path="title" class="form-control"
									placeholder="Title" required="required" />
							</div>
							</div>
							
							<div class="col-md-4">
							<div class="form-group">
								<label>Category :</label> 
								<form:select class="form-control" path="category">
									<form:option value="food">Food</form:option>
									<form:option value="cricket">Cricket</form:option>
									<form:option value="photo">Photo</form:option>
									<form:option value="adventure">Adventure</form:option>
									<form:option value="travel">Travel</form:option>
								</form:select>
							</div>
						</div>

					</div>
					<hr>

					<div class="form-group">
						<label>Description :</label>
						<form:textarea type="text" path="description" class="form-control"
							placeholder="Enter Description" rows="7" required="required" />
					</div>
					<hr>

					<form:input type="file" name="pic" path="images"/>
					<br>
					<br>
				
					<button type="reset" class="btn btn-primary">Reset</button>
					<button type="submit" class="btn btn-primary btn-float-right">Post</button>
				</form:form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>

