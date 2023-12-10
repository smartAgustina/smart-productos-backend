package com.smart.smartproductospet.servicios;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.smart.smartproductospet.dto.AuthResponseDto;
import com.smart.smartproductospet.dto.LoginRequestDto;
import com.smart.smartproductospet.dto.RegisterRequestDto;
import com.smart.smartproductospet.entidades.Usuario;
import com.smart.smartproductospet.enums.Rol;
import com.smart.smartproductospet.jwt.JwtService;
import com.smart.smartproductospet.repositorios.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    private final JwtService jwtService;

    public AuthResponseDto register(RegisterRequestDto request) {
       Usuario usuario = Usuario.builder()
       .mail(request.getMail())
       .password(request.getPassword())
       .nombre(request.getNombre())
       .apellido(request.getApellido())
       .dni(request.getDNI())
       .telefono(request.getTelefono())
       .rol(Rol.USER)
       .ultimoAcceso(new Date())
       .build();

       usuarioRepository.save(usuario);
       return AuthResponseDto.builder()
       .token(jwtService.getToken(usuario))
       .build();
    }

    public AuthResponseDto login(LoginRequestDto request) {
        return null;
    }


}
