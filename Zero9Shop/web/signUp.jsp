<%-- 
    Document   : signUp
    Created on : May 17, 2018, 3:45:17 PM
    Author     : THANH HUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        <div class="col-lg-12">
            <nav class="navbar navbar-expand-lg navbar-light col-lg-12" style="background-color: #e3f2fd;">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item ml-2">
                        <a class="navbar-brand" href="#">Zero9 Shop</a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="d-flex justify-content-center align-items-center col-lg-12" style="height: 53em;">
            <div class="card bg-light col-lg-4">
                <h1 class="font-weight-light text-center">Sign in with us</h1>
                <form action="SignUpServlet" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Email</label>
                            <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="txtEmail">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputPassword4">Password</label>
                            <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputCity">Username</label>
                            <input type="text" class="form-control" placeholder="userfu">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputAddress">Fullname</label>
                            <input type="text" class="form-control" id="inputAddress" placeholder="Phan Thanh Hung">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="inputCity">Phone</label>
                            <input type="text" class="form-control">
                        </div>
                        <div class="form-group col-md-6">
                            <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Gender</label>
                            <select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
                                <option selected>Choose...</option>
                                <option value="1">Male</option>
                                <option value="2">Female</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputAddress">Address</label>
                        <input type="text" class="form-control" id="inputAddress" placeholder="HCMC">
                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="gridCheck">
                            <label class="form-check-label" for="gridCheck">
                                Approve with us
                            </label>
                        </div>
                    </div>
                    <div class="row d-flex justify-content-center col-lg-12">
                        <button type="submit" class="btn btn-primary col-lg-6 mb-3">Sign up</button>
                    </div>
                </form>

                <div class="dropdown-divider"></div>
                <div class="row d-flex justify-content-center col-lg-12">
                    <a href="login.jsp"  class="btn btn-outline-success col-lg-6 mb-2" value="SignUp" name="btAction">Have account? Login</a>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>
</html>
