package com.gruposuperior.calidad.manofactura.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.gruposuperior.calidad.manofactura.entities.ProductoParametro;
import com.gruposuperior.calidad.manofactura.repositories.ProductoParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ParametroDTO;
import com.gruposuperior.calidad.manofactura.entities.Parametro;
import com.gruposuperior.calidad.manofactura.repositories.ParametroRepository;
import com.gruposuperior.calidad.manofactura.service.ParametroService;

@Service
public class ParametroServiceImpl implements ParametroService{

	@Autowired
	private ParametroRepository parametroRepository;
	@Autowired
	private ProductoParametroRepository productoParametroRepository;

	public ResponsePaginatedDTO<List<ParametroDTO>> listarParametro() {
		// Define el tipo de resultado a retornar
		ResponsePaginatedDTO<List<ParametroDTO>> result = new ResponsePaginatedDTO<List<ParametroDTO>>();
		// Consulta al repositorio con paginacion
		//Sort sort = Sort.by( Sort.Order.desc("id"));
		//Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
		List<Parametro> pageParametro = parametroRepository.findAll();

		// Setea el resultado de la consulta en la respuesta
		result.setData(pageParametro.stream().map(parametro -> {
			return new ParametroDTO(parametro.getDescripcion(), parametro.getMax(), parametro.getMin());
		}).collect(Collectors.toList()));

		/*result.setCurrentPage(pageParametro.getNumber());
		result.setTotalElements(pageParametro.getTotalElements());
		result.setTotalPages(pageParametro.getTotalPages());*/
		result.setHttpStatus(HttpStatus.OK);

		return result;
	}

	@Override
	public ResponseDTO<Parametro> crearParametro(ParametroDTO parametroDTO) {
		ResponseDTO<Parametro> result = new ResponseDTO<Parametro>();
		Parametro parametro = new Parametro();
		parametro.setDescripcion(parametroDTO.getDescripcion());
		parametro.setActivo(true);
		parametro.setCreado(new Date());
		parametroRepository.save(parametro);
		
		result.setData(parametro);
		result.setHttpStatus(HttpStatus.OK);
		return result;
	}

	@Override
	public List<ParametroDTO> obtenerParametrosPorIdProducto(Integer idProducto) {
		List<ProductoParametro> productoParametros = productoParametroRepository.findByProductoId(idProducto);
		List<ParametroDTO> parametrosDTO = productoParametros.stream()
				.map(productoParametro -> convertirAParametroDTO(productoParametro))
				.collect(Collectors.toList());

		return parametrosDTO;
	}

	private ParametroDTO convertirAParametroDTO(ProductoParametro productoParametro) {
		ParametroDTO parametroDTO = new ParametroDTO();
		parametroDTO.setDescripcion(productoParametro.getParametro().getDescripcion());
		parametroDTO.setMax(productoParametro.getParametro().getMax());
		parametroDTO.setMin(productoParametro.getParametro().getMin());

		return parametroDTO;
	}
}
