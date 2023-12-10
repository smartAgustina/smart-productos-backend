package com.smart.smartproductospet.dto;

import java.io.Serializable;
import java.util.Date;


public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 9062961408595506567L;
	private Integer idUsuario;
	private String nombre;
	private String apellido;
	private String dni;
	private Date fechaDeNacimiento; 
	private String telefono;
	private String mail;
	private String password;
	private Date ultimoAcceso;
	
	public UsuarioDto(){
	}
	
	public UsuarioDto(Integer idUsuario, String nombre, String apellido, String dni,
		 String telefono, String mail, String password, Date ultimoAcceso) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.mail = mail;
		this.password = password;
		this.ultimoAcceso = ultimoAcceso;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}
	
}
