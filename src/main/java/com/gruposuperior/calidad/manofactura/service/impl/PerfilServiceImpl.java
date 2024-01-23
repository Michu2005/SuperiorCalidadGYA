package com.gruposuperior.calidad.manofactura.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.PerfilDTO;
import com.gruposuperior.calidad.manofactura.entities.Perfil;
import com.gruposuperior.calidad.manofactura.repositories.PerfilRepository;
import com.gruposuperior.calidad.manofactura.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService{
	
	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public ResponsePaginatedDTO<List<PerfilDTO>> listarPerfil(int pageNumber, int pageSize) {
		// Define el tipo de resultado a retornar		
		ResponsePaginatedDTO<List<PerfilDTO>> result = new ResponsePaginatedDTO<List<PerfilDTO>>();
		// Consulta al repositorio con paginacion
		Sort sort = Sort.by( Sort.Order.desc("id") );
		Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
		Page<Maquina> pagePerfil = perfilRepository.findAll(pagination);
		
		// Setea el resultado de la consulta en la respuesta
		result.setData(pagePerfil.getContent().stream().map(perfil -> {
			return new LineaDTO(perfil.getId(), perfil.getDescripcion());
		}).collect(Collectors.toList()));
		
		result.setCurrentPage(pagePerfil.getNumber());
		result.setTotalElements(pagePerfil.getTotalElements());
		result.setTotalPages(pagePerfil.getTotalPages());
		result.setHttpStatus(HttpStatus.OK);
		
		return result;
	}

	@Override
	public ResponseDTO<Perfil> crearPerfil(PerfilDTO perfilDTO) {
		ResponseDTO<Perfil> result = new ResponseDTO<Perfil>();
		Perfil perfil = new Perfil();
		perfil.setDescripcion(perfilDTO.getDescripcion());
		perfil.setActivo(true);
		perfil.setCreado(new Date());
		perfilRepository.save(perfil);
		
		result.setData(perfil);
		result.setHttpStatus(HttpStatus.OK);
		return result;
	}

}
