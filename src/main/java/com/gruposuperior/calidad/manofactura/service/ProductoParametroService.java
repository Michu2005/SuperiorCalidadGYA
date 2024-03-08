package com.gruposuperior.calidad.manofactura.service;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ProductoParametroDTO;
import com.gruposuperior.calidad.manofactura.entities.ProductoParametro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoParametroService {
    ResponsePaginatedDTO<List<ProductoParametroDTO>> listarProductoParametro(int pageNumber, int pageSize);
    ResponseDTO<ProductoParametro> crearProductoParametro(ProductoParametroDTO productoParametroDTO);

}
