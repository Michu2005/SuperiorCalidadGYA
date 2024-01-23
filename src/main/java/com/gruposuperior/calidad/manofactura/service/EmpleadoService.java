package com.gruposuperior.calidad.manofactura.service;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.EmpleadoDTO;
import com.gruposuperior.calidad.manofactura.entities.Empleado;


public interface EmpleadoService {
	
	public ResponsePaginatedDTO<List<EmpleadoDTO>> listarEmpleado(int pageNumber, int pageSize);
	public ResponseDTO<Empleado> crearEmpleado(EmpleadoDTO empleadoDTO);
}
