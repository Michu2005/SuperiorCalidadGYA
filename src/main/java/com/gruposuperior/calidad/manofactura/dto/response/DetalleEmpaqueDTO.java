package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class DetalleEmpaqueDTO {

    @NotBlank
    private int idParametro;

    @NotBlank
    private Double datoPesoPrimario;

    @NotBlank
    private Double datoPesoSecundario;

    @NotBlank
    private Double datoPesoCorrugado;

    private Double datoPesoPrimarioHermeticidad;

    @NotBlank
    private int idControlEmpaqueCabecera;

    public DetalleEmpaqueDTO() {
    }

    public DetalleEmpaqueDTO(int idParametro, Double datoPesoPrimario, Double datoPesoSecundario, Double datoPesoCorrugado) {
        this.idParametro = idParametro;
        this.datoPesoPrimario = datoPesoPrimario;
        this.datoPesoSecundario = datoPesoSecundario;
        this.datoPesoCorrugado = datoPesoCorrugado;
        this.datoPesoPrimarioHermeticidad = datoPesoPrimarioHermeticidad;
        this.idControlEmpaqueCabecera = idControlEmpaqueCabecera;
    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public Double getDatoPesoPrimario() {
        return datoPesoPrimario;
    }

    public void setDatoPesoPrimario(Double datoPesoPrimario) {
        this.datoPesoPrimario = datoPesoPrimario;
    }

    public Double getDatoPesoSecundario() {
        return datoPesoSecundario;
    }

    public void setDatoPesoSecundario(Double datoPesoSecundario) {
        this.datoPesoSecundario = datoPesoSecundario;
    }

    public Double getDatoPesoCorrugado() {
        return datoPesoCorrugado;
    }

    public void setDatoPesoCorrugado(Double datoPesoCorrugado) {
        this.datoPesoCorrugado = datoPesoCorrugado;
    }

    public int getIdControlEmpaqueCabecera() {
        return idControlEmpaqueCabecera;
    }

    public void setIdControlEmpaqueCabecera(int idControlEmpaqueCabecera) {
        this.idControlEmpaqueCabecera = idControlEmpaqueCabecera;
    }

    public Double getDatoPesoPrimarioHermeticidad() {
        return datoPesoPrimarioHermeticidad;
    }

    public void setDatoPesoPrimarioHermeticidad(Double datoPesoPrimarioHermeticidad) {
        this.datoPesoPrimarioHermeticidad = datoPesoPrimarioHermeticidad;
    }


}
