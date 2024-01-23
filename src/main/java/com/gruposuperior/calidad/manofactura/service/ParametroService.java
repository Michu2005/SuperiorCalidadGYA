package com.gruposuperior.calidad.manofactura.service;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ParametroDTO;
import com.gruposuperior.calidad.manofactura.entities.Parametro;


public interface ParametroService {
	
	public ResponsePaginatedDTO<List<ParametroDTO>> listarParametro(int pageNumber, int pageSize);
	public ResponseDTO<Parametro> crearParametro(ParametroDTO parametroDTO);
}