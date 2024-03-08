package com.gruposuperior.calidad.manofactura.service.impl;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ProductoParametroDTO;
import com.gruposuperior.calidad.manofactura.entities.ProductoParametro;
import com.gruposuperior.calidad.manofactura.repositories.ProductoParametroRepository;
import com.gruposuperior.calidad.manofactura.service.ProductoParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoParametroServiceImpl implements ProductoParametroService {
    @Autowired
    private ProductoParametroRepository productoParametroRepository;

    @Override
    public ResponsePaginatedDTO<List<ProductoParametroDTO>> listarProductoParametro(int pageNumber, int pageSize) {
        // Define el tipo de resultado a retornar
        ResponsePaginatedDTO<List<ProductoParametroDTO>> result = new ResponsePaginatedDTO<List<ProductoParametroDTO>>();
        // Consulta al repositorio con paginacion
        //Sort sort = Sort.by( Sort.Order.desc("id") );
        //Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
        List<ProductoParametro> pageProductoParametro = productoParametroRepository.findAll();

        // Setea el resultado de la consulta en la respuesta
        result.setData(pageProductoParametro.stream().map(productoParametro -> {
            return new ProductoParametroDTO(productoParametro.getId(), productoParametro.getIdProducto(), productoParametro.getIdParametro());
        }).collect(Collectors.toList()));

        /*result.setCurrentPage(pageProductoParametro.getNumber());
        result.setTotalElements(pageProductoParametro.getTotalElements());
        result.setTotalPages(pageProductoParametro.getTotalPages());*/
        result.setHttpStatus(HttpStatus.OK);

        return result;
    }

    @Override
    public ResponseDTO<ProductoParametro> crearProductoParametro(ProductoParametroDTO productoParametroDTO) {
        ResponseDTO<ProductoParametro> result = new ResponseDTO<>();
        ProductoParametro productoParametro = new ProductoParametro();
        productoParametro.setId(productoParametroDTO.getId());
        productoParametro.setActivo(true);
        productoParametro.setCreado(new Date());
        productoParametroRepository.save(productoParametro);

        result.setData(productoParametro);
        result.setHttpStatus(HttpStatus.OK);
        return result;
    }
}
