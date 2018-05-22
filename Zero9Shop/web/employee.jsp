<%-- 
    Document   : product
    Created on : May 17, 2018, 11:36:48 PM
    Author     : THANH HUNG
--%>

<%@page import="shop.employee.EmployeeDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Employee Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/paper-dashboard.css">
        <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
    </head>
    <body>
        <%
            List<EmployeeDTO> list = (List<EmployeeDTO>) request.getAttribute("EmployeeList");
        %>
        <div class="row mr-0 ml-0">
            <%@include file="sidebar.jsp" %>
            <div class="col-lg-10 col-md-7">
                <%@include file="header.jsp" %>

                <form class="d-flex justify-content-end mt-2 mb-2 pr-3" method="GET" action="MainControllerServlet">
                    <input class="form-control mr-sm-3  col-8 col-lg-1" type="search" placeholder="Search Name" aria-label="Search" autocomplete="off" name="txtSearch">
                    <button class="btn btn-outline-primary my-2 my-sm-0 ml-1" type="submit" value="SearchEmployee" name="btAction">Search</button>
                </form>
                <div class="row col-lg-12 mr-0 ml-0 pl-2 pr-2 pb-0 table-responsive content">
                    <div class="card mt-4">
                        <div class="header">
                            <h4 class="title">Employee</h4>
                        </div>
                        <div class="row col-lg-12 mr-0 ml-0 pl-2 pr-2 pb-0 table-responsive content">
                            <table class="table table-bordered table-hover text-center">
                                <thead class="thead-light">
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Gender</th>
                                        <th scope="col">Role</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%for (EmployeeDTO x : list) {
                                    %>
                                    <tr>        
                                        <th scope="row">
                                            <%= x.getEmpId()%>
                                        </th>
                                        <td class="text-left">
                                            <%=x.getEmpUsername()%>
                                        </td>
                                        <td class="text-left">
                                            <%=x.getEmpName()%>
                                        </td>
                                        <td class="text-left">

                                            <%= x.getEmpMail()%>

                                        </td>
                                        <td>
                                            <%= x.getEmpGender()%>

                                        </td>

                                        <td>
                                            <%= x.getRoleId()%>

                                        </td>
                                        <td>
                                            <form action="ViewProfileEmployeeServlet" method="POST">
                                                <button class="btn btn-info btn-sm" value="<%= x.getEmpId()%>"
                                                        type="submit" name="idEmp">
                                                    Profile</button>
                                            </form>
                                        </td>
                                    </tr>
                                    <%}

                                    %> 
                                </tbody>
                            </table>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item disabled">
                                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#">Next</a>
                                    </li>
                                </ul>
                            </nav>
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
