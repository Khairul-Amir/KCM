<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>My Profile</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<link href="<c:url value="/plugins/fontawesome-free/css/all.min.css" />" rel="stylesheet">
<link href="<c:url value="/plugins/overlayScrollbars/css/OverlayScrollbars.min.css" />" rel="stylesheet">
<style><%@include file="/dist/css/adminlte.min.css"%> </style>
<LINK REL="StyleSheet" HREF="${pageContext.servletContext.contextPath}/plugins/fontawesome-free/css/all.min.css" TYPE="text/css"> 
<LINK REL="StyleSheet" HREF="<%=request.getContextPath()%>/plugins/overlayScrollbars/css/OverlayScrollbars.min.css" TYPE="text/css"> 
</head>
<body>
	<div class="wrapper">
	
	
		<!-- Main Sidebar Container -->
	  <aside class="main-sidebar sidebar-dark-primary elevation-4">
	    <!-- Brand Logo -->
	    <a href="#" class="brand-link">
	      <span class="brand-text font-weight-light">KCMMS</span>
	    </a>
	
	    <!-- Sidebar -->
	    <div class="sidebar">
	      <!-- Sidebar user panel (optional) -->
	      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
	        <div class="info">
	          <a href="#" class="d-block"><c:out value="${sessionScope.userName}" /></a>
	        </div>
	      </div>
	
	      <!-- Sidebar Menu -->
	      <nav class="mt-2">
	        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
	          <!-- Add icons to the links using the .nav-icon class
	               with font-awesome or any other icon font library -->
	          
	          <li class="nav-header">Navigation</li>
			  
			  <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/showmainpagemember" class="nav-link ">
	              <i class="nav-icon fas fa-home"></i>
	              <p>
	                Main Page
	              </p>
	            </a>
	          </li>
			  
			  <li class="nav-header">Personal</li>
			  
			  <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/showmemberprofileform" class="nav-link active">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                Profile
	              </p>
	            </a>
	          </li>
			  
			  <li class="nav-header">Module</li>
			  
	          <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/listfeeformember"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                View List Fee
	              </p>
	            </a>
	          </li>
	          
	          <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/listevent"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                View New Events
	              </p>
	            </a>
	          </li>
	          
	          <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/listreceiptbymid"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                View Receipt
	              </p>
	            </a>
	          </li>
			  
			  
	        </ul>
	      </nav>
	      <!-- /.sidebar-menu -->
	    </div>
	    <!-- /.sidebar -->
	  </aside>
	  
	  
	<!-- Navbar -->
	<nav class="main-header navbar navbar-expand navbar-dark">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars">=</i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="<%=request.getContextPath()%>/showmainpagemember"  class="nav-link">Main Menu</a>
      </li>
    </ul>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
	<li class="nav-item">
        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
          <i class="fas fa-expand-arrows-alt"></i>
        </a>
      </li>
	  <li class="nav-item">
        <a class="nav-link" data-widget="logout" href="<%=request.getContextPath()%>/logout"  role="button">Sign Out</a>
		<i class="fas fa-sign-out-alt"></i>
        </a>
      </li>
    </ul>
	</nav>
	<!-- /.navbar -->
	
	
	
		<!--content-->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Edit Profile</h1>
						</div><!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
							  <li class="breadcrumb-item"><a href="#">Profile</a></li>
							</ol>
						</div><!-- /.col -->
					</div><!-- /.row -->
				</div><!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->
			
			<!--content-->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6">
							<div class="card card-info">
								<div class="card-header">
									<h3 class="card-title">Fill Details</h3>
								</div>
								<div class="card-body">
									
			                            <form action="updatememberprofile" method="post">
			                            
			                            <fieldset class="form-group">
				                            <label>Member ID</label><br>
				                            <span><c:out value='${user.memberid}' /></span>
				                            <input type="hidden" value="<c:out value='${user.memberid}' />" class="form-control" name="mid" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>IC No</label><br>
				                            <span><c:out value='${user.membericno}'/></span>
				                            <input type="hidden" value="<c:out value='${user.membericno}' />" class="form-control" name="mic" required="required">
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <label>Name</label> <input type="text" value="<c:out value='${user.membername}' />" class="form-control" name="mname" required="required">
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <label>Address</label> <input type="text" value="<c:out value='${user.memberaddress}' />" class="form-control" name="madd" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>Postcode</label> <input type="text" value="<c:out value='${user.memberpostcode}' />" class="form-control" name="mpc" required="required">
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <label>State</label> <input type="text" value="<c:out value='${user.memberstate}' />" class="form-control" name="mstate" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>Phone No</label> <input type="text" value="<c:out value='${user.memberphoneno}' />" class="form-control" name="mphone" required="required">
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <label>Gender</label><br>
				                            <span><c:out value='${user.membergender}' /></span>
				                            <input type="hidden" value="<c:out value='${user.membergender}' />" class="form-control" name="mgen" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>Membership Status</label><br>
				                            <span><c:out value='${user.memberstatus}' /></span>
				                            <input type="hidden" value="<c:out value='${user.memberstatus}' />" class="form-control" name="mstatus" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>Type</label><br>
				                            <span><c:out value='${user.membertype}' /></span>
				                            <input type="hidden" value="<c:out value='${user.membertype}' />" class="form-control" name="mtype" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>Password</label> <input type="text" value="<c:out value='${user.memberpassword}' />" class="form-control" name="mpass" required="required">
				                        </fieldset>
				                        
				                        <button type="submit" class="btn btn-success">Update</button>
				                        </form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!--/content-->
		</div>
		<!--/content-->
		
	</div>
	
<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script><%@include file="/plugins/jquery/jquery.min.js"%> </script>
<!-- Bootstrap -->
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script><%@include file="/plugins/bootstrap/js/bootstrap.bundle.min.js"%> </script>
<!-- overlayScrollbars -->
<script type="text/javascript" src="${pageContext.request.contextPath}/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<script><%@include file="/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"%> </script>
<!-- AdminLTE App -->
<script type="text/javascript" src="${pageContext.request.contextPath}/dist/js/adminlte.js"></script>
<script><%@include file="/dist/js/adminlte.js"%> </script>
</body>
</html>