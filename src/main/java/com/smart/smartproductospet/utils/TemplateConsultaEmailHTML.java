package com.smart.smartproductospet.utils;

public class TemplateConsultaEmailHTML {

public static String createEmail(String nombreYApellido, String mensaje){

  StringBuilder template = new StringBuilder( "<!DOCTYPE html>" +
    "<html lang=\"es\">" +
    "<head>" +
    "  <meta charset=\"UTF-8\">" +
    "  <title>Correo electrónico</title>" +
    "<style>" +
    "  body {" +
    "    font-family: Arial, sans-serif;" +
    "    font-size: 16px;" +
    "    background-color: #f5f5f5;" +
    "    color: #333;" +
    "    margin: 20px;" +
    "  }" +
    "  h1 {" +
    "    margin-top: 40px;" +
    "  }" +
    "  blockquote {" +
    "    border-left: 5px solid #ccc;" +
    "    padding: 10px 20px;" +
    "  }" +
    "  a {" +
    "    color: #007bff;" +
    "    text-decoration: underline;" +
    "  }" +
    "</style>" +
    "</head>" +
    "<body>" +
    "<header>" +
    "  <h2>Hola "+ nombreYApellido + ",</h2>" +
    "  <p>Recibimos tu consulta:</p>" +
    "</header>" +
    "<main>" +
    "  <blockquote>" +
    "    <em>" + mensaje + "</em>" +
    "  </blockquote>" +
    "</main>" +
    "<footer>" +
    "  <p>Atentamente,</p>" +
    "  <p>El equipo de Smart Productos Pet</p>" +
    "  <p><a href=\"#\">Visita nuestra web</a></p>" +
    "</footer>" +
    "</body>" +
    "</html>");

  return template.toString();
}
}