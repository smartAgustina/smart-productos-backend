package com.smart.smartproductospet.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductoCarritoRequest implements Serializable {
    
    private String cantidad;
    private float precio;
    private String producto;
}
