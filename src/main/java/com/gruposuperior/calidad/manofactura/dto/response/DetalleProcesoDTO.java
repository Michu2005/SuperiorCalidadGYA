package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class DetalleProcesoDTO {

    @NotBlank
    private int idParametro;

    @NotBlank
    private int valorZona1;

    @NotBlank
    private int valorZona2;

    @NotBlank
    private int valorZona3;

    public DetalleProcesoDTO() {
    }

    public DetalleProcesoDTO(int idParametro, int valorZona1, int valorZona2, int valorZona3) {
        this.idParametro = idParametro;
        this.valorZona1 = valorZona1;
        this.valorZona2 = valorZona2;
        this.valorZona3 = valorZona3;
    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public int getValorZona1() {
        return valorZona1;
    }

    public void setValorZona1(int valorZona1) {
        this.valorZona1 = valorZona1;
    }

    public int getValorZona2() {
        return valorZona2;
    }

    public void setValorZona2(int valorZona2) {
        this.valorZona2 = valorZona2;
    }

    public int getValorZona3() {
        return valorZona3;
    }

    public void setValorZona3(int valorZona3) {
        this.valorZona3 = valorZona3;
    }

}
