<%-- 
    Document   : sidebar
    Created on : May 19, 2018, 10:57:40 PM
    Author     : THANH HUNG
--%>

<%@page import="shop.employee.EmployeeDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <c:set var="loginUser" value="${sessionScope.loginUser}"/>
    <body>
        <div class="nav flex-column col-md-2 border-right pr-0"  style="height:100vh; overflow: hidden;">
            <div class="align-self-center mt-3 col-md-12">
                <h4 class="d-flex justify-content-center">
                    <a href="" class="navbar-brand">ZERO_9 SHOP</a>
                </h4>
                <div class="">
                    <hr size="1">
                </div>
                <div class="nav flex-column">
                    <div class="align-self-center">
                        <img src="svg/admin.svg" alt="" class="rounded-circle border border-secondary mb-3 ml-4" style="width: 100px ; height: 100px;">
                        <br>
                        <div class="d-flex justify-content-center mt-2 mb-2 ">
                            <div class="btn-group">
                                <button type="button" class="btn btn-secondary  col-lg-12" type="button" data-toggle="collapse" data-target="#collapseUser" aria-expanded="false" aria-controls="collapseUser">
                                    <i class="ti-user pl-0">Welcome ${loginUser.empUsername}</i>
                                </button>
                            </div>
                        </div>
                        <div class="collapse text-center" id="collapseUser">
                            <a class="dropdown-item btn" href="ViewProfileEmployeeServlet?idEmp=${loginUser.empId}">View Profile</a>
                            <a class="dropdown-item btn" href="changePw.jsp">Change Password</a>
                            <a class="dropdown-item btn" href="MainControllerServlet?btAction=Logout">Logout!</a>
                        </div>
                    </div>
                    <div class="">
                        <hr size="1">
                    </div>
                    <ul class="nav flex-column pl-3">
                        <li class="nav-item">
                            <h5>
                                <a class="nav-link" href="MainControllerServlet?btAction=Order">
                                    <i class="ti-gift mr-2"></i>
                                    Order</a>
                            </h5>
                        </li>
                        <li class="nav-item">
                            <h5>
                                <a class="nav-link" href="MainControllerServlet?btAction=Customer">
                                    <i class="ti-user mr-2"></i>
                                    Customer</a>
                            </h5>
                        </li>
                        <li class="nav-item d-flex">
                            <h5 class="form-inline">
                                <a class="nav-link" href="MainControllerServlet?btAction=Product">
                                    <i class="ti-save-alt mr-2"></i>
                                    Product
                                </a>
                                <a class="ti-angle-right mt-1 mr-1" data-toggle="collapse" data-target="#collapseProduct" aria-expanded="false" aria-controls="collapseProduct"></a>
                            </h5>
                            <div class="collapse text-center mt-1" id="collapseProduct">
                                <a class="dropdown-item  btn col-xl-12" href="#">Add product</a>
                            </div>
                        </li>
                        
                        <li class="nav-item d-flex">
                            <h5 class="form-inline">
                                <a class="nav-link" href="MainControllerServlet?btAction=Employee">
                                    <i class="ti-stamp mr-2"></i>
                                    Employee</a>
                                <a class="ti-angle-right mt-1 mr-1" data-toggle="collapse" data-target="#collapseEmployee" aria-expanded="false" aria-controls="collapseEmployee"></a>
                            </h5>
                            <div class="collapse text-center mt-1" id="collapseEmployee">                        
                                <a class="dropdown-item  btn col-xl-12" href="AddEmployeeServlet">Add employee</a>
                            </div>
                        </li>
                        <li class="nav-item d-flex">
                            <h5 class="form-inline">
                                <a class="nav-link" href="MainControllerServlet?btAction=Promotion">
                                    <i class="ti-heart mr-2"></i>
                                    Promotion</a>
                                <a class="ti-angle-right mt-1" data-toggle="collapse" data-target="#collapsePromotion" aria-expanded="false" aria-controls="collapsePromotion"></a>
                            </h5>
                            <div class="collapse text-center mt-1" id="collapsePromotion">
                                <a class="dropdown-item  btn col-xl-12" href="#">Add promotion</a>
                            </div>
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


        </div>
    </body>
</html>