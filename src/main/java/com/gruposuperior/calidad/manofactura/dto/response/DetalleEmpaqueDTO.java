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

    @NotBlank
    private Double datoPesoGalletaRota;

    @NotBlank
    private Double datoGalletaRotaCalculado;

    @NotBlank
    private Double datoPesoPrimarioGalletaRota;

    @NotBlank
    private String datoPesoPrimarioHermeticidad;

    private int idControlEmpaqueCabecera;

    public DetalleEmpaqueDTO() {
    }

    public DetalleEmpaqueDTO(int idParametro, Double datoPesoPrimario, Double datoPesoSecundario, Double datoPesoCorrugado, Double datoPesoGalletaRota, Double datoGalletaRotaCalculado, Double datoPesoPrimarioGalletaRota, int idControlEmpaqueCabecera) {
        this.idParametro = idParametro;
        this.datoPesoPrimario = datoPesoPrimario;
        this.datoPesoSecundario = datoPesoSecundario;
        this.datoPesoCorrugado = datoPesoCorrugado;
        this.datoPesoGalletaRota = datoPesoGalletaRota;
        this.datoGalletaRotaCalculado = datoGalletaRotaCalculado;
        this.datoPesoPrimarioGalletaRota = datoPesoPrimarioGalletaRota;
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

    public String getDatoPesoPrimarioHermeticidad() {
        return datoPesoPrimarioHermeticidad;
    }

    public void setDatoPesoPrimarioHermeticidad(String datoPesoPrimarioHermeticidad) {
        this.datoPesoPrimarioHermeticidad = datoPesoPrimarioHermeticidad;
    }

    public Double getDatoPesoGalletaRota() {
        return datoPesoGalletaRota;
    }

    public void setDatoPesoGalletaRota(Double datoPesoGalletaRota) {
        this.datoPesoGalletaRota = datoPesoGalletaRota;
    }

    public Double getDatoGalletaRotaCalculado() {
        return datoGalletaRotaCalculado;
    }

    public void setDatoGalletaRotaCalculado(Double datoGalletaRotaCalculado) {
        this.datoGalletaRotaCalculado = datoGalletaRotaCalculado;
    }

    public Double getDatoPesoPrimarioGalletaRota() {
        return datoPesoPrimarioGalletaRota;
    }

    public void setDatoPesoPrimarioGalletaRota(Double datoPesoPrimarioGalletaRota) {
        this.datoPesoPrimarioGalletaRota = datoPesoPrimarioGalletaRota;
    }
}
