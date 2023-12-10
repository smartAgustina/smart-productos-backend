package com.smart.smartproductospet.dto;

import java.io.Serializable;

public class ComboDto implements Serializable {

    private static final long serialVersionUID = -8832304757925424839L;

    private String id;
    private String descripcion;

    public ComboDto() {

    }

    public ComboDto(String id, String descripcion) {
        this.setId(id);
        this.setDescripcion(descripcion);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
