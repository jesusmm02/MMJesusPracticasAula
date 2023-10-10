<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            LocalDate hoy = LocalDate.now();
            String nombre = request.getParameter("nombre");
            String currentDate = new date();
            String date = request.getParameter("fecha");
            String edad = currentDate - date;
            
            out.print(nombre + "tiene" + edad);
        
        %>
    </body>
</html>
