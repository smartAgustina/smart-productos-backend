package com.smart.smartproductospet.entidades;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String nombre;
	private String apellido;
	private String DNI;
	private Date fechaDeNacimiento; 
	private String perfil;
	private String telefono;
	private String mail;
	private String password;
	private Date ultimoAcceso;
	//private List<Direccion> direcciones;
	
	public Usuario () {
	}
	
	public Usuario(Integer id, String nombre, String apellido, String DNI, Date fechaDeNacimiento, String perfil, String telefono,
			String mail, String username, String password) {
		super();
		this.setIdUsuario(id);
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.perfil = perfil;
		this.telefono = telefono;
		this.mail = mail;
		this.password = password;
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
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
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

	public Integer getIdUsuario() {
		return id;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.id = idUsuario;
	}

	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}	
	
}
