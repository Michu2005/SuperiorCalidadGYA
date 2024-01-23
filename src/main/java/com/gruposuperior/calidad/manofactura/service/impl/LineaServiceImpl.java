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
import com.gruposuperior.calidad.manofactura.dto.response.LineaDTO;
import com.gruposuperior.calidad.manofactura.entities.Linea;
import com.gruposuperior.calidad.manofactura.repositories.LineaRepository;
import com.gruposuperior.calidad.manofactura.service.LineaService;

@Service
public class LineaServiceImpl implements LineaService{
	
	@Autowired
	private LineaRepository lineaRepository;

	@Override
	public ResponsePaginatedDTO<List<LineaDTO>> listarLinea(int pageNumber, int pageSize) {
		// Define el tipo de resultado a retornar		
		ResponsePaginatedDTO<List<LineaDTO>> result = new ResponsePaginatedDTO<List<LineaDTO>>();
		// Consulta al repositorio con paginacion
		Sort sort = Sort.by( Sort.Order.desc("id") );
		Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
		Page<Linea> pageLinea = lineaRepository.findAll(pagination);
		
		// Setea el resultado de la consulta en la respuesta
		result.setData(pageLinea.getContent().stream().map(linea -> {
			return new LineaDTO(linea.getId(), linea.getDescripcion());
		}).collect(Collectors.toList()));
		
		result.setCurrentPage(pageLinea.getNumber());
		result.setTotalElements(pageLinea.getTotalElements());
		result.setTotalPages(pageLinea.getTotalPages());
		result.setHttpStatus(HttpStatus.OK);
		
		return result;
	}

	@Override
	public ResponseDTO<Linea> crearLinea(LineaDTO lineaDTO) {
		ResponseDTO<Linea> result = new ResponseDTO<Linea>();
		Linea linea = new Linea();
		linea.setDescripcion(lineaDTO.getDescripcion());
		linea.setActivo(true);
		linea.setCreado(new Date());
		lineaRepository.save(linea);
		
		result.setData(linea);
		result.setHttpStatus(HttpStatus.OK);
		return result;
	}

}
