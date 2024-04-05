package com.gruposuperior.calidad.manofactura.dto.response;

import java.util.List;

public class RespuestaDTO {

    private Integer idControlEmpaqueCabecera;
    private List<Integer> idGuardados;

    public RespuestaDTO(Integer idControlEmpaqueCabecera, List<Integer> idGuardados) {
        this.idControlEmpaqueCabecera = idControlEmpaqueCabecera;
        this.idGuardados = idGuardados;
    }

    public RespuestaDTO() {

    }

    public Integer getIdControlEmpaqueCabecera() {
        return idControlEmpaqueCabecera;
    }

    public void setIdControlEmpaqueCabecera(Integer idControlEmpaqueCabecera) {
        this.idControlEmpaqueCabecera = idControlEmpaqueCabecera;
    }

    public List<Integer> getIdGuardados() {
        return idGuardados;
    }

    public void setIdGuardados(List<Integer> idGuardados) {
        this.idGuardados = idGuardados;
    }
}
