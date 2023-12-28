package com.smart.smartproductospet.servicios;
import java.util.Date;
import java.util.Optional;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.smartproductospet.dto.AuthResponseDto;
import com.smart.smartproductospet.dto.LoginRequestDto;
import com.smart.smartproductospet.dto.RegisterRequestDto;
import com.smart.smartproductospet.entidades.Usuario;
import com.smart.smartproductospet.enums.Rol;
import com.smart.smartproductospet.excepciones.AuthenticationFailedException;
import com.smart.smartproductospet.jwt.JwtService;
import com.smart.smartproductospet.repositorios.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;
    
    public AuthResponseDto register(RegisterRequestDto request){
    Optional<Usuario> usuarioEncontrado = usuarioRepository.findByMail(request.getMail());
    if (usuarioEncontrado.isPresent()) {
            throw new IllegalArgumentException("Ya se encuentra registrado un usuario con ese email.");
    }
    Usuario usuario = Usuario.builder()
       .mail(request.getMail())
       .password(passwordEncoder.encode(request.getPassword()))
       .nombre(request.getNombre())
       .apellido(request.getApellido())
       .dni(request.getDni())
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
      try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getMail(), request.getPassword()));
        UserDetails usuario = usuarioRepository.findByMail(request.getMail()).orElseThrow();
        String token = jwtService.getToken(usuario);
        return AuthResponseDto.builder()
            .token(token)
            .build();
    } catch (BadCredentialsException e) {
        throw new AuthenticationFailedException("No se pudo iniciar sesión con los datos ingresados. Por favor, verifíquelos e inténtelo de nuevo..");
    }
    }


}
