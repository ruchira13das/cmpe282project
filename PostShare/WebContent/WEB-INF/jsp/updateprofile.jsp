<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>PostShare | Update Profile</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />

    <!-- Theme style -->
    <link href="resources/dist/css/PostShare.css" rel="stylesheet" type="text/css" />
    <link href="resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    
          <style>
         .ui-widget-header,.ui-state-default, ui-button{
            background:#b9cd6d;
            border: 1px solid #b9cd6d;
            color: #FFFFFF;
            font-weight: bold;
         }
      </style>
  

  </head>
  <body>
    <div class="wrapper-inner">
      
      <!-- Content Wrapper. Contains page content -->
      <div >

		<section class="content-header">
			<h1>Update Profile</h1>
		</section>

        <!-- Main content -->
        <section class="content">
		
				<div class="register-box-body">
		   			<p class="login-box-msg">Update Profile</p>
		
					<form:form method="POST" action="updateprofile.jsp" id="registerForm"
						modelAttribute="userForm">
						<div class="form-group has-feedback">
							<form:input path="firstName" type="text" class="form-control"
								placeholder="FirstName" id="firstName" required="required" value="${userForm.firstName}" />
							<span class="glyphicon glyphicon-user form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<form:input path="lastName" type="text" class="form-control"
								placeholder="LastName" id="lastName" value="${userForm.lastName}"  />
							<span class="glyphicon glyphicon-user form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<%-- <form:checkboxes path="userPreferences" items="${categories}" /> --%>
		
							<c:forEach items="${categories}" var="category">
								<form:checkbox path="userPreferences" value="${category.id}" />&nbsp;${category.categoryName}&nbsp;&nbsp;
							</c:forEach>
						</div>
						<div class="row">
							<!-- /.col -->
							<div class="col-xs-4">
								<button type="submit" class="btn btn-primary btn-block btn-flat"
									onclick="return validate()">Update</button>
							</div>
							<!-- /.col -->
						</div>
					</form:form>
		
				</div>
				<!-- /.form-box -->
			<!-- /.register-box -->

          
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
    
    </div><!-- ./wrapper -->

  </body>
</html>