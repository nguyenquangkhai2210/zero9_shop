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
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/paper-dashboard.css">
        <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
    </head>
    <body>

        <div class="row mr-0 ml-0">
            <%@include file="sidebar.jsp" %>
            <div class="col-lg-10 ml-0 mr-0 pl-0 pr-0">
                <%@include file="header.jsp" %>

                <form class="d-flex justify-content-end mt-2 mb-2 pr-3">
                    <input class="form-control mr-sm-3  col-8 col-lg-1" type="search" placeholder="Search Name" aria-label="Search">
                    <button class="btn btn-outline-primary my-2 my-sm-0 ml-1" type="submit">Search</button>
                </form>
                <div class="row col-lg-12 mr-0 ml-0 pl-2 pr-2 table-responsive">
                    <div class="row col-lg-12 mr-0 ml-0 pl-0 pr-0 table-responsive">
                        <%   List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("ProductList");
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
                                    <!--<th scope="col">Decription</th>-->
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
                                        <%                                            out.print(x.getProName());
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
                                        <a class="badge-pill badge"> <%
                                            out.print(x.getProPrice() * 10);
                                            %> Point</a>
                                    </td>
                                    <!--                                    <td>
                                                                            Decription (chua lam)
                                                                        </td>-->
                                    <td>



                                        <form action="EditProductServlet" method="POST">
                                            <button class="btn btn-info btn-sm" value="<%= x.getProId() %>"
                                                    type="submit" name="idProduct">
                                                Edit</button>
                                        </form>
                                    </td>
                                </tr>
                                <%}
                                %> 
                            </tbody>
                        </table>
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
