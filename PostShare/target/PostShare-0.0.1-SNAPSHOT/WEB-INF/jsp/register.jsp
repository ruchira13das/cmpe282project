<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Register new user - PostShare</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="resources/dist/css/PostShare.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript">
	function validate() {
		if (!isEmailValid()) {
			alert("Email is invalid!");
			document.getElementById('email').focus;
			return false;
		}

		if (!isPasswordValid()) {
			alert("Passwords don't match!");
			document.getElementById('password_confirm').focus;
			return false;
		}

		if (!isCategoryValid()) {
			alert("No preference is selected!");
			document.getElementById('preference').focus;
			return false;
		}

		return true;
	}

	function isEmailValid() {
		var email = document.getElementById('email').value;
		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
		if (filter.test(email)) {
			return true;
		} else {
			return false;
		}
	}

	// function isPasswordValid() {
	// 			var password = document.getElementById('password').value;
	// 			var password_confirm = document.getElementById('password_confirm').value;
	// 			
	// 			if(password == password_confirm) {
	// 				return true;
	// 			} else {
	// 				return false;
	// 			}
	// 		}

	function isCategoryValid() {
		var category = document.getElementById("category");
		if (category.selectedIndex == 0) {
			return false;
		} else {
			return true;
		}
	}
</script>
</head>

<body class="register-page">
	<div class="register-box">
		<div class="register-logo">
			<a href="index2.html"><b>PostShare</b></a>
		</div>

		<div class="register-box-body">
			<c:if test="${not empty message}">
    			<p class="login-box-msg">${message} <a href="index.html" class="text-center">Login Now</a></p>
			</c:if>
			<c:if test="${empty message}">
   				 <p class="login-box-msg">Register a new user</p>
			</c:if>

<%-- 			<p class="login-box-msg">Register a new user</p>
			<p class="login-box-msg">${message}</p> --%>
			<form:form method="POST" action="register.jsp" id="registerForm"
				modelAttribute="userForm">
				<div class="form-group has-feedback">
					<form:input path="firstName" type="text" class="form-control"
						placeholder="FirstName" id="firstName" required="required" />
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<form:input path="lastName" type="text" class="form-control"
						placeholder="LastName" id="lastName" />
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<form:input path="userId" type="email" class="form-control"
						placeholder="Email" id="email" required="required" /> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<form:input path="password" type="password"
						class="form-control" placeholder="Password" id="password"
						required="required" />
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<%-- <form:checkboxes path="userPreferences" items="${categories}" /> --%>

					<c:forEach items="${categories}" var="category">
						<form:checkbox path="userPreferences" value="${category.id}" />&nbsp;${category.categoryName}&nbsp;&nbsp;
					</c:forEach>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<a href="index.html" class="text-center">I have already
							registered</a>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat"
							onclick="return validate()">Register</button>
					</div>
					<!-- /.col -->
				</div>
			</form:form>

		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

</body>
</html>