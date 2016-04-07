<%-- 
    Document   : error
    Created on : 27-jun-2014, 13:47:38
    Author     : miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje:</title>
    </head>
    <body>
        
        <% 
           String msg = String.valueOf(request.getSession().getAttribute("error"));
        %>
        <h1><%= msg %></h1>
    </body>
</html>
