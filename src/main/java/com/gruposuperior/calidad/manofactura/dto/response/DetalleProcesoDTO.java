package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class DetalleProcesoDTO {

    @NotBlank
    private int idParametro;

    @NotBlank
    private Double valorZona1;

    @NotBlank
    private Double valorZona2;

    @NotBlank
    private Double valorZona3;

    @NotBlank
    private int idControlProductoCabecera;

    public DetalleProcesoDTO() {
    }

    public DetalleProcesoDTO(int idParametro, Double valorZona1, Double valorZona2, Double valorZona3, int idControlProductoCabecera) {
        this.idParametro = idParametro;
        this.valorZona1 = valorZona1;
        this.valorZona2 = valorZona2;
        this.valorZona3 = valorZona3;
        this.idControlProductoCabecera = idControlProductoCabecera;
    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public Double getValorZona1() {
        return valorZona1;
    }

    public void setValorZona1(Double valorZona1) {
        this.valorZona1 = valorZona1;
    }

    public Double getValorZona2() {
        return valorZona2;
    }

    public void setValorZona2(Double valorZona2) {
        this.valorZona2 = valorZona2;
    }

    public Double getValorZona3() {
        return valorZona3;
    }

    public void setValorZona3(Double valorZona3) {
        this.valorZona3 = valorZona3;
    }

    public int getIdControlProductoCabecera() {
        return idControlProductoCabecera;
    }

    public void setIdControlProductoCabecera(int idControlProductoCabecera) {
        this.idControlProductoCabecera = idControlProductoCabecera;
    }
}
