<%-- 
    Document   : sidebar
    Created on : May 19, 2018, 10:57:40 PM
    Author     : THANH HUNG
--%>

<%@page import="shop.employee.EmployeeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        EmployeeDTO loginUser = (EmployeeDTO) session.getAttribute("loginUser");
    %>
    <body>
        <div class="nav flex-column col-xl-2 border-right pr-0" style="height:100vh; overflow: hidden;">
            <div class="align-self-center mt-3">
                <h4>
                    <a href="" class="navbar-brand">ZERO_9 SHOP</a>
                </h4>
            </div>
            <div class="ml-3">
                <hr size="1">
            </div>
            <div class="nav flex-column">
                <div class="align-self-center pl-3">
                    <img src="svg/admin.svg" alt="" class="rounded-circle border border-secondary mb-3 ml-4" style="width: 100px ; height: 100px;">
                    <br>
                    <div class="d-flex justify-content-center mt-2 mb-2 ">
                        <div class="btn-group">
                            <button type="button" class="btn btn-secondary  col-lg-12" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                <i class="ti-user pl-0">Welcome <%= loginUser.getEmpUsername()%></i>
                            </button>
                        </div>
                    </div>
                    <div class="collapse text-center" id="collapseExample">
                        <a class="dropdown-item btn" href="ViewProfileEmployeeServlet?idEmp=<%= loginUser.getEmpId()%>">View Profile</a>
                        <a class="dropdown-item btn" href="changePw.jsp">Change Password</a>
                        <a class="dropdown-item btn" href="MainControllerServlet?btAction=Logout">Logout!</a>
                    </div>
                </div>
                <div class="ml-3">
                    <hr size="1">
                </div>
                <ul class="nav flex-column pl-3">
                    <li class="nav-item">
                        <h5>
                            <a class="nav-link" href="MainControllerServlet?btAction=Order">
                                <i class="ti-gift mr-3"></i>
                                Order</a>
                        </h5>
                    </li>
                    <li class="nav-item">
                        <h5>
                            <a class="nav-link" href="MainControllerServlet?btAction=Product">
                                <i class="ti-save-alt mr-3"></i>
                                Product</a>
                        </h5>
                    </li>
                    <li class="nav-item">
                        <h5>
                            <a class="nav-link" href="MainControllerServlet?btAction=Customer">
                                <i class="ti-user mr-3"></i>
                                Customer</a>
                        </h5>
                    </li>
                    <li class="nav-item">
                        <h5>
                            <a class="nav-link" href="MainControllerServlet?btAction=Employee">
                                <i class="ti-stamp mr-3"></i>
                                Employee</a>
                        </h5>
                    </li>
                    <li class="nav-item">
                        <h5>
                            <a class="nav-link" href="MainControllerServlet?btAction=Promotion">
                                <i class="ti-heart mr-3"></i>
                                Promotion</a>
                        </h5>
                    </li>
                    <li class="nav-item align-self-stretch">
                        <h5>
                            <a class="nav-link" href="#">
                                <i class="ti-help-alt mr-3"></i>
                                Version 1.0.4</a>
                        </h5>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>