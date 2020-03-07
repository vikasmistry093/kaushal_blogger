<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand/logo -->
	<a class="navbar-brand" href="/home"><img class="img-height-35"
		src="/images/logo/logo.jpg" /></a>
	<form class="form-inline nav-searchbar-align" action="#">
		<input class="form-control mr-sm-2 searchbar-textfield-length"
			type="text" placeholder="Search">
		<button class="btn btn-success" type="submit">Search</button>
	</form>

	<ul class="navbar-nav">

		<!-- Dropdown -->
		<c:if test="${user != null}">
			<li class="nav-item dropdown"><a
				class=" nav-user-name-dropname nav-link dropdown-toggle" href="#"
				id="navbardrop" data-toggle="dropdown"> <label class="text-info">Welcome,
						${user.firstName}</label>
			</a>
				<div class=" dropdown-menu">
					<a class="dropdown-item" href="/writeblog">Write Your Blog</a> <a
						class="dropdown-item" href="/setting">Settings</a> <a
						class="dropdown-item" href="#">My Bolgs</a> <a
						class="dropdown-item" href="/login">Logout</a>
				</div></li>
		</c:if>
		<c:if test="${user == null}">
			<li class="nav-item dropdown ">
			<a href="/login" style="position: inherit; left: 57px;"> <label class="text-info"> Login</label>
			</a></li>
			
		</c:if>

	</ul>

</nav>