package com.gruposuperior.calidad.manofactura.service;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.TurnoDTO;
import com.gruposuperior.calidad.manofactura.entities.Turno;


public interface TurnoService {
	
	public ResponsePaginatedDTO<List<TurnoDTO>> listarTurno(int pageNumber, int pageSize);
	public ResponseDTO<Turno> crearTurno(TurnoDTO turnoDTO);
}
