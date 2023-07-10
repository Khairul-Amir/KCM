<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title> Apply Membership </title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Google Font: Source Sans Pro -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
		<!-- Font Awesome Icons -->
		<style><%@include file="/plugins/fontawesome-free/css/all.min.css"%></style>
		<!-- overlayScrollbars -->
		<link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
		<!-- Theme style -->
		<style><%@include file="/dist/css/adminlte.min.css"%></style>
	</head>

	<body>
	<div class="wrapper">
		
		
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Apply Membership</h1>
						</div><!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
							  <li class="breadcrumb-item"><a href="#">Apply Membership</a></li>
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
									
			                            <form action="register" method="post">

				                        
				                        <fieldset class="form-group">
				                            <label>Name</label> <input type="text" value="<c:out value='${member.membername}' />" class="form-control" name="name" required="required">
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <label>Address</label> <input type="text" value="<c:out value='${member.memberaddress}' />" class="form-control" name="address">
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <label>Postcode</label> <input type="text" value="<c:out value='${member.memberpostcode}' />" class="form-control" name="postcode">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>State</label> <input type="text" value="<c:out value='${member.memberstate}' />" class="form-control" name="state" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>Phone No</label> <input type="text" value="<c:out value='${member.memberphoneno}' />" class="form-control" name="phoneno" required="required">
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <label>Gender</label>
				                            <select name="gender">
											<option value="Male" >Male</option>
											<option value="Female" >Female</option>
											</select>
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <label>IC Number</label> <input type="text" value="<c:out value='${member.membericno}' />" class="form-control" name="icno">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <input type="hidden" value="<c:out value='${member.memberstatus}' />" class="form-control" name="status" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                            <label>Please Enter Your Password</label> <input type="text" value="<c:out value='${member.memberpassword}' />" class="form-control" name="password" required="required">
				                        </fieldset>
				
				                        <fieldset class="form-group">
				                            <input type="hidden" value="<c:out value='${member.membertype}' />" class="form-control" name="type">
				                        </fieldset>
				
				                        <button type="submit" class="btn btn-success">Apply</button>
				                        </form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!--/content-->
		</div>
		
	</div>
	</body>
</html>