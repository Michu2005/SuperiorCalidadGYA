package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class PerfilEmpleadoDTO {

    private int id;

    public PerfilEmpleadoDTO() {
        super();
    }

    public PerfilEmpleadoDTO(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
