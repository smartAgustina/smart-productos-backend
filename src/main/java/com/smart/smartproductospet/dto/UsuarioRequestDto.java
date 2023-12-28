package com.smart.smartproductospet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDto {
    private Integer id;
    private String mail;
	private String password;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
}
