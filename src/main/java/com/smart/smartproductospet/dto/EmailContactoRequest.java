package com.smart.smartproductospet.dto;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmailContactoRequest  implements Serializable{

    private String nombreYApellido;
    private String email;
    private String asunto;
    private String mensaje;
}
