package com.gruposuperior.calidad.manofactura.dto.response;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public class DetalleProcesoDTO {

    @NotBlank
    private int id;

    @NotBlank
    private int idCabeceraProceso;

    @NotBlank
    private int idParametro;
    @NotBlank
    private int numeroRegistro;

    @NotBlank
    private Double valorZona1;

    @NotBlank
    private Double valorZona2;

    @NotBlank
    private Double valorZona3;
    @NotBlank
    private boolean activo;

    @NotBlank
    private Date borrado;

    @NotBlank
    private Date creado;

    // DTO
    @NotBlank
    private String descripcionParametro;
    @NotBlank
    private BigDecimal min;
    @NotBlank
    private BigDecimal max;
    @NotBlank
    private String descripcionProceso;

    public DetalleProcesoDTO() {
    }

    public DetalleProcesoDTO(int idParametro, Double valorZona1, Double valorZona2, Double valorZona3) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCabeceraProceso() {
        return idCabeceraProceso;
    }

    public void setIdCabeceraProceso(int idCabeceraProceso) {
        this.idCabeceraProceso = idCabeceraProceso;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getBorrado() {
        return borrado;
    }

    public void setBorrado(Date borrado) {
        this.borrado = borrado;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public String getDescripcionParametro() {
        return descripcionParametro;
    }

    public void setDescripcionParametro(String descripcionParametro) {
        this.descripcionParametro = descripcionParametro;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public String getDescripcionProceso() {
        return descripcionProceso;
    }

    public void setDescripcionProceso(String descripcionProceso) {
        this.descripcionProceso = descripcionProceso;
    }

}
