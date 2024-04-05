package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

public class CabeceraEmpaqueDTO {
    @NotBlank
    private int idCabecera;
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
    private int idMaquina;
    @NotBlank
    private String lote;

    private boolean activo;
    private Date borrado;
    private Date creado;

    // DTO Datos Extras
    private String NombreAnalista;
    private String NombreSupervisor;
    private String NombreProducto;
    private String Fecha;
    private String Hora;
    private String DescripcionTurno;
    private String DescripcionMaquina;
    private String DescripcionLinea;

    List<DetalleEmpaqueDTO> detalleEmpaqueDTOList;

    public CabeceraEmpaqueDTO() {
    }

    public CabeceraEmpaqueDTO(int idSupervisor, int idAnalista, int idTurno, int idLinea, int idProducto,
            int idMaquina, String lote) {
        this.idSupervisor = idSupervisor;
        this.idAnalista = idAnalista;
        this.idTurno = idTurno;
        this.idLinea = idLinea;
        this.idProducto = idProducto;
        this.idMaquina = idMaquina;
        this.lote = lote;
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

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public List<DetalleEmpaqueDTO> getDetalleEmpaqueDTOList() {
        return detalleEmpaqueDTOList;
    }

    public void setDetalleEmpaqueDTOList(List<DetalleEmpaqueDTO> detalleEmpaqueDTOList) {
        this.detalleEmpaqueDTOList = detalleEmpaqueDTOList;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }

    public String getNombreAnalista() {
        return NombreAnalista;
    }

    public void setNombreAnalista(String nombreAnalista) {
        NombreAnalista = nombreAnalista;
    }

    public String getNombreSupervisor() {
        return NombreSupervisor;
    }

    public void setNombreSupervisor(String nombreSupervisor) {
        NombreSupervisor = nombreSupervisor;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getDescripcionTurno() {
        return DescripcionTurno;
    }

    public void setDescripcionTurno(String descripcionTurno) {
        DescripcionTurno = descripcionTurno;
    }

    public String getDescripcionLinea() {
        return DescripcionLinea;
    }

    public void setDescripcionLinea(String descripcionLinea) {
        DescripcionLinea = descripcionLinea;
    }

    public String getDescripcionMaquina() {
        return DescripcionMaquina;
    }

    public void setDescripcionMaquina(String descripcionMaquina) {
        DescripcionMaquina = descripcionMaquina;
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

}
