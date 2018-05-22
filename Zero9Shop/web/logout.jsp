<%-- 
    Document   : logout
    Created on : May 22, 2018, 2:48:46 PM
    Author     : THANH HUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout!</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            if (session.getAttribute("loginUser") == null) {
        %>
        <%@include file="login.jsp" %>
        <%
        } else {
        %>
        <%@include file="order.jsp" %>
        <%
            }%>
    </body>
</html>
