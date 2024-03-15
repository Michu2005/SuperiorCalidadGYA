package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CabeceraEmpaqueDTO {
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

    List<DetalleEmpaqueDTO> detalleEmpaqueDTOList;

    public CabeceraEmpaqueDTO() {
    }

    public CabeceraEmpaqueDTO(int idSupervisor, int idAnalista, int idTurno, int idLinea, int idProducto, int idMaquina) {
        this.idSupervisor = idSupervisor;
        this.idAnalista = idAnalista;
        this.idTurno = idTurno;
        this.idLinea = idLinea;
        this.idProducto = idProducto;
        this.idMaquina = idMaquina;
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
}
