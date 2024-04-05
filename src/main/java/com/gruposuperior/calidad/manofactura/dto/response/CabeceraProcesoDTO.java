package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

public class CabeceraProcesoDTO {

    @NotBlank
    private int id;

    @NotBlank
    private int idSupervisor;

    @NotBlank
    private int idAnalista;

    @NotBlank
    private int idTurno;

    @NotBlank
    private int idLinea;

    @NotBlank
    private int idProducto;

    @NotBlank
    private boolean activo;

    @NotBlank
    private Date borrado;

    @NotBlank
    private Date creado;

    List<DetalleProcesoDTO> detalleProcesoDTOList;

    //DTO
    @NotBlank
    private String nombreAAC;
    @NotBlank
    private String nombreSAC;
    @NotBlank
    private String nombreProducto;
    @NotBlank
    private String fecha;
    @NotBlank
    private String hora;
    @NotBlank
    private String turno;
    @NotBlank
    private String linea;
    @NotBlank
    private String sku;
    @NotBlank
    private String proceso;

    public CabeceraProcesoDTO() {
    }

    public CabeceraProcesoDTO(int idSupervisor, int idAnalista, int idTurno, int idLinea, int idProducto) {
        this.idSupervisor = idSupervisor;
        this.idAnalista = idAnalista;
        this.idTurno = idTurno;
        this.idLinea = idLinea;
        this.idProducto = idProducto;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public int getIdAnalista() {
        return idAnalista;
    }

    public void setIdAnalista(int idAnalista) {
        this.idAnalista = idAnalista;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public List<DetalleProcesoDTO> getDetalleProcesoDTOList() {
        return detalleProcesoDTOList;
    }

    public void setDetalleProcesoDTOList(List<DetalleProcesoDTO> detalleProcesoDTOList) {
        this.detalleProcesoDTOList = detalleProcesoDTOList;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombreAAC() {
        return nombreAAC;
    }

    public void setNombreAAC(String nombreAAC) {
        this.nombreAAC = nombreAAC;
    }

    public String getNombreSAC() {
        return nombreSAC;
    }

    public void setNombreSAC(String nombreSAC) {
        this.nombreSAC = nombreSAC;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    @Override
    public String toString() {
        return "CabeceraProcesoDTO{" +
                "idSupervisor=" + idSupervisor +
                ", idAnalista=" + idAnalista +
                ", idTurno=" + idTurno +
                ", idLinea=" + idLinea +
                ", idProducto=" + idProducto +
                ", detalleProcesoDTOList=" + detalleProcesoDTOList +
                '}';
    }
}
