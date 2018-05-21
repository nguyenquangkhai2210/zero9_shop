<%-- 
    Document   : product
    Created on : May 17, 2018, 11:36:48 PM
    Author     : THANH HUNG
--%>

<%@page import="shop.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Order Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/paper-dashboard.css">
        <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
    </head>
    <body>

        <div class="row mr-0 ml-0">
            <%@include file="sidebar.jsp" %>
            <div class="col-lg-10 col-md-7">
                <%@include file="header.jsp" %>
                <div class="card">
                    <div class="header">
                        <h4 class="title">Change Password</h4>
                    </div>
                    <div class="row col-lg-12 mr-0 ml-0 pl-2 pr-2 pb-2 content d-flex justify-content-center">
                        <form class="form" autocomplete="off" method="POST" action="MainControllerServlet">
                            <div class="form-group row">
                                <label>Current Password</label>
                                <input type="password" class="form-control" name="txtPassword" required="">
                            </div>
                            <div class="form-group row">
                                <label for="inputPasswordNew">New Password</label>
                                <input type="password" class="form-control"  name="txtNewPass" required="">
                                <!-- <span class="form-text small text-muted">
                                    The password must be 8-20 characters, and must
                                    <em>not</em> contain spaces.
                                </span> -->
                            </div>
                            <div class="form-group row">
                                <label for="inputPasswordNewVerify">Verify</label>
                                <input type="password" class="form-control" required="">
                                <!-- <span class="form-text small text-muted">
                                    To confirm, type the new password again.
                                </span> -->
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success btn-lg float-right" value="ChangePassword" name="btAction">Change Password</button>
                            </div>
                        </form>
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
