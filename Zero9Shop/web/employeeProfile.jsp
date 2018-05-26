<%-- 
    Document   : productDetail
    Created on : May 20, 2018, 9:09:48 PM
    Author     : THANH HUNG
--%>
<%@page import="shop.employee.EmployeeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee profie</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/paper-dashboard.css">
        <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
    </head>
    <body>
        <c:set var="empProfile" value="${requestScope.employeeProfile}"/>
        <div class="row mr-0 ml-0">
            <%@include file="sidebar.jsp" %>
            <div class="col-lg-10 col-md-7">
                <div class="header">
                    <h4 class="title">Profile Employee</h4>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-5">
                        <div class="card card-user">
                            <div class="image">
                                <img src="img/background.jpg">
                            </div>
                            <div class="content">
                                <div class="author">
                                    <img class="avatar border-white" src="img/faces/face-2.jpg" >
                                    <h4 class="title"><c:out value="${empProfile.empName }"/><br>
                                        <a href="#"><small>@<c:out value="${empProfile.empUsername }"/></small></a>
                                    </h4>
                                </div>
                                <p class="description text-center">
                                    "I like the way you work it <br>
                                    No diggity <br>
                                    I wanna bag it up"
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <div class="row">

                                    <div class="col-md-12">
                                        <h5>

                                            <br><small>Role</small></h5>
                                    </div>
                                       
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile</h4>
                            </div>
                            <div class="content">
                                <form method="POST" action="UpdateProfileEmployeeServlet">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>Employee ID</label>
                                                <input type="text" class="d-none" name="idEmp" value="<c:out value="${empProfile.empId }"/>">
                                                <input type="text" class="form-control border-input" disabled="" value="<c:out value="${empProfile.empId }"/>">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Username</label>
                                                <input type="text" class="form-control border-input" disabled="" value="<c:out value="${empProfile.empUsername }"/>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Full Name</label>
                                                <input type="text" class="form-control border-input" name="txtName" value="<c:out value="${empProfile.empName}"/>">
                                            </div>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Email address</label>
                                                <input type="email" class="form-control border-input" name="txtMail" value="<c:out value="${empProfile.empMail }"/>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" class="form-control border-input" name="txtAddress"  value="<c:out value="${empProfile.emAddress }"/>">
                                            </div>
                                        </div> 
                                        <c:set var="gender" value="${empProfile.empGender}"/>

                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Gender</label>
                                                <br>
                                                <label class="radio-inline mr-2 mt-2"><input type="radio" name="chkGender" value="Male"  <c:if test="${gender == 'Male'}"> checked </c:if>>Male</label>
                                                <label class="radio-inline ml-2 mt-2"><input type="radio" name="chkGender" value="Female" <c:if test="${gender == 'Female'}"> checked </c:if>>Female</label>
                                                </div>

                                            </div> 
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Phone</label>
                                                    <input type="text" class="form-control border-input" name="txtPhone" value="<c:out value="${empProfile.empPhone }"/>">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Started Day</label>
                                                <input type="text" class="form-control border-input" disabled="" value="<c:out value="${empProfile.startDate }"/>">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Birthday</label>
                                                <input type="date" class="form-control border-input" name="txtBirthdate" value="<c:out value="${empProfile.empBirthdate }"/>">
                                            </div>
                                        </div>

                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">Update Profile</button>
                                        <button type="submit" class="btn btn-danger btn-fill btn-wd">Delete Profile</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
</html>
