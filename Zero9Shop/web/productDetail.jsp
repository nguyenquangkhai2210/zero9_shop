<%-- 
    Document   : promotion
    Created on : May 20, 2018, 9:09:48 PM
    Author     : THANH HUNG
--%>
<%@page import="shop.product.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product detail</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/paper-dashboard.css">
        <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
    </head>
    <body>
        <%
            ProductDTO x = (ProductDTO) request.getAttribute("productDetail");
        %>
        <div class="row mr-0 ml-0">
            <%@include file="sidebar.jsp" %>
            <div class="col-lg-10 col-md-7">
                <%@include file="header.jsp" %>
                <div class="card">
                    <div class="header">
                        <h4 class="title">Edit Product - <%= x.getProName() %></h4>
                    </div>
                    <div class="content">
                        <form>
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label>ID Product</label>
                                        <input type="text" class="form-control border-input" disabled="" placeholder="Company" value="<%= x.getProId()%>">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Product Name</label>
                                        <input type="text" class="form-control border-input" placeholder="Product Name" value="<%= x.getProName()%>">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Category</label>
                                        <input type="text" class="form-control border-input" placeholder="Category" value="<%= x.getCatelories()%>">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Price</label>
                                        <input type="text" class="form-control border-input" value="<%= x.getProPrice()%>">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Stock</label>
                                        <input type="text" class="form-control border-input" value="<%= x.getStock()%>">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Created Time</label>
                                        <input type="text" class="form-control border-input" value="<%= x.getCreatedTime()%>">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label>Status</label>
                                        <input type="text" class="form-control border-input" value="<%= x.isActive()%>">
                                    </div>
                                </div>
                                     <div class="col-md-2">
                                    <div class="form-group">
                                        <label>Sale off</label>
                                        <input type="text" class="form-control border-input" value="<%= x.getSaleOff() %>">
                                    </div>
                                </div>
                                    <div class="col-md-4">
                                    <div class="form-group">
                                        <label>ReservedPoint</label>
                                        <input type="text" class="form-control border-input" value="<%= x.getReservedPoint()%>">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6" style="height: 20vh;">
                                    <div>
                                        <label>Description</label>
                                        <textarea name="textarea" style="height:100px;" class="form-control border-input col-md-4"> <%= x.getProDescription()%></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-info btn-fill btn-wd">Update Product</button>
                            </div>
                            <div class="clearfix"></div>
                        </form>
                    </div>
                </div>
            </div> 

        </div>
    </body>
</html>
