package com.smart.smartproductospet.dto;

import java.io.Serializable;
import java.util.List;

public class LoginResponseDto implements Serializable {

	private static final long serialVersionUID = -7207832208772964282L;

	private String token;
	private Integer idUsuario;
	private String nombre;
	private String mail;
	private List<Long> permisos;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Long> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Long> permisos) {
		this.permisos = permisos;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}

