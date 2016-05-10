<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>PostShare | Dashboard</title>
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
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    
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
		    $(function () {
		        	 $('#content-import').load('trending.jsp');
		    });
		    
		    function loadTrendingPage() {
		    	$('#content-import').load('trending.jsp');
		    }
		    
		    function loadComposePage() {
		    	var userid = $("#user-id").val();
		    	$('#content-import').load('compose.jsp?userId='+userid);
		    }
		    
		    function loadMyPostsPage() {
		    	var userid = $("#user-id").val();
		    	$('#content-import').load('myposts.jsp?userId='+userid);
		    }
		    
		    function loadUpdateProfilePage() {
		    	var userid = $("#user-id").val();
		    	$('#content-import').load('register.jsp?userId='+userid);
		    }
		</script>

</head>
  <body class="skin-blue" onload="test();" >
    <div class="wrapper">
      
      <header class="main-header">
        <!-- Logo -->
        <a href="#" class="logo">Post Share</a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation"/>
      </header>
      
	  <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="resources/dist/img/avatar5.png" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>${user.firstName} ${user.lastName}</p>
              <input type="hidden" id="user-id" value="${user.userId}">

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview">
             
              <ul class="treeview-menu">
                  
                <li><a href="#" onclick="loadTrendingPage();" data-toggle="modal" data-target="#myModal"><i class="fa fa-star"></i>Trending Posts</a></li>  
                <li><a href="#" onclick="loadComposePage();" data-toggle="modal" data-target="#myModal"><i class="fa fa-edit"></i>Compose New Post</a></li>
                <li><a href="#" onclick="loadMyPostsPage();" data-toggle="modal" data-target="#myModal"><i class="fa fa-list"></i>My Posts</a></li>
                <li><a href="#" onclick="loadUpdateProfilePage();" data-toggle="modal" data-target="#myModal"><i class="fa fa-refresh"></i>Update Profile</a></li>
                <li><a href="#" data-toggle="modal" data-target="#myModal"><i class="fa fa-times"></i>Delete User</a></li>
                <li><a href="index.jsp" data-toggle="modal" data-target="#myModal"><i class="fa fa-eject"></i>Logout</a></li>
              </ul>
            </li>
            
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">

        <!-- Main content -->
          <!-- Placeholder for AJAX -->
		  <div id="content-import"></div>
          
      </div><!-- /.content-wrapper -->
    
    </div><!-- ./wrapper -->

  </body>
</html>