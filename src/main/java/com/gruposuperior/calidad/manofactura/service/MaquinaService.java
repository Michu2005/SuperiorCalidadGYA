package com.gruposuperior.calidad.manofactura.service;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.MaquinaDTO;
import com.gruposuperior.calidad.manofactura.entities.Maquina;


public interface MaquinaService {
	
	public ResponsePaginatedDTO<List<MaquinaDTO>> listarMaquina(int pageNumber, int pageSize);
	public ResponseDTO<Maquina> crearMaquina(MaquinaDTO maquinaDTO);
}
