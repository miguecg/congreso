<%-- 
    Document   : datos_de_registro
    Created on : 27-jun-2014, 13:57:08
    Author     : miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="congreso.beans.Participante" %>
<%@page import="congreso.beans.Deuda" %>
<%@page import="congreso.beans.Tipodeuda" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
           Long pr = Long.valueOf(request.getParameter("part"));
            
           Participante part = new Participante();
           part = part.selParticipante(pr);
           
           Deuda deud = new Deuda();
           List<Deuda> ded = deud.selDeudas(" Where deud_participante = '"+pr+"'");
           
           deud = ded.get(0);
           
           Tipodeuda td = new Tipodeuda();
           td = td.selTipodeuda(deud.getDeudTipo());
           
        %>
     <% if (deud.getDeudPagada().equals("N")) { %>   
       No. Deuda: <%= deud.getDeudaDeuda() %> <br/>
       Nombre: <%= part.getPartNombre()+" "+part.getPartApepat()+" "+part.getPartApemat() %><br/>
       Concepto a pagar: <%= td.getTideDescrip() %><br/>
       Monto: $<%= td.getTideMonto() %><br/>
     <% } else { %>
     <h3>Deuda Saldada!</h3>
     <% } %>
        
    </body>
</html>
