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
import com.gruposuperior.calidad.manofactura.dto.response.ProcesoDTO;
import com.gruposuperior.calidad.manofactura.entities.Proceso;
import com.gruposuperior.calidad.manofactura.repositories.ProcesoRepository;
import com.gruposuperior.calidad.manofactura.service.ProcesoService;

@Service
public class ProcesoServiceImpl implements ProcesoService{
	
	@Autowired
	private ProcesoRepository procesoRepository;

	@Override
	public ResponsePaginatedDTO<List<ProcesoDTO>> listarProceso(int pageNumber, int pageSize) {
		// Define el tipo de resultado a retornar		
		ResponsePaginatedDTO<List<ProcesoDTO>> result = new ResponsePaginatedDTO<List<ProcesoDTO>>();
		// Consulta al repositorio con paginacion
		Sort sort = Sort.by( Sort.Order.desc("id") );
		Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
		Page<Proceso> pageProceso = ProcesoRepository.findAll(pagination);
		
		// Setea el resultado de la consulta en la respuesta
		result.setData(pageProceso.getContent().stream().map(proceso -> {
			return new ProductoDTO(proceso.getId(), proceso.getDescripcion());
		}).collect(Collectors.toList()));
		
		result.setCurrentPage(pageProceso.getNumber());
		result.setTotalElements(pageProceso.getTotalElements());
		result.setTotalPages(pageProceso.getTotalPages());
		result.setHttpStatus(HttpStatus.OK);
		
		return result;
	}

	@Override
	public ResponseDTO<Proceso> crearProceso(ProcesoDTO procesoDTO) {
		ResponseDTO<Proceso> result = new ResponseDTO<Proceso>();
		Proceso proceso = new Proceso();
		proceso.setDescripcion(productoDTO.getDescripcion());
		proceso.setActivo(true);
		proceso.setCreado(new Date());
		procesoRepository.save(proceso);
		
		result.setData(proceso);
		result.setHttpStatus(HttpStatus.OK);
		return result;
	}

}
