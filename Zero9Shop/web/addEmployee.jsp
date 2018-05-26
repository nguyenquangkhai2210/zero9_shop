<%-- 
    Document   : 
    Created on : May 20, 2018, 9:09:48 PM
    Author     : THANH HUNG
--%>
<%@page import="shop.employee.EmployeeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/paper-dashboard.css">
        <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
    </head>
    <body>

        <div class="row mr-0 ml-0">
            <%@include file="sidebar.jsp" %>
            <div class="col-lg-10 col-md-7">
                <div class="header">
                    <h4 class="title">Add Employee</h4>
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
                                    <h4 class="title"><br>
                                        <a href="#"><small>@</small></a>
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
                                            Employee
                                            <br><small>Role</small></h5>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <% String idEmp = (String) request.getAttribute("idEmp");
                        String date = (String) request.getAttribute("dateCurrent");
                    %>
                    <div class="col-lg-8 col-md-7">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Edit Profile</h4>
                            </div>
                            <div class="content">
                                <form method="POST" action="">
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>Employee ID</label>
                                                <input type="text" class="d-none" name="idEmp" value="">
                                                <input type="text" class="form-control border-input" disabled="" value="<%=idEmp%>">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Username</label>
                                                <input type="text" class="form-control border-input" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Full Name</label>
                                                <input type="text" class="form-control border-input" name="txtName" value="">
                                            </div>

                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Email address</label>
                                                <input type="email" class="form-control border-input" name="txtMail" value="">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" class="form-control border-input" name="txtAddress"  value="">
                                            </div>
                                        </div> 
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
                                                    <input type="text" class="form-control border-input" name="txtPhone" value="">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Started Day</label>
                                                    <input type="text" class="form-control border-input" disabled="" value="<%= date%>">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Birthday</label>
                                                <input type="date" class="form-control border-input" name="txtBirthdate" value="">
                                            </div>
                                        </div>

                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">Add Profile</button>
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
