package com.smart.smartproductospet.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smart.smartproductospet.dto.ProductoCarritoRequest;

@RestController
@RequestMapping("/api/compra")
@CrossOrigin(origins = {"http://localhost:3000"})
//@RequiredArgsConstructor
public class CompraController {



    @PostMapping(value = "agregarAlCarrito")
    public ResponseEntity<Object> agregarAlCarrito(@RequestBody ProductoCarritoRequest request){
        //contactoEmailService.enviarEmail(request);
        return ResponseEntity.ok().body("Hola");
    }

}
