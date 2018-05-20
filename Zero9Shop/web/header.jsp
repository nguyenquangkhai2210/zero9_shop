<%-- 
    Document   : header
    Created on : May 19, 2018, 10:32:21 PM
    Author     : THANH HUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="d-flex justify-content-end mt-2 mb-2 pr-1 pl-3 col-xs-12">
            <div class="btn-group text-center col-4 col-lg-2 col-xs-4 ">
                <button type="button" class="btn btn-secondary dropdown-toggle  col-lg-12" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Welcome <%
                        out.println(session.getAttribute("username"));
                    %>
                </button>
                <form method="GET" action="MainControllerServlet">
                    <div class="dropdown-menu dropdown-menu-right col-lg-11 ml-3 text-center">
                        <button class="dropdown-item" type="button">View Profile</button>
                        <a class="dropdown-item btn" href="changePw.jsp">Change Password</a>
                        <button class="dropdown-item" type="submit" name="btAction" value="Logout">Logout!                                
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
