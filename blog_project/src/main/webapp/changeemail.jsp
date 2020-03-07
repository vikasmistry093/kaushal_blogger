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
			<div class=" pad-top-50 col-md-4"></div>

			<div class="pad-top-50 col-md-4">
				<h1 style="color: black; text-align: center;">Change Email</h1>
				<br>

				<form:form action="updateEmail" class=" border border-dark black"
					modelAttribute="user" method="GET">

					<div class="form-group">
						<label> Enter New Email :</label>
						<form:input type="email" class="form-control" path ="emailId"
							placeholder="Enter New Email" required="required" />
					</div>

					<button type="reset" class="btn btn-primary ">Reset</button>
					<button type="submit" class="btn-float-right btn btn-primary ">Submit</button>

				</form:form>

			</div>
			<div class="pad-top-50 col-md-4"></div>
		</div>
	</div>

</body>
</html>