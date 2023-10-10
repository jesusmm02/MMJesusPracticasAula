<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("nombre");
            String sexo = request.getParameter("sexo");
        
            if(sexo.equals("Hombre")){
                out.print("Buenos dias senior " + nombre);
            }
            if(sexo.equals("Mujer")){
                out.print("Buenos dias seniora " + nombre);
            }
        %>
        
        /*
        String fecha = new Date();
            int hora = fecha.getHours();
        
            if(sexo.equals("Hombre") && hora >=4 && hora <=12 ){
                out.print("Buenos dias senior");
            }
            if(sexo.equals("Mujer") && hora >=4 && hora <=12 ){
                out.print("Buenos dias seniora");
            }
            if(sexo.equals("Hombre") && hora >=12 && hora <=21 ){
                out.print("Buenas tardes senior");
            }
            if(sexo.equals("Mujer") && hora >=12 && hora <=21 ){
                out.print("Buenas tardes seniora");
            }
            if(sexo.equals("Hombre") && hora >=21 && hora <=4 ){
                out.print("Buenas noches senior");
            }
            if(sexo.equals("Mujer") && hora >=21 && hora <=4 ){
                out.print("Buenas noches seniora");
            }
        */
    </body>
</html>
