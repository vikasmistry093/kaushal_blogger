
<html>
<head>

<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/mystyle.css" rel="stylesheet" type="text/css" />
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>MyFirstBlog | Login</title>
</head>
<body background="resources/images/background-main.jpg">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand/logo -->
		<img class="img-height-35" src="resources/images/logo/logo.jpg" />
		<!-- <a class="navbar-brand" href="#">Blogger</a> -->
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>

			<div class="pad-top-80 col-md-6">
				<form action="#">
					<h2>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp; Welcome to MyFirstBlog</h2>
					<br>
					<!-- <div class="imgcontainer">
							<img src="resources/images/img_avatar.png" alt="Avatar" class="avatar">
						  </div> -->
					<div class="form-group">
						<label>Username :</label> <input type="text" class="form-control"
							placeholder="Enter Username " required>


					</div>
					<div class="form-group">
						<label>Password :</label> <input type="password"
							class="form-control" placeholder="Enter Password" required>
					</div>
					<div class="form-group form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" name="remember">
							<span class="mar-left-9 mar-bottom-neg-3 rember-me">
								Remember me </span>
						</label>
					</div>

					<button type="submit" class="btn btn-primary ">Login</button>

					<button type="button" class="btn-float-right btn btn-primary ">Register</button>
					<br> <br> <a href="#"> Forget Password ?</a>
				</form>
			</div>

			<div class="col-md-3"></div>
		</div>
	</div>



</body>
</html>
