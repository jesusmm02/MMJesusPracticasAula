<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Establecer una cookie con información
    String nombre = "miCookie";
    String valor = "Información de la cookie";
    int caducidadSegundos = 3600;
    boolean segura = false;
    int version = 0;

    // Crear la cookie
    Cookie cookie = new Cookie(nombre, valor);
    cookie.setMaxAge(caducidadSegundos);
    cookie.setSecure(segura);
    cookie.setVersion(version);
%>
<!DOCTYPE html>
<html>
<body>
    <p>Veces que has visitado la p&aacute;gina: <span id="visitas">0</span></p>
    <ul>
        <li>Nombre: <%= nombre %></li>
        <li>Valor: <%= valor %></li>
        <li>Caducidad: <%= caducidadSegundos %></li>
        <li>Segura: <%= segura %></li>
        <li>Versi&oacute;n: <%= version %></li>
    </ul>
    <a href="cookies.html">Volver a la página principal</a>
</body>
</html>