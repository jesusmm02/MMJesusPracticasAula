/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesús
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private final String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private final String[] errores = {"El nombre es obligatorio", "El usuario es obligatorio", "La contraseña es obligatoria", "Fecha de nacimiento incorrecta"};
    private Enumeration<String> parametros;

    private final String[] preferencias = {"Deportes", "Lectura", "Cine", "Viajes"};

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) { 
             /* TODO output your page here. You may use following sample code. */ 
             out.println("<!DOCTYPE html>"); 
             out.println("<html>"); 
             out.println("<head>"); 
             out.println("<title>Servlet Registro</title>"); 
             out.println("</head>"); 
             out.println("<body>"); 
             out.println("<h3>Tienes que ir al registro primero <a href=\"" + request.getContextPath() + "\">Men&uacute;</a></h3>");
             out.println("</body>"); 
             out.println("</html>"); 
         }
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");
            out.println("<link rel='stylesheet' href='CSS/Registro.css' type='text/css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Datos introducidos en el registro</h2>");
            
        // Buscamos el error en los datos de entrada 
        boolean hayError = false; // variable que me indicará si existe error
        int tipoError[] = new int[4];  // Array donde se almacenan los diferentes errores
        for (int i = 0; i < tipoError.length; i++) {
            tipoError[i] = -1;
        }

        parametros = request.getParameterNames();
        while (parametros.hasMoreElements()) {
            String nombre = parametros.nextElement();
            if (nombre.equals("Nombre") && request.getParameter(nombre).length() == 0) {
                hayError = true;
                tipoError[0] = 0;
            } else if (nombre.equals("Usuario") && request.getParameter(nombre).length() == 0) {
                hayError = true;
                tipoError[1] = 1;
            } else if (nombre.equals("Password") && request.getParameter(nombre).length() == 0) {
                hayError = true;
                tipoError[2] = 2;
            } else if (nombre.equals("dia")) {
                int diaEnt = Integer.parseInt(request.getParameter("dia"));
                int mesEnt = Integer.parseInt(request.getParameter("mes"));
                int yearEnt = Integer.parseInt(request.getParameter("anio"));
                try {
                    LocalDate fecha = LocalDate.of(yearEnt, mesEnt, diaEnt);

                } catch (DateTimeException e) {
                    hayError = true;
                    tipoError[3] = 3;
                }
            }

        }

        // Comprobamos la ausencia de errores
        if (!hayError) { // Escribimos lod datos del registro
            int camposFecha = 0;
            out.println("<div id='contenido'>");
            out.println("<h2>Registro satisfactorio</h2>");
            StringBuilder fecha = new StringBuilder("Fecha de nacimiento: <strong>");
            Map<String, String[]> mapa = request.getParameterMap();
            // Recorriendo el Map con Iterator

            Iterator<Map.Entry<String, String[]>> entries = mapa.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String[]> entrada = entries.next();
                if (!entrada.getKey().startsWith("env")) {

                    if (entrada.getKey().equals("dia") || entrada.getKey().equals("mes") || entrada.getKey().equals("anio")) {
                        camposFecha++;
                        if (entrada.getKey().equals("mes")) {
                            for (String valor : entrada.getValue()) {
                                fecha.append(meses[Integer.parseInt(valor) - 1]);
                            }

                        } else {

                            for (String valor : entrada.getValue()) {
                                fecha.append(valor);
                            }
                        }
                        fecha.append(" de ");
                    }

                    if (camposFecha < 1 || camposFecha > 3) {
                        out.println("<p>" + entrada.getKey() + ": <strong>");
                        StringBuilder sb = new StringBuilder();
                        for (String valor : entrada.getValue()) {
                            sb.append(valor).append(", ");

                        }
                        out.println(sb.replace(sb.length() - 2, sb.length(), "</strong>") + "</p>");
                    } else {
                        if (camposFecha == 3) {
                            out.println("<p>" + fecha.replace(fecha.length() - 4, fecha.length(), "</strong>") + "</p>");
                            camposFecha++;
                        }
                    }
                }

            }
            out.println("<br />");
            out.println("<p><a href='" + request.getContextPath() + "'>Men&uacute; inicial</a></p>");
            out.println("</div>");

        } else { // En el caso de que existan errores
            // Mostramos la capa de con los errores producidos
            out.println("<div id='errores'>");
            out.println("<h3>Problemas con el registro</h3>");

            for (int i = 0; i < tipoError.length; i++) {
                out.println("<p class=\"error\">");

                if (tipoError[i] != -1) {
                    out.println(errores[tipoError[i]]);
                    out.println("</p>");
                }
            }
            out.println("</div>");

            // A continuación mostramos el formulario de entrada con los datos que introdujo el usuario
            out.println("<div id='contenido'>");
            out.println("<form action=\"NuevoRegistro\" method=\"post\">");
            out.println("<fieldset>");
            out.println("<legend>Información personal</legend>");
            out.println("<table>");
            out.println("<tr>");

            out.println("<td><label for=\"nb\">* Nombre:</label></td>");
            out.println("<td colspan=\"2\"><input type=\"text\" name=\"Nombre\" "
                    + "id=\"nb\" value=\"" + request.getParameter("Nombre") + "\" /></td>");
            out.println("</tr>");
            out.println("<tr>");

            out.println("<td><label for=\"ap\">Apellidos:</label></td>");
            out.println("<td colspan=\"2\"><input type=\"text\" name=\"Apellidos\" "
                    + "id=\"ap\" value=\"" + request.getParameter("Apellidos") + "\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><label>Sexo:</label></td>");
            String campoSexo = null;
            if (request.getParameter("Sexo") != null) {
                if (request.getParameter("Sexo").equals("Hombre")) {
                    campoSexo = "value=\"Hombre\" checked=\"checked\" /></td><td>Hombre</td></tr><tr><td>&nbsp;</td><td><input type=\"radio\" name=\"Sexo\" "
                            + "value=\"Mujer\" /></td><td>Mujer</td></tr>";

                } else {
                    campoSexo = "value=\"Hombre\" /></td><td>Hombre</td></tr><tr><td>&nbsp;</td><td><input type=\"radio\" name=\"Sexo\" "
                            + "value=\"Mujer\" checked=\"checked\"/></td><td>Mujer</td></tr>";

                }
            }
            out.println("<td><input type=\"radio\" name=\"Sexo\" " + campoSexo);
            out.println("<tr>");
            out.println("<td><label>Fecha de nacimiento:</label></td>");
            out.println("<td colspan=\"2\">");
            out.println("<select name=\"dia\">");
            int dia = Integer.parseInt(request.getParameter("dia"));
            for (int i = 1; i < 32; i++) {
                String valor = (dia == i) ? "selected=\"selected\"" : "";
                out.println("<option value=\"" + i + "\"" + valor + ">" + i + "</option>");
            }
            out.println("</select>");
            out.println(" / ");
            out.println("<select name=\"mes\">");
            int mes = Integer.parseInt(request.getParameter("mes"));
            for (int i = 1; i < 13; i++) {
                String valor = (mes == i) ? "selected=\"selected\"" : "";
                out.println("<option value=\"" + i + "\"" + valor + ">" + i + "</option>");
            }
            out.println("</select>");
            out.println(" / ");
            out.println("<select name=\"anio\">");
            int anio = Integer.parseInt(request.getParameter("anio"));
            for (int i = 1950; i < 2015; i++) {
                String valor = (anio == i) ? "selected=\"selected\"" : "";
                out.println("<option value=\"" + i + "\"" + valor + ">" + i + "</option>");
            }
            out.println("</select>");
            out.println("</td>");

            out.println("</tr>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("<p>&nbsp;</p>");
            out.println("<fieldset>");
            out.println("<legend>Datos de acceso</legend>");
            out.println("<table>");
            out.println("<tr>");

            out.println("<td><label for=\"usu\">* Usuario:</label></td>");
            out.println("<td colspan=\"2\"><input type=\"text\" name=\"Usuario\" "
                    + "id=\"usu\" value=\"" + request.getParameter("Usuario") + "\" /></td>");
            out.println("</tr>");
            out.println("<tr>");

            out.println("<td><label for=\"pass\">* Contraseña:</label></td>");
            out.println("<td colspan=\"2\"><input type=\"password\" name=\"Password\" "
                    + "id=\"pass\" value=\"" + request.getParameter("Password") + "\" /></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("<p>&nbsp;</p>");
            out.println("<fieldset>");
            out.println("<legend>Información general</legend>");
            out.println("<table>");
            StringBuilder sb = new StringBuilder("<tr><td><label>Preferencias:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td></tr>");
            String[] prefes = request.getParameterValues("Preferencias");

            int indi = 0;
            for (int i = 0; i < preferencias.length; i++) {

                sb.append("<tr>");

                int encontrado = -1;
                if (prefes != null) {
                    for (String opcion : prefes) {
                        if (opcion.equals(preferencias[i])) {
                            encontrado = i;
                            break;
                        }
                    }
                }
                String valor = (encontrado != -1) ? "checked=\"checked\"" : "";

                sb.append("<td><input type=\"checkbox\" name=\"Preferencias").append("\" " + "value=\"").append(preferencias[indi]).append("\" ").append(valor).append(" /></td><td>").append(preferencias[indi]).append("</td></tr>");
                indi++;
            }
            out.println(sb.toString());
            out.println("</table>");
            out.println("</fieldset>");
            out.println("<p>&nbsp;</p>");
            out.println("<table class=\"pie\">");
            out.println("<tr>");
            out.println("<td><input type=\"submit\" name=\"enviar\" value=\"Enviar\" /></td>");
            out.println("<td><input type=\"button\" name=\"limpiar\" value=\"Limpiar\" onClick=\"location.href='" + request.getContextPath() + "/html/registro.html';\"/></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</div>");

        }

    }

//    private boolean fechaCorrecta(String d, String m, String a) {
//
//        boolean correcto = true;
//        int dia = Integer.parseInt(d);
//        int mes = Integer.parseInt(m);
//        int anio = Integer.parseInt(a);
//        int diasMes = 0;
//        int bisi = 0;
//        int[] numDiasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//
//        if (esBisiesto(anio) && mes == 2) {
//            bisi = 1;
//        }
//        diasMes = numDiasMes[mes - 1] + bisi;
//        if (dia > diasMes) {
//            correcto = false;
//        }
//
//        return correcto;
//    }
//
//    private boolean esBisiesto(int anio) {
//        boolean anioBisiesto = false;
//        if ((anio % 100 != 0 || anio % 400 == 0) && anio % 4 == 0) {
//            anioBisiesto = true;
//        }
//        return anioBisiesto;
//    }

}

}
