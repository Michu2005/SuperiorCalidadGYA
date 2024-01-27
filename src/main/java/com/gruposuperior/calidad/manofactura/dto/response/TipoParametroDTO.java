package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class TipoParametroDTO {
    private int id;
    @NotBlank
    private String tipo;

    public TipoParametroDTO() {
        super();
    }

    public TipoParametroDTO(int id, String tipo) {
        super();
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
