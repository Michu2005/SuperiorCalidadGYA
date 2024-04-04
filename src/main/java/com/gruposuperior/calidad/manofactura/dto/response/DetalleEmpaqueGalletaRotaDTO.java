package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class DetalleEmpaqueGalletaRotaDTO {

    @NotBlank
    private Integer idGuardado;

    @NotBlank
    private Double datoPesoGalletaRota;

    @NotBlank
    private Double datoPesoGalletaRotaCalculado;

    @NotBlank
    private Double datoPesoPrimarioGalletaRota;

    public DetalleEmpaqueGalletaRotaDTO() {
    }

    public DetalleEmpaqueGalletaRotaDTO(Integer idGuardado, Double datoPesoGalletaRota, Double datoPesoGalletaRotaCalculado, Double datoPesoPrimarioGalletaRota) {
        this.idGuardado = idGuardado;
        this.datoPesoGalletaRota = datoPesoGalletaRota;
        this.datoPesoGalletaRotaCalculado = datoPesoGalletaRotaCalculado;
        this.datoPesoPrimarioGalletaRota = datoPesoPrimarioGalletaRota;
    }

    public Double getDatoPesoGalletaRota() {
        return datoPesoGalletaRota;
    }

    public void setDatoPesoGalletaRota(Double datoPesoGalletaRota) {
        this.datoPesoGalletaRota = datoPesoGalletaRota;
    }

    public Double getDatoPesoGalletaRotaCalculado() {
        return datoPesoGalletaRotaCalculado;
    }

    public void setDatoPesoGalletaRotaCalculado(Double datoPesoGalletaRotaCalculado) {
        this.datoPesoGalletaRotaCalculado = datoPesoGalletaRotaCalculado;
    }

    public Double getDatoPesoPrimarioGalletaRota() {
        return datoPesoPrimarioGalletaRota;
    }

    public void setDatoPesoPrimarioGalletaRota(Double datoPesoPrimarioGalletaRota) {
        this.datoPesoPrimarioGalletaRota = datoPesoPrimarioGalletaRota;
    }

    public Integer getIdGuardado() {
        return idGuardado;
    }

    public void setIdGuardado(Integer idGuardado) {
        this.idGuardado = idGuardado;
    }

    @Override
    public String toString() {
        return "DetalleEmpaqueGalletaRotaDTO{" +
                "idGuardado=" + idGuardado +
                ", datoPesoGalletaRota=" + datoPesoGalletaRota +
                ", datoPesoGalletaRotaCalculado=" + datoPesoGalletaRotaCalculado +
                ", datoPesoPrimarioGalletaRota=" + datoPesoPrimarioGalletaRota +
                '}';
    }
}
