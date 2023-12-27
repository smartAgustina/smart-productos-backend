package com.smart.smartproductospet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.smartproductospet.dto.EmailContactoRequest;
import com.smart.smartproductospet.servicios.ContactoEmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/contactoEmail")
@RequiredArgsConstructor
public class ContactoEmailController {

     private final ContactoEmailService contactoEmailService;

    @PostMapping(value = "enviarEmail")
    public ResponseEntity<Object> login(@RequestBody EmailContactoRequest request){
        contactoEmailService.enviarEmail(request);
        return ResponseEntity.ok().body("Hola");
    }
}
