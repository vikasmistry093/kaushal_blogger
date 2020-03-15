<html>
<head>
<%@include file="imports.jsp"%>

<meta charset="UTF-8">
<title>MyFirstBlog | Contact</title>
</head>
<%@ include file="header.jsp"%>

<body background="/images/background-main27.png">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>

			<div class="pad-top-70 col-md-6">
				<form action="#">
					<h1 style="padding-top: 7px;">&nbsp;&nbsp; &nbsp;&nbsp;
						&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;Contact Us</h1>

					<br>

					<div class="form-group">
						<label><b> Name :</b></label> <input type="text"
							class="form-control" placeholder="Enter Your Name " required>
					</div>

					<div class="form-group">
						<label><b>Email :</b></label> <input type="email"
							class="form-control" placeholder="(eg: abc@gmail.com)" required>
					</div>

					<div class="form-group">
						<label><b>Comment or Message :</b></label>
						<textarea name="message" class="form-control"
							placeholder="Write Your suggestions....." rows="7" required></textarea>
					</div>

					<br>

					<button type="submit" class="btn-float-right btn btn-primary"
						style="position: absolute; left: 297px;">Send Message</button>
				</form>
			</div>

			<div class="col-md-3"></div>
		</div>
	</div>

</body>
</html>



