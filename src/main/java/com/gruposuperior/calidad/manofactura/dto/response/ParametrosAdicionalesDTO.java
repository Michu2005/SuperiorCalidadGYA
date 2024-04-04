package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class ParametrosAdicionalesDTO {

    @NotBlank
    private Integer idControlEmpaqueCabecera;
    private Integer idParametro;
    private Double datoParamAdicionales;

    public ParametrosAdicionalesDTO() {
    }

    public ParametrosAdicionalesDTO(Integer idControlEmpaqueCabecera, Double datoParamAdicionales) {
        this.idControlEmpaqueCabecera = idControlEmpaqueCabecera;
        this.datoParamAdicionales = datoParamAdicionales;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Integer getIdControlEmpaqueCabecera() {
        return idControlEmpaqueCabecera;
    }

    public void setIdControlEmpaqueCabecera(Integer idControlEmpaqueCabecera) {
        this.idControlEmpaqueCabecera = idControlEmpaqueCabecera;
    }

    public Double getDatoParamAdicionales() {
        return datoParamAdicionales;
    }

    public void setDatoParamAdicionales(Double datoParamAdicionales) {
        this.datoParamAdicionales = datoParamAdicionales;
    }

}
