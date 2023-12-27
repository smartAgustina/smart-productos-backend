package com.smart.smartproductospet.servicios;
import org.springframework.stereotype.Service;

import com.smart.smartproductospet.dto.EmailContactoRequest;
import com.smart.smartproductospet.helpers.MailManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactoEmailService {

private final MailManager mailManager;

    public void enviarEmail(EmailContactoRequest request) {
      mailManager.enviarEmail(request);
    }

}
