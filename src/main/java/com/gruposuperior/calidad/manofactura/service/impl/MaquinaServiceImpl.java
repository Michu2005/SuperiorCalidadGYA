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
	public ResponsePaginatedDTO<List<MaquinaDTO>> listarMaquina() {
		// Define el tipo de resultado a retornar		
		ResponsePaginatedDTO<List<MaquinaDTO>> result = new ResponsePaginatedDTO<List<MaquinaDTO>>();
		// Consulta al repositorio con paginacion
		List<Maquina> pageMaquina = maquinaRepository.findAll();
		
		// Setea el resultado de la consulta en la respuesta
		result.setData(pageMaquina.stream().map(maquina -> {
			return new MaquinaDTO(maquina.getId(), maquina.getDescripcion());
		}).collect(Collectors.toList()));

		result.setHttpStatus(HttpStatus.OK);
		
		return result;
	}

	@Override
	public ResponseDTO<Maquina> crearMaquina(MaquinaDTO maquinaDTO) {
		ResponseDTO<Maquina> result = new ResponseDTO<Maquina>();
		Maquina maquina = new Maquina();
		maquina.setDescripcion(maquinaDTO.getDescripcion());
		maquina.setActivo(true);
		maquina.setCreado(new Date());
		maquinaRepository.save(maquina);
		
		result.setData(maquina);
		result.setHttpStatus(HttpStatus.OK);
		return result;
	}
}
