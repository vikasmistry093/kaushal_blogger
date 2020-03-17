
<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | Login</title>
</head>
<%@include file="loginheader.jsp"%>

<body background="/images/background-main27.png">

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>

			<div class="pad-top-80 col-md-4">
				<form:form action="validateUser" class=" border border-dark black"
					modelAttribute="user" method="GET">
					<h1>Welcome to MyBlog</h1>
					<div class="form-group">
						<label>Email Address :</label>
						<form:input type="text" class="form-control" path="emailId"
							placeholder="Enter Email" required="required" />
					</div>
					<div class="form-group">
						<label>Password :</label>
						<form:input type="password" class="form-control"
							path="userPassword" placeholder="Enter Password"
							required="required" />
					</div>
					<div class="form-group form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" name="remember">
							<span class="mar-left-9 mar-bottom-neg-3 rember-me">
								Remember me </span>
						</label>
					</div>

					<a href="/passwordRequest"> Forget Password ?</a>
					<br>
					<br>
					<button type="button" class="btn btn-primary" onclick="callSignUp()">Sign Up</button>

					<button type="submit" class="btn-float-right btn btn-primary ">Login</button>

				</form:form>
			</div>

			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>
