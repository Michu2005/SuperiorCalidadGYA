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
import com.gruposuperior.calidad.manofactura.dto.response.MaquinaDTO;
import com.gruposuperior.calidad.manofactura.entities.Maquina;
import com.gruposuperior.calidad.manofactura.repositories.MaquinaRepository;
import com.gruposuperior.calidad.manofactura.service.MaquinaService;

@Service
public class MaquinaServiceImpl implements MaquinaService{
	
	@Autowired
	private MaquinaRepository maquinaRepository;

	@Override
	public ResponsePaginatedDTO<List<MaquinaDTO>> listarMaquina(int pageNumber, int pageSize) {
		// Define el tipo de resultado a retornar		
		ResponsePaginatedDTO<List<MaquinaDTO>> result = new ResponsePaginatedDTO<List<MaquinaDTO>>();
		// Consulta al repositorio con paginacion
		Sort sort = Sort.by( Sort.Order.desc("id") );
		Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
		Page<Maquina> pageMaquina = maquinaRepository.findAll(pagination);
		
		// Setea el resultado de la consulta en la respuesta
		result.setData(pageMaquina.getContent().stream().map(maquina -> {
			return new LineaDTO(maquina.getId(), maquina.getDescripcion());
		}).collect(Collectors.toList()));
		
		result.setCurrentPage(pageMaquina.getNumber());
		result.setTotalElements(pageMaquina.getTotalElements());
		result.setTotalPages(pageMaquina.getTotalPages());
		result.setHttpStatus(HttpStatus.OK);
		
		return result;
	}

	@Override
	public ResponseDTO<Maquina> crearMaquina(MaquinaDTO maquinaDTO) {
		ResponseDTO<Maquina> result = new ResponseDTO<Maquina>();
		Turno maquina = new Maquina();
		maquina.setDescripcion(maquinaDTO.getDescripcion());
		maquina.setActivo(true);
		maquina.setCreado(new Date());
		lineaRepository.save(maquina);
		
		result.setData(maquina);
		result.setHttpStatus(HttpStatus.OK);
		return result;
	}

}
