package com.smart.smartproductospet.servicios;

import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.smartproductospet.dto.UsuarioDto;
import com.smart.smartproductospet.dto.UsuarioRequestDto;
import com.smart.smartproductospet.dto.UsuarioResponseDto;
import com.smart.smartproductospet.entidades.Usuario;
import com.smart.smartproductospet.enums.Rol;
import com.smart.smartproductospet.repositorios.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository; 

    private final PasswordEncoder passwordEncoder;

    public UsuarioResponseDto actualizarUsuario(UsuarioRequestDto userRequest) {
       
        Usuario usuarioExistente = usuarioRepository.findById(userRequest.getId()).get(); // Obtiene el usuario actual
        Rol rolActual = usuarioExistente.getRol(); // Guarda el rol actual

        Usuario usuario = Usuario.builder()
        .id(userRequest.getId())
        .mail(userRequest.getMail())
        .nombre(userRequest.getNombre())
        .apellido(userRequest.getApellido())
        .dni(userRequest.getDni())
        .ultimoAcceso(new Date())
        .telefono(userRequest.getTelefono())
        .rol(rolActual)
        .password(passwordEncoder.encode(userRequest.getPassword()))
        .build();

         usuarioRepository.save(usuario);
        return new UsuarioResponseDto("El usuario se actualizó correctamente");
    }


    public UsuarioDto obtenerUsuario(Integer id) {
        Usuario user= usuarioRepository.findById(id).orElse(null);
       
        if (user!=null)
        {
            UsuarioDto userDTO = UsuarioDto.builder()
            .id(user.getId())
            .mail(user.getMail())
            .nombre(user.getNombre())
            .apellido(user.getApellido())
            .dni(user.getDni())
            .telefono(user.getTelefono())
            .build();
            return userDTO;
        }
        return null;
    }
}
