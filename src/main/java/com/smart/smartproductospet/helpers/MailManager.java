package com.smart.smartproductospet.helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.smart.smartproductospet.dto.EmailContactoRequest;
import com.smart.smartproductospet.utils.TemplateConsultaEmailHTML;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailManager {

    private final JavaMailSender javaMailSender;
    
    @Value("${spring.mail.username}")
    private String sender;

    public void enviarEmail(EmailContactoRequest request) {
       JavaMailSenderImpl mailSenderImpl = (JavaMailSenderImpl) javaMailSender;
       MimeMessage mensaje = new MimeMessage(mailSenderImpl.getSession());
       try{    
        MimeMessageHelper helper = new MimeMessageHelper(mensaje, true); // Usa MimeMessageHelper
        helper.setSubject("Recibimos tu consulta de Smart Productos Pet:");
        helper.setText(TemplateConsultaEmailHTML.createEmail(request.getNombreYApellido(), request.getMensaje()), true); // Establece el contenido HTML correctamente
        helper.setTo(request.getEmail());
        helper.setFrom(sender);
        javaMailSender.send(helper.getMimeMessage());
       } catch(MessagingException e){
            throw new RuntimeException(e);
       }
    }

}
