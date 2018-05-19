<%-- 
    Document   : changepw
    Created on : May 19, 2018, 11:22:00 PM
    Author     : THANH HUNG
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Change Password</title>
            <link rel="stylesheet" href="css/bootstrap.css">
        </head>
        <%@include file="header.jsp" %>
            <div class="col-lg-2">
                <div class="card card-outline-secondary">
                    <div class="card-header">
                        <h3 class="mb-0">Change Password</h3>
                    </div>
                    <div class="card-body">
                        <form class="form" autocomplete="off" method="POST" action="MainControllerServlet">
                            <div class="form-group">
                                <label>Current Password</label>
                                <input type="password" class="form-control" name="txtPassword" required="">
                            </div>
                            <div class="form-group">
                                <label for="inputPasswordNew">New Password</label>
                                <input type="password" class="form-control"  name="txtNewPass" required="">
                                <!-- <span class="form-text small text-muted">
                                    The password must be 8-20 characters, and must
                                    <em>not</em> contain spaces.
                                </span> -->
                            </div>
                            <div class="form-group">
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

        </html>