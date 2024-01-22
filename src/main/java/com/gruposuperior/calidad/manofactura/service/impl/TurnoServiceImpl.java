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
import com.gruposuperior.calidad.manofactura.dto.response.TurnoDTO;
import com.gruposuperior.calidad.manofactura.entities.Turno;
import com.gruposuperior.calidad.manofactura.repositories.TurnoRepository;
import com.gruposuperior.calidad.manofactura.service.TurnoService;

@Service
public class TurnoServiceImpl implements TurnoService{
	
	@Autowired
	private TurnoRepository turnoRepository;

	@Override
	public ResponsePaginatedDTO<List<TurnoDTO>> listarTurno(int pageNumber, int pageSize) {
		// Define el tipo de resultado a retornar		
		ResponsePaginatedDTO<List<TurnoDTO>> result = new ResponsePaginatedDTO<List<TurnoDTO>>();
		// Consulta al repositorio con paginacion
		Sort sort = Sort.by( Sort.Order.desc("id") );
		Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
		Page<Turno> pageTurno = turnoRepository.findAll(pagination);
		
		// Setea el resultado de la consulta en la respuesta
		result.setData(pageTurno.getContent().stream().map(turno -> {
			return new TurnoDTO(turno.getId(), turno.getDescripcion());
		}).collect(Collectors.toList()));
		
		result.setCurrentPage(pageTurno.getNumber());
		result.setTotalElements(pageTurno.getTotalElements());
		result.setTotalPages(pageTurno.getTotalPages());
		result.setHttpStatus(HttpStatus.OK);
		
		return result;
	}

	@Override
	public ResponseDTO<Turno> crearTurno(TurnoDTO turnoDTO) {
		ResponseDTO<Turno> result = new ResponseDTO<Turno>();
		Turno turno = new Turno();
		turno.setDescripcion(turnoDTO.getDescripcion());
		turno.setActivo(true);
		turno.setCreado(new Date());
		turnoRepository.save(turno);
		
		result.setData(turno);
		result.setHttpStatus(HttpStatus.OK);
		return result;
	}

}
