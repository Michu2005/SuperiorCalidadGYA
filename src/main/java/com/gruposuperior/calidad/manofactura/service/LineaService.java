package com.gruposuperior.calidad.manofactura.service;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.LineaDTO;
import com.gruposuperior.calidad.manofactura.entities.Linea;


public interface LineaService {
	
	ResponsePaginatedDTO<List<LineaDTO>> listarLinea(int pageNumber, int pageSize);
	ResponseDTO<Linea> crearLinea(LineaDTO lineaDTO);
}
