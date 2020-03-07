<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="imports.jsp"%>
<meta charset="UTF-8">
<title>MyFirstBlog | Change Password</title>
</head>
<%@ include file="header.jsp"%>

<body background="/images/background-main27.png">
	<div class="container-fluid">
		<div class="row">

			<div class=" pad-top-50 col-md-4"></div>
	
			<div class="pad-top-50 col-md-4">
				<h1 style="color: black; text-align: center;">Change Password</h1>
				<br>
				<form:form action="updatePassword" class=" border border-dark black"
					modelAttribute="formData" onsubmit="return validatePassword()" method="GET">
				<div class="form-group">
					
				</div>	
					
				<div class="form-group">
					<label>Current Password :</label> 
					<form:input type="password" class="form-control" path="currentPassword" id = "currentPwd" placeholder="Enter Current Password" required="required" />
				</div>

				<div class="form-group">
					<label> New Password :</label> 
					<form:input type="password" class="form-control" path="newPassword" id = "newPwd" placeholder="Enter New Password" required="required" />
				</div>

				<button type="reset" class="btn btn-primary">Reset</button>	
				<button type="submit" class="btn-float-right btn btn-primary">Submit</button>
				
				</form:form>

			</div>

			<div class="pad-top-50 col-md-4"></div>

		</div>
	</div>

</body>
</html>