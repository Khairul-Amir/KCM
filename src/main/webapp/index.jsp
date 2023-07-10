<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<style><%@include file="/dist/css/loginpage.css"%></style>
</head>
<body>
<div class="row" align="left">
    <div class="col-md-6 mx-auto p-0">
        <div class="card">
            <div>
                <div class="login-snip"><input id="tab-2" type="radio" name="tab" class="sign-up" checked><label for="tab-2" class="tab">Welcome To KCM MEMBERSHIP MANAGEMENT SYSTEM</label>
                    <div class="login-space">
                        <div class="sign-up-form">
							<form action="loginmember" method="POST">
                            <div class="group"> <label for="user" class="label">Member IC</label> 
							<input id="user" type="text" name="ic" class="input" placeholder="Insert Member IC"> </div>
                            <div class="group"> <label for="pass" class="label">Password</label>
							<input id="pass" type="password" name="pass" class="input" data-type="password" placeholder="Insert Password"> </div>
							<div class="group"> <input type="submit" class="button" value="Log In" name="staff"> </div>
                            <div class="hr"></div>
							</form>
                            <p><a href="apply_new_member.jsp">Apply Membership</a></p>
                            <p><a href="adminlogin.jsp">Log In As Admin</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>