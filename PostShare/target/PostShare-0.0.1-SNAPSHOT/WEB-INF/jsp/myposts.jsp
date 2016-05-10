<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>PostShare | My Posts</title>
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

      <!-- Javascript -->
		<script type="text/javascript">
		    
		    function removePost() {
		    	if (confirm('Confirm post delete?')) {
		    		var postid = $("#post-id").val();
		    	}
		    	//var userid = $("#user-id").val();
		    	//$('#content-import').load('compose.jsp?userId='+userid);
		    }

		</script>      
  

  </head>
  <body>
    <div class="wrapper-inner">
      
      <!-- Content Wrapper. Contains page content -->
      <div >

		<section class="content-header">
			<h1>My Posts</h1>
		</section>

        <!-- Main content -->
        <section class="content">

          <!-- Main row -->
          <div class="row">
          
          <c:if test="${empty userPosts}">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-warning text-yellow"></i> Oops! You have no posts.</p>
          </c:if>
          
          <c:forEach items="${userPosts}" var="userPost">
              <div class="col-md-12	">
                  <div class="box box-warning box-solid">
                      <div class="box-header with-border">
                          <h4 class="pull-left">${userPost.post.headline} [Last Updated: ${userPost.post.updateDate}]</h4>
                          <h4 class="pull-right">Rating: ${userPost.rating}/10</h4>
                      </div><!-- /.box-header -->
                      <div class="box-body" style="display">
                          <label>${userPost.post.category}</label><br><br>
                          <label>${userPost.post.content}</label><br>
                          
                          <a href="#" onclick="removePost();" class="btn  pull-right"><i class="fa fa-trash-o"></i> Remove</a>
                          <a class="btn  pull-right"><i class="fa fa-edit"></i> Edit</a><br>
                          
                          <input type="hidden" id="post-id" value="${userPost.post.id}">
                          
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