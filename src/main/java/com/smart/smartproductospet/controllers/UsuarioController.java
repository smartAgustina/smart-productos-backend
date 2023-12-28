package com.smart.smartproductospet.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.smart.smartproductospet.dto.UsuarioDto;
import com.smart.smartproductospet.dto.UsuarioRequestDto;
import com.smart.smartproductospet.dto.UsuarioResponseDto;
import com.smart.smartproductospet.servicios.UsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    
    @GetMapping(value = "{id}")
    public ResponseEntity<UsuarioDto> getUser(@PathVariable Integer id)
    {
        UsuarioDto userDTO = usuarioService.obtenerUsuario(id);
        if (userDTO==null)
        {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping(value = "/updateUser")
    public ResponseEntity<UsuarioResponseDto> updateUser(@RequestBody UsuarioRequestDto userRequest)
    {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(userRequest));
    }

}
