<%@page import="es.albarregas.beans.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  Persona persona= new Persona();
  Persona persona1= new Persona("Pedro","Gonzalez", Byte.parseByte("0"), 2000.0);
  persona.setNombre("Juan");
  persona.setApellidos("Piñero");
  persona.setNumHijos(Byte.parseByte("2"));
  persona.setSalario(2100.50);
  

  request.getSession().setAttribute("persona", persona);
  
  request.setAttribute("personaPeticion", persona1);
  
  response.sendRedirect("pruebaBeansSalida.jsp");
%>