package com.smart.smartproductospet.utils;

public class TemplateConsultaEmailHTML {

public static String createEmail(String nombreYApellido, String mensaje){

    StringBuilder template = new StringBuilder( "<!DOCTYPE html>" +
    "<html lang=\"es\">" +
    "<head>" +
    "  <meta charset=\"UTF-8\">" +
    "  <title>Correo electrónico</title>" +
    "</head>" +
    "<body style=\"color: black;\">" +
    "  <header>" +
    "    <p>Hola "+ nombreYApellido + 
    ". Recibimos tu consulta:</p>" +
    "  </header>" +
    "  <main>" +
    "    <h4 style=\"color: black;\">" +
    "      <em>" + "'"+ mensaje + "'"+ "</em>" +
    "    </h4" +
    "  </main>" +
    "  <footer>" +
    "    <p style=\"color: black;\">" +
    "      Atentamente," +
    "      <br>" +
    "      El equipo de Smart Productos Pet" +
    "    </p>" +
    "  </footer>" +
    "</body>" +
    "</html>");
    
    return template.toString();
    }
}
