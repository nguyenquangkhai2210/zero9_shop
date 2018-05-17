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
        <title>Product Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        <div class="row col-lg-12 pr-0 mr-0">
            <nav class="navbar navbar-expand-lg navbar-light col-lg-12" style="background-color: #e3f2fd;">
                <button class="navbar-toggler col-lg-12" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                    Menu
                </button>
                <div class="collapse navbar-collapse col-lg-12" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="navbar-brand" href="#">Zero9 Shop</a>
                        </li>
                        <li class="nav-item d-block d-sm-none ">
                            <a class="nav-link" href="#">Dashboard </a>
                        </li>
                        <li class="nav-item d-block d-sm-none active">
                            <a class="nav-link" href="#">Order</a>
                        </li>
                        <li class="nav-item d-block d-sm-none">
                            <a class="nav-link" href="#">Customer</a>
                        </li>
                        <li class="nav-item d-block d-sm-none ">
                            <a class="nav-link" href="#">Employee</a>
                        </li>
                        <li class="nav-item d-block d-sm-none">
                            <a class="nav-link" href="#">Product</a>
                        </li>
                        <li class="nav-item d-block d-sm-none">
                            <a class="nav-link" href="#">Promotion</a>
                        </li>
                    </ul>
                    <button type="button" class="btn btn-primary col-lg-1"> Notification
                        <span class="badge badge-light">10</span>
                    </button>
                    <div class="btn-group text-center col-lg-2">
                        <button type="button" class="btn btn-secondary dropdown-toggle  col-lg-12" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Welcome , <%
                                out.println(session.getAttribute("username"));
                            %>
                        </button>
                        <form method="GET" action="MainControllerServlet">
                            <div class="dropdown-menu dropdown-menu-right col-lg-11 ml-3 text-center">
                                <button class="dropdown-item" type="button">View Profile</button>
                                <button class="dropdown-item" type="button" >Change Password</button>
                                <button class="dropdown-item" type="submit" name="btAction" value="Logout">Logout!                                
                                </button>
                            </div>
                        </form>

                    </div>
                </div>

            </nav>
        </div>
        <form class="form-inline d-flex justify-content-end mt-2 mr-4 mb-2">
            <input class="form-control mr-sm-3  col-8 col-lg-1" type="search" placeholder="Search ID" aria-label="Search">
            <button class="btn btn-outline-primary my-2 my-sm-0 ml-1" type="submit">Search</button>
        </form>
        <div class="row">
            <div class="col-lg-1 bg-light mr-0 ml-0 pl-0 d-none d-xl-block">
                <div class="col-lg-12 ml-0" style="height: 53em;">
                    <div class="list-group">
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light">Dashboard</a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light active">Order</a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light">Customer</a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light ">Employee</a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light">Product</a>
                        <a href="#" class="list-group-item list-group-item-action list-group-item-light">Promotion</a>

                    </div>
                </div>
            </div>
            <div class="col-lg-11 ml-0 mr-0 mt-2 pl-2 pr-2">
                <div class="row col-lg-12 table-responsive">
                    <div class="row col-lg-12 table-responsive">
                        <%
                            List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("ProductList");
                        %>
                        <table class="table table-bordered table-hover text-center">
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Stock</th>
                                    <th scope="col">Create Time</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Sale off</th>
                                    <th scope="col">Reserved Point</th>
                                    <th scope="col">Decription</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    for (ProductDTO x : list) {
                                %>
                                <tr>        
                                    <th scope="row">
                                        <%
                                            out.print(x.getProId());
                                        %>
                                    </th>
                                    <td>
                                        <%
                                            out.print(x.getProName());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            out.print(x.getProPrice());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            out.print(x.getStock());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            out.print(x.getCreatedTime());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if (x.isActive()) {
                                        %> 
                                        <span class="badge badge-success">Active</span>
                                        <%
                                        } else {
                                        %>
                                        <span class="badge badge-warning">Deactive</span>
                                        <%
                                            }
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            out.print(x.getSaleOff());
                                        %>
                                        %
                                    </td>
                                    <td>
                                        <a class="badge-info badge"> <%
                                            out.print(x.getReservedPoint());
                                            %> Point</a>
                                    </td>
                                    <td>
                                        Decription (chua lam)
                                    </td>
                                    <td>
                                        <span class="badge badge-info">Edit</span>
                                        <span class="badge badge-warning">Deactive</span>
                                    </td>
                                </tr>
                                <%}
                                %> 
                            </tbody>
                        </table>
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
