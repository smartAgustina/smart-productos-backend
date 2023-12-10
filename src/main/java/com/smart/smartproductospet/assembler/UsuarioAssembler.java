package com.smart.smartproductospet.assembler;

import java.util.ArrayList;
import java.util.List;

import com.smart.smartproductospet.dto.UsuarioDto;
import com.smart.smartproductospet.entidades.Usuario;

public class UsuarioAssembler {

	public static UsuarioDto toDto(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setApellido(usuario.getApellido());
		usuarioDto.setDni(usuario.getDni());
		usuarioDto.setTelefono(usuario.getTelefono());
		usuarioDto.setMail(usuario.getMail());
		usuarioDto.setPassword(usuario.getPassword());
		usuarioDto.setUltimoAcceso(usuario.getUltimoAcceso());
		
		return usuarioDto;
	}

	public static Usuario toEntity(UsuarioDto dto) {
		Usuario usuario = new Usuario();
		usuario.setNombre(dto.getNombre());
		usuario.setApellido(dto.getApellido());
		usuario.setDni(dto.getDni());
		usuario.setTelefono(dto.getTelefono());
		usuario.setMail(dto.getMail());
		usuario.setPassword(dto.getPassword());
		usuario.setUltimoAcceso(dto.getUltimoAcceso());
		
		return usuario;
	}

	public static List<UsuarioDto> toListDto(List<Usuario> usuarios) {

		List<UsuarioDto> usuariosDto = new ArrayList<UsuarioDto>();
		for (Usuario usuario : usuarios) {
			UsuarioDto usuarioDto = UsuarioAssembler.toDto(usuario);
			usuariosDto.add(usuarioDto);
		}
		return usuariosDto;
	}

}
