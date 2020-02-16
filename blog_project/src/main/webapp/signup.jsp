<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | SignUp</title>
</head>
<%@ include file="loginheader.jsp"%>

<body background="/images/background-main27.png">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>

			<div class="pad-top-50 col-md-6">

				<h2 style="text-align: center;">Sign Up</h2>

				<form:form action="createNewUser" class=" border border-dark black"
					modelAttribute="user" method="POST">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label>First Name :</label>
								<form:input type="text" path="firstName" class="form-control"
									placeholder="First Name" required="required" />
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group">
								<label>Last Name :</label>
								<form:input type="text" path="lastName" class="form-control"
									placeholder="Last Name" required="required" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label>Email :</label>
						<form:input type="email" path="emailId" class="form-control"
							placeholder="Email" required="required" />
					</div>
					<div class="form-group">
						<label>Mobile Number :</label>
						<form:input type="text" maxlength="10" path="phoneNo"
							class="form-control" placeholder="Enter Mobile Number" pattern = "^[0-9]*$"
							required="required" />
							
					</div>

					<div class="form-group">
						<label>Password :</label>
						<form:input type="password" path="userPassword"
							class="form-control" placeholder="Enter Password"
							required="required" />
					</div>
					<div class="form-group form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox" name="remember">
							<span class="mar-left-9 mar-bottom-neg-3 rember-me">
								Remember me </span>
						</label>
					</div>

					<button type="Reset" class="btn btn-primary ">Reset</button>

					<button type="submit" class="btn-float-right btn btn-primary ">Sign
						Up</button>
				</form:form>
				<c:if test="${errorMessage != null }">
					<span>${errorMessage}</span>
				</c:if>

			</div>

			<div class="col-md-3"></div>

		</div>
	</div>

</body>
</html>
