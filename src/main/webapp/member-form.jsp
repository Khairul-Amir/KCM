<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Membership Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Membership Management </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Member</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${member != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${member == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${member != null}">
                                    Edit Member
                                </c:if>
                                <c:if test="${member == null}">
                                    Add New Member
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${member.memberid}' />" />
                        </c:if>
                        
                        
                        <fieldset class="form-group">
                            <label>Member Name</label> <input type="text" value="<c:out value='${member.membername}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Member Address</label> <input type="text" value="<c:out value='${member.memberaddress}' />" class="form-control" name="address">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Member Postcode</label> <input type="text" value="<c:out value='${member.memberpostcode}' />" class="form-control" name="postcode">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Member State</label> <input type="text" value="<c:out value='${member.memberstate}' />" class="form-control" name="state" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Member Phone No</label> <input type="text" value="<c:out value='${member.memberphoneno}' />" class="form-control" name="phoneno" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Member Gender</label> <input type="text" value="<c:out value='${member.membergender}' />" class="form-control" name="gender">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Member IC</label> <input type="text" value="<c:out value='${member.membericno}' />" class="form-control" name="icno">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Membership Status</label> <input type="text" value="<c:out value='${member.memberstatus}' />" class="form-control" name="status" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Member Password</label> <input type="text" value="<c:out value='${member.memberpassword}' />" class="form-control" name="password" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Member Type</label> <input type="text" value="<c:out value='${member.membertype}' />" class="form-control" name="type">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>