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
			<h1>Trending Posts</h1>
		</section>

        <!-- Main content -->
        <section class="content">

          <!-- Main row -->
          <div class="row">
          
          <c:forEach items="${topPosts}" var="topPost">
              <div class="col-md-12	">
                  <div class="box box-warning box-solid">
                      <div class="box-header with-border">
                          <h4 class="pull-left">${topPost.post.headline} [Last Updated: ${topPost.post.updateDate}]</h4>
                          <h4 class="pull-right">Rating: ${topPost.rating}/10</h4>
                      </div><!-- /.box-header -->
                      <div class="box-body" style="display">
                      	 <button class="pull-right btn btn-default" id="rate">
							Rate Post <i class="fa fa-arrow-circle-right"></i>
						 </button>
                          <label>${topPost.post.category}</label><br><br>
                          <label>${topPost.post.content}</label><br>
						
                          <label class="pull-right">Author: ${topPost.postOwner}</label> <br>
                          
                      </div><!-- /.box-body -->
                  </div><!-- /.box -->
              </div>
		  </c:forEach>
		  
          </div><!-- /.row -->
          
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
    
    </div><!-- ./wrapper -->

  </body>
</html>