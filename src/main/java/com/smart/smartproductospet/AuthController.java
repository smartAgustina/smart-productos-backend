package com.smart.smartproductospet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.smartproductospet.dto.AuthResponseDto;
import com.smart.smartproductospet.dto.LoginRequestDto;
import com.smart.smartproductospet.dto.RegisterRequestDto;
import com.smart.smartproductospet.servicios.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping (value = "register")
     public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto request){
         return ResponseEntity.ok(authService.register(request));
     }



}
