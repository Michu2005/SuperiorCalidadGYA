package com.gruposuperior.calidad.manofactura.service;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.PerfilEmpleadoDTO;
import com.gruposuperior.calidad.manofactura.entities.PerfilEmpleado;

import java.util.List;

public interface PerfilEmpleadoService {
    ResponsePaginatedDTO<List<PerfilEmpleadoDTO>> listarPerfilEmpleado(int pageNumber, int pageSize);
    ResponseDTO<PerfilEmpleado> crearPerfilEmpleado(PerfilEmpleadoDTO perfilEmpleadoDTODTO);
}
