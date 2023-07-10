<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title> Registration Fee </title>
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
							<h1 class="m-0">Registration Fee</h1>
						</div><!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
							  <li class="breadcrumb-item"><a href="#">Apply Membership</a></li>
							  <li class="breadcrumb-item"><a href="#">Payment Page</a></li>
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
									<h3 class="card-title">Fee Details</h3>
								</div>
								<div class="card-body">
									
			                            <form action="registerpay" method="post">

				                        <fieldset class="form-group">
										   <label>Fee ID</label>
										   <input type="hidden" value="<c:out value='${fee.feeid}' />" name="fid">
										   <span><c:out value='${fee.feeid}' /></span>
										</fieldset>
				
				                        <fieldset class="form-group">
										   <label>Fee Desciption</label>
										   <input type="hidden" value="<c:out value='${fee.feedesc}' />" name="fdesc">
										   <span><c:out value='${fee.feedesc}' /></span>
										</fieldset>
				                        
				                        <fieldset class="form-group">
										   <label>Fee Amount (RM)</label>
										   <input type="hidden" value="<c:out value='${fee.feeamount}' />" name="ramount">
										   <span><c:out value='${fee.feeamount}' /></span>
										</fieldset>
				                        
				                        <fieldset class="form-group">
				                             <input type="hidden" value="<c:out value='${member.memberid}' />" class="form-control" name="mid" required="required">
				                        </fieldset>
				                        
				                        <fieldset class="form-group">
				                             <input type="hidden" value="Completed" class="form-control" name="rstatus" required="required">
				                        </fieldset>
				                        
				                        
				
				                        <button type="submit" class="btn btn-success">Pay</button>
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