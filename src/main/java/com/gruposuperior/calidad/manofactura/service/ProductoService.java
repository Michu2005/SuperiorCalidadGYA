package com.gruposuperior.calidad.manofactura.service;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ProductoDTO;
import com.gruposuperior.calidad.manofactura.entities.Parametro;
import com.gruposuperior.calidad.manofactura.entities.Producto;


public interface ProductoService {
	
	public ResponsePaginatedDTO<List<ProductoDTO>> listarProducto();
	public ResponseDTO<Producto> crearProducto(ProductoDTO productoDTO);
}
