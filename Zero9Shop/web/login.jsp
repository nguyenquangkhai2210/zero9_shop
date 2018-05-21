<%-- 
    Document   : login
    Created on : May 17, 2018, 2:59:22 PM
    Author     : THANH HUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/paper-dashboard.css">
        <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
    </head>
    <body>
        <div>
            <%@include file="header.jsp" %>
        </div>
        <div class="col-lg-12 d-flex justify-content-center align-items-center" style="height: 53em;">
            <div class="card bg-light col-lg-4">
                <div class="card-body">
                    <div class="card-header text-center bg-light">
                        <h3>Login to website</h3>
                    </div>
                    <form class="px-4 py-3" method="POST" action="MainControllerServlet">
                        <div class="form-group">
                            <label>Username</label>
                            <input type="text" class="form-control" placeholder="hungpt" name="txtUsername" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleDropdownFormPassword1">Password</label>
                            <input type="password" class="form-control" placeholder="Password" name="txtPassword" required>
                        </div>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input">
                            <label class="form-check-label">
                                Remember me
                            </label>
                        </div>
                        <div class="col-lg-12 d-flex justify-content-center pt-3">
                            <button type="submit" class="btn btn btn-primary col-lg-60" value="Login" name="btAction">Login</button>
                        </div>
                    </form>
                    <div class="dropdown-divider"></div>
                    <div class="row d-flex justify-content-center col-lg-12">
                        <button type="button" class="btn btn-danger mr-2">Forgot password?</button>
                        <a href="signUp.jsp" class="btn btn-success">Sign Up</a>
                    </div>
                </div>
            </div>
    </body>
</html>
