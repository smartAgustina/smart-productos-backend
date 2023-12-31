package com.smart.smartproductospet.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

	private Integer id;
	private String nombre;
	private String apellido;
	private String dni; 
	private String telefono;
	private String mail;
	private String password;
	private Date ultimoAcceso;
	
}
