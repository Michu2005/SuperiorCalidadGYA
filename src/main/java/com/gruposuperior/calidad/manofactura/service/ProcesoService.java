package com.gruposuperior.calidad.manofactura.service;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ProcesoDTO;
import com.gruposuperior.calidad.manofactura.entities.Proceso;


public interface ProcesoService {
	
	public ResponsePaginatedDTO<List<ProcesoDTO>> listarProceso(int pageNumber, int pageSize);
	public ResponseDTO<Proceso> crearProceso(ProcesoDTO procesoDTO);
}
