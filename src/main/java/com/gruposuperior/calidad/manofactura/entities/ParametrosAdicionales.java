package com.gruposuperior.calidad.manofactura.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "parametros_adicionales")
public class ParametrosAdicionales {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="id_control_empaque_cabecera")
    private int idCotrolEmpaqueCabecera;

    @Column(name="id_parametro")
    private int idParametro;

    @Column(name="dato_param_adic")
    private Double datoParamAdicionales;

    @Temporal(TemporalType.DATE)
    @Column(name="creado")
    private Date creado;

    public ParametrosAdicionales() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCotrolEmpaqueCabecera() {
        return idCotrolEmpaqueCabecera;
    }

    public void setIdCotrolEmpaqueCabecera(int idCotrolEmpaqueCabecera) {
        this.idCotrolEmpaqueCabecera = idCotrolEmpaqueCabecera;
    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public Double getDatoParamAdicionales() {
        return datoParamAdicionales;
    }

    public void setDatoParamAdicionales(Double datoParamAdicionales) {
        this.datoParamAdicionales = datoParamAdicionales;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }
}
