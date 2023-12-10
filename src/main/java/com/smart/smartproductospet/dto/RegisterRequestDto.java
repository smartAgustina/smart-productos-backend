package com.smart.smartproductospet.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto implements Serializable 
{
    private String mail;
    private String password;
    private String nombre;
    private String apellido;
    private String DNI;
    private String telefono;
}
