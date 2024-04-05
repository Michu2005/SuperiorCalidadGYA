package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class DetalleEmpaqueHermeticidadDTO {

    @NotBlank
    private String datoHermeticidad;

    @NotBlank
    private Integer idGuardado;

    @NotBlank
    private Integer idControlEmpaqueCabecera;

    @NotBlank
    private Integer position;

    public DetalleEmpaqueHermeticidadDTO() {
    }

    public DetalleEmpaqueHermeticidadDTO(String datoHermeticidad, Integer idGuardado, Integer idControlEmpaqueCabecera, Integer position) {
        this.datoHermeticidad = datoHermeticidad;
        this.idGuardado = idGuardado;
        this.idControlEmpaqueCabecera = idControlEmpaqueCabecera;
        this.position = position;
    }

    public String getDatoHermeticidad() {
        return datoHermeticidad;
    }

    public void setDatoHermeticidad(String datoHermeticidad) {
        this.datoHermeticidad = datoHermeticidad;
    }

    public Integer getIdGuardado() {
        return idGuardado;
    }

    public void setIdGuardado(Integer idGuardado) {
        this.idGuardado = idGuardado;
    }

    public Integer getIdControlEmpaqueCabecera() {
        return idControlEmpaqueCabecera;
    }

    public void setIdControlEmpaqueCabecera(Integer idControlEmpaqueCabecera) {
        this.idControlEmpaqueCabecera = idControlEmpaqueCabecera;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
