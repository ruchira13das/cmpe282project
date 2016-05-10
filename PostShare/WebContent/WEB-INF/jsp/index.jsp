<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login - PostShare</title>
<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="resources/dist/css/PostShare.css" rel="stylesheet"
	type="text/css" />
</head>
<body class="login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="index2.html"><b>PostShare</b></a>
		</div>
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>
			<p class="login-box-msg">${message}</p>
			<form:form method="POST" action="welcome.jsp" modelAttribute="userForm">
				<div class="form-group has-feedback">
					<form:input path="userId" type="email" placeholder="Email"
						class="form-control" required="required"/>
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<form:input path="password" type="password" placeholder="Password"
						class="form-control" required="required"/>
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-2"></div>
					<div class="col-xs-4">
						<button type="button" name="register1" onclick="window.location.href='register.jsp'" class="btn btn-warning btn-block btn-flat">Sign
							Up</button>
					</div>
					<div class="col-xs-4">
						<button type="submit" name="login" class="btn btn-primary btn-block btn-flat">Sign
							In</button>
					</div>
				</div>
			</form:form>

		</div>
	</div>
</body>
</html>