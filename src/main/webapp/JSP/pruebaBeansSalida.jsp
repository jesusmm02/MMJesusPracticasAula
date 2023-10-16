<%@page import="es.albarregas.beans.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salida</title>
    </head>
    <body>
        <h1>Ejemplos de atributos</h1>
        <h2>De petición</h2>
        <%
            Persona persona = null;
            persona = (Persona)request.getSession().getAttribute("personaPeticion");
        %>
        <ul>
            <li><%=persona.getNombre() %></li>
            <li><%=persona.getApellidos() %></li>
            <li><%=persona.getNumHijos() %></li>
            <li><%=persona.getSalario() %></li>
        </ul>
    </body>
</html>
