package com.gruposuperior.calidad.manofactura.dto.response;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public class DetalleEmpaqueDTO {

    @NotBlank
    private int idDetalle;

    @NotBlank
    private int idParametro;

    @NotBlank
    private Double datoPesoPrimario;

    @NotBlank
    private Double datoPesoSecundario;

    @NotBlank
    private Double datoPesoCorrugado;

    @NotBlank
    private short numeroRegistro;

    @NotBlank
    private BigDecimal valor;

    @NotBlank
    private double datoPesoGalletaRota;

    @NotBlank
    private double datoPesoGalletaRotaCalcualado;

    @NotBlank
    private double datoPesoPrimarioGalletaRota;

    @NotBlank
    private double datoPesoPrimarioHermeticidad;

    @NotBlank
    private double datoPesoPrimarioParametroAdic;

    @NotBlank
    private boolean activo;

    @NotBlank
    private Date borrado;

    @NotBlank
    private Date creado;

    // DTO
    public BigDecimal min;
    public BigDecimal max;
    public int parametro;
    public String sinFuga;
    public String fugaGrave;
    public String fugaLeve;
    public String descripcionParametro;

    public DetalleEmpaqueDTO() {
    }

    public DetalleEmpaqueDTO(int idParametro, Double datoPesoPrimario, Double datoPesoSecundario,
            Double datoPesoCorrugado) {
        this.idParametro = idParametro;
        this.datoPesoPrimario = datoPesoPrimario;
        this.datoPesoSecundario = datoPesoSecundario;
        this.datoPesoCorrugado = datoPesoCorrugado;
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

    public double getDatoPesoGalletaRota() {
        return datoPesoGalletaRota;
    }

    public void setDatoPesoGalletaRota(double datoPesoGalletaRota) {
        this.datoPesoGalletaRota = datoPesoGalletaRota;
    }

    public double getDatoPesoGalletaRotaCalcualado() {
        return datoPesoGalletaRotaCalcualado;
    }

    public void setDatoPesoGalletaRotaCalcualado(double datoPesoGalletaRotaCalcualado) {
        this.datoPesoGalletaRotaCalcualado = datoPesoGalletaRotaCalcualado;
    }

    public double getDatoPesoPrimarioGalletaRota() {
        return datoPesoPrimarioGalletaRota;
    }

    public void setDatoPesoPrimarioGalletaRota(double datoPesoPrimarioGalletaRota) {
        this.datoPesoPrimarioGalletaRota = datoPesoPrimarioGalletaRota;
    }

    public double getDatoPesoPrimarioHermeticidad() {
        return datoPesoPrimarioHermeticidad;
    }

    public void setDatoPesoPrimarioHermeticidad(double datoPesoPrimarioHermeticidad) {
        this.datoPesoPrimarioHermeticidad = datoPesoPrimarioHermeticidad;
    }

    public double getDatoPesoPrimarioParametroAdic() {
        return datoPesoPrimarioParametroAdic;
    }

    public void setDatoPesoPrimarioParametroAdic(double datoPesoPrimarioParametroAdic) {
        this.datoPesoPrimarioParametroAdic = datoPesoPrimarioParametroAdic;
    }

    public short getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(short numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
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

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public int getParametro() {
        return parametro;
    }

    public void setParametro(int parametro) {
        this.parametro = parametro;
    }

    public String getSinFuga() {
        return sinFuga;
    }

    public void setSinFuga(String sinFuga) {
        this.sinFuga = sinFuga;
    }

    public String getFugaGrave() {
        return fugaGrave;
    }

    public void setFugaGrave(String fugaGrave) {
        this.fugaGrave = fugaGrave;
    }

    public String getFugaLeve() {
        return fugaLeve;
    }

    public void setFugaLeve(String fugaLeve) {
        this.fugaLeve = fugaLeve;
    }

    public String getDescripcionParametro() {
        return descripcionParametro;
    }

    public void setDescripcionParametro(String descripcionParametro) {
        this.descripcionParametro = descripcionParametro;
    }
    

}
