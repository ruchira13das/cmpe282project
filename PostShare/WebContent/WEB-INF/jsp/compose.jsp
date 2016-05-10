<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>PostShare | Now Trending</title>
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
			<h1>Compose New Post</h1>
		</section>

        <!-- Main content -->
        <section class="content">

          <!-- Main row -->
          <div class="row">
          		<form:form method="POST" action="compose.jsp?userId=${userId}" modelAttribute="newPost">
				<div class="box box-info">
					<div class="box-header">
						<i class="fa fa-pencil"></i>
						<h3 class="box-title">Compose New Post</h3>
					</div>
					<div class="box-body">
						<div class="form-group">
							<form:input type="text" path="headline" class="form-control" name="headline"
								placeholder="Headline" />
						</div>
						<div class="form-group">
							<form:select type="text" path="category" class="form-control" name="category"
								placeholder="Category" >
								<c:forEach items="${categories}" var="category">
									<form:option value="${category.categoryName}" label="${category.categoryName}" />
								</c:forEach>
							</form:select>	
						</div>
						<div>
							<form:textarea class="textarea" path="content" placeholder="Content"
								style="width: 100%; height: 125px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></form:textarea>
						</div>
						
					</div>
					<div class="box-footer clearfix">
						<button type="submit" class="pull-right btn btn-default" id="post">
							Post <i class="fa fa-arrow-circle-right"></i>
						</button>
					</div>
				</div>
				</form:form>
			</div><!-- /.row -->
          
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
    
    </div><!-- ./wrapper -->

  </body>
</html>