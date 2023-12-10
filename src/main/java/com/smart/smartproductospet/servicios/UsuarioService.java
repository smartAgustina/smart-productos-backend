package com.smart.smartproductospet.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;
import com.smart.smartproductospet.repositorios.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import com.smart.smartproductospet.dto.LoginRequestDto;
import com.smart.smartproductospet.dto.LoginResponseDto;
import com.smart.smartproductospet.dto.UsuarioDto;
import com.smart.smartproductospet.entidades.Usuario;
import com.smart.smartproductospet.excepciones.BDException;
import com.smart.smartproductospet.helpers.JWTTokenHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private static final Logger log = LogManager.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public LoginResponseDto validarLogin(LoginRequestDto loginDto) throws Exception {
		try {
			Usuario usuario = validarLoginLocal(loginDto);

			actualizarUltimoAcceso(usuario);
			List<Long> idsPermisos = new ArrayList<>();

			String token = JWTTokenHelper.generarTokenSesion(usuario.getIdUsuario().toString());

			LoginResponseDto dto = new LoginResponseDto();
			dto.setMail(usuario.getMail());
			dto.setNombre(usuario.getNombre());
			dto.setToken(token);
			dto.setIdUsuario(usuario.getIdUsuario());
			dto.setPermisos(idsPermisos);

			return dto;
		} catch (BDException e) {
			log.error(e.getMessage());
			throw new BDException(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception(e.getMessage());
		}

	}
	
	private Usuario validarLoginLocal(LoginRequestDto loginDto) throws Exception {
		try {
			Optional<Usuario> usuario = Optional.empty();
			
			if (validarEmail(loginDto.getMail())) {
				 usuario = this.usuarioRepository.findUserByMail(loginDto.getMail());
			}
			Boolean esCorrecta = loginDto.getPassword().equals(usuario.get().getPassword());
			//Acá iría lógica de Hasheo de password.
			if (!esCorrecta) {
				throw new BDException("El usuario o contraseña es incorrecto", null);
			}
			return usuario.get();
		} catch (Exception e) {
			throw e;
		}
	}

	public Usuario crearUsuario(LoginRequestDto loginDto) throws Exception {
		Usuario usuario = new Usuario();
		if (loginDto.getMail().contains("@")) {
			usuario.setMail(loginDto.getMail());
			usuario.setPassword(loginDto.getPassword());
			
		}
		this.usuarioRepository.save(usuario);
		return usuario;
	}
	
	public Usuario actualizarInformacionUsuario(UsuarioDto usuarioDto) throws Exception {
		Optional<Usuario> usuario = this.usuarioRepository.findById(usuarioDto.getIdUsuario());
		
		this.usuarioRepository.save(usuario.get());
		return usuario.get();
	}

	private void actualizarUltimoAcceso(Usuario usuario) throws Exception {
		usuario.setUltimoAcceso(new Date());
		this.usuarioRepository.save(usuario);
	}

	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	private static boolean validarEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
	
	
}
