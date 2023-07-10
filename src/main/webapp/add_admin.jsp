<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Admin</title>
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
	            <a href="<%=request.getContextPath()%>/showmainpage" class="nav-link ">
	              <i class="nav-icon fas fa-home"></i>
	              <p>
	                Main Page
	              </p>
	            </a>
	          </li>
			  
			  <li class="nav-header">Personal</li>
			  
			  <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/showAdminProfileForm" class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                Profile
	              </p>
	            </a>
	          </li>
			  
			  <li class="nav-header">Member Module</li>
			  
			  <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/showMemberForm"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                Add New Member
	              </p>
	            </a>
	          </li>
	          
	          <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/listmember"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                Member List
	              </p>
	            </a>
	          </li>
	          
	          <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/listapplicant"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                New Applicant
	              </p>
	            </a>
	          </li>
			  
			  <li class="nav-header">Fee Module</li>
			  
			  <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/showNewFeeForm"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                Add New Fee
	              </p>
	            </a>
	          </li>
	          
	          <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/listfee"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                Fee List
	              </p>
	            </a>
	          </li>
	          
	          <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/listfeepay"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                View Payment
	              </p>
	            </a>
	          </li>
			  
			  <li class="nav-header">Admin Module</li>
			  
			  <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/showNewAdminForm"  class="nav-link active">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                Add New Admin
	              </p>
	            </a>
	          </li>
	          
	          <li class="nav-item">
	            <a href="<%=request.getContextPath()%>/listadmin"  class="nav-link">
	              <i class="nav-icon fas fa-user"></i>
	              <p>
	                Admin List
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
        <a href="<%=request.getContextPath()%>/showmainpage"  class="nav-link">Main Menu</a>
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
							<h1 class="m-0">Add New Admin</h1>
						</div><!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
							  <li class="breadcrumb-item"><a href="#">Admin</a></li>
							  <li class="breadcrumb-item"><a href="#">Add</a></li>
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
						<div class="col-md-12">
							<div class="card card-info">
								<div class="card-header">
									<h3 class="card-title">Fill Details</h3>
								</div>
								<div class="card-body">
									
			                            <form action="addadmin" method="post">
				
				                        <fieldset class="form-group">
				                            <label>Manager/Your ID</label> <input type="text" value="<c:out value='${admin.managerid}' />" class="form-control" name="managerid" required="required">
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <label>Admin Name</label> <input type="text" value="<c:out value='${admin.adminname}' />" class="form-control" name="adname" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>Admin Phone No</label> <input type="text" value="<c:out value='${admin.adminphoneno}' />" class="form-control" name="adphoneno" required="required">
				                        </fieldset>
				                        <button type="submit" class="btn btn-success">Add</button>
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