package com.smart.smartproductospet.servicios;

import java.util.Date;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.smartproductospet.dto.AuthResponseDto;
import com.smart.smartproductospet.dto.RegisterRequestDto;
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
       
        Usuario usuario = Usuario.builder()
        .id(userRequest.getId())
        .mail(userRequest.getMail())
        .nombre(userRequest.getNombre())
        .apellido(userRequest.getApellido())
        .dni(userRequest.getDni())
        .telefono(userRequest.getTelefono())
        .password(passwordEncoder.encode(userRequest.getPassword()))
        .build();

        usuarioRepository.actualizarUsuario(usuario.getId(),usuario.getMail(), usuario.getNombre(), usuario.getApellido(), usuario.getDni(), usuario.getTelefono(), usuario.getPassword());

        return new UsuarioResponseDto("El usuario se actualizó correctamente");
    }

 public AuthResponseDto register(RegisterRequestDto request){
    
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
