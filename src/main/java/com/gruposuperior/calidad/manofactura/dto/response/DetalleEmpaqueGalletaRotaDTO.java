package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class DetalleEmpaqueGalletaRotaDTO {

    @NotBlank
    private Double datoPesoGalletaRota;

    @NotBlank
    private Double datoPesoGalletaRotaCalculado;

    @NotBlank
    private Double datoPesoPrimarioGalletaRota;

    public DetalleEmpaqueGalletaRotaDTO() {
    }

    public DetalleEmpaqueGalletaRotaDTO(Double datoPesoGalletaRota, Double datoPesoGalletaRotaCalculado, Double datoPesoPrimarioGalletaRota) {
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
}
