package com.gruposuperior.calidad.manofactura.service;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.PerfilDTO;
import com.gruposuperior.calidad.manofactura.entities.Perfil;


public interface PerfilService {
	
	ResponsePaginatedDTO<List<PerfilDTO>> listarPerfil(int pageNumber, int pageSize);
	ResponseDTO<Perfil> crearPerfil(PerfilDTO perfilDTO);
}
