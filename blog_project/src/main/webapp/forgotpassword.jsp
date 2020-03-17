
<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | ForgotPassword</title>
</head>
<%@ include file="loginheader.jsp"%>

<body background="/images/background-main27.png">


	<br>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="pad-top-7 col-md-4">
				<h1 style="position: inherit; left: 37px;">Account Recovery</h1>
				<br> <br>
				<div class=" border border-dark black">
					
					<div class="form-group">
						<label>Email Address :</label> <input type="text"
							class="form-control" placeholder="Enter Email"
							required="required" />
					</div>

					<div class="form-group">
						<label>Contact Detail :</label> <input type="text" maxlength="10"
							class="form-control" placeholder="Enter Mobile Number"
							pattern="^[0-9]*$" required="required" />
					</div>

					<button type="reset" class="btn btn-primary">Reset</button>
					<button type="submit" class="btn-float-right btn btn-primary">Submit</button>

				</div>

			</div>

			<div class="col-md-4"></div>
		</div>
	</div>

</body>
</html>