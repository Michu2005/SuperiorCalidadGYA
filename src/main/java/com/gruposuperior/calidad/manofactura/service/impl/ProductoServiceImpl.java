package com.gruposuperior.calidad.manofactura.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gruposuperior.calidad.manofactura.dto.response.ProductoParametroDTO;
import com.gruposuperior.calidad.manofactura.entities.Parametro;
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
import com.gruposuperior.calidad.manofactura.dto.response.ProductoDTO;
import com.gruposuperior.calidad.manofactura.entities.Producto;
import com.gruposuperior.calidad.manofactura.repositories.ProductoRepository;
import com.gruposuperior.calidad.manofactura.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ResponsePaginatedDTO<List<ProductoDTO>> listarProducto() {
		// Define el tipo de resultado a retornar		
		ResponsePaginatedDTO<List<ProductoDTO>> result = new ResponsePaginatedDTO<List<ProductoDTO>>();
		// Consulta al repositorio con paginacion
		//Sort sort = Sort.by( Sort.Order.desc("id") );
		//Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
		List<Producto> pageProducto = productoRepository.findAll();
		
		// Setea el resultado de la consulta en la respuesta
		result.setData(pageProducto.stream().map(producto -> {
			return new ProductoDTO(producto.getId(), producto.getCodigo(), producto.getDescripcion());
		}).collect(Collectors.toList()));
		
		/*result.setCurrentPage(pageProducto.getNumber());
		result.setTotalElements(pageProducto.getTotalElements());
		result.setTotalPages(pageProducto.getTotalPages());*/
		result.setHttpStatus(HttpStatus.OK);
		
		return result;
	}

	@Override
	public ResponseDTO<Producto> crearProducto(ProductoDTO productoDTO) {
		ResponseDTO<Producto> result = new ResponseDTO<Producto>();
		Producto producto = new Producto();
		producto.setDescripcion(productoDTO.getDescripcion());
		producto.setActivo(true);
		producto.setCreado(new Date());
		productoRepository.save(producto);
		
		result.setData(producto);
		result.setHttpStatus(HttpStatus.OK);
		return result;
	}
}
