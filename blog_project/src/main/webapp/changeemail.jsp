<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | Change Email</title>
</head>
<%@ include file="header.jsp"%>

<body background="/images/background-main27.png">

	<div class="container-fluid">
		<div class="row">
			<div class=" pad-top-50 col-md-4">
				<!-- <h1 style="color:whitesmoke;text-align:center;">This is a heading</h1>
				<a href="#">
						<img src="/home/kaushal/D Drive/Blogging Images/Setting Page Images/Change Email.png" alt="HTML tutorial" style="width:367px;height:337px;border:0;">
					  </a> -->

			</div>

			<div class="pad-top-50 col-md-4">
				<h1 style="color: whitesmoke; text-align: center;">This is a
					heading</h1>
				<br>

				<div class="form-group">
					<label> Current Email :</label> <input type="email"
						class="form-control" placeholder="Enter Current Email" required>
				</div>

				<div class="form-group">
					<label> New Email :</label> <input type="email"
						class="form-control" placeholder="Enter New Email" required>
				</div>

				<button type="submit" class="btn btn-primary ">Clear</button>
				<button type="button" class="btn-float-right btn btn-primary ">submit</button>

			</div>



			<div class="pad-top-50 col-md-4">
				<!-- <h1 style="color:whitesmoke;text-align:center;">This is a heading</h1>
				<a href="#">
						<img src="/home/kaushal/D Drive/Blogging Images/Setting Page Images/visit-my-blog.jpg" alt="HTML tutorial" style="width:367px;height:337px;border:0;">
					  </a> -->

			</div>
		</div>
	</div>

</body>
</html>