package com.gruposuperior.calidad.manofactura.service.impl;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.PerfilEmpleadoDTO;
import com.gruposuperior.calidad.manofactura.entities.PerfilEmpleado;
import com.gruposuperior.calidad.manofactura.repositories.PerfilEmpleadoRepository;
import com.gruposuperior.calidad.manofactura.service.PerfilEmpleadoService;
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
public class PerfilEmpleadoServiceImpl implements PerfilEmpleadoService {
    @Autowired
    private PerfilEmpleadoRepository perfilEmpleadoRepository;

    @Override
    public ResponsePaginatedDTO<List<PerfilEmpleadoDTO>> listarPerfilEmpleado(int pageNumber, int pageSize) {
        // Define el tipo de resultado a retornar
        ResponsePaginatedDTO<List<PerfilEmpleadoDTO>> result = new ResponsePaginatedDTO<List<PerfilEmpleadoDTO>>();
        // Consulta al repositorio con paginacion
        Sort sort = Sort.by( Sort.Order.desc("id") );
        Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
        Page<PerfilEmpleado> pagePerfilEmpleado = perfilEmpleadoRepository.findAll(pagination);

        // Setea el resultado de la consulta en la respuesta
        result.setData(pagePerfilEmpleado.getContent().stream().map(perfilEmpleado -> {
            return new PerfilEmpleadoDTO(perfilEmpleado.getId());
        }).collect(Collectors.toList()));

        result.setCurrentPage(pagePerfilEmpleado.getNumber());
        result.setTotalElements(pagePerfilEmpleado.getTotalElements());
        result.setTotalPages(pagePerfilEmpleado.getTotalPages());
        result.setHttpStatus(HttpStatus.OK);

        return result;
    }

    @Override
    public ResponseDTO<PerfilEmpleado> crearPerfilEmpleado(PerfilEmpleadoDTO perfilEmpleadoDTO) {
        ResponseDTO<PerfilEmpleado> result = new ResponseDTO<PerfilEmpleado>();
        PerfilEmpleado perfilEmpleado = new PerfilEmpleado();
        perfilEmpleado.setId(perfilEmpleado.getId());
        perfilEmpleado.setActivo(true);
        perfilEmpleado.setCreado(new Date());
        perfilEmpleadoRepository.save(perfilEmpleado);

        result.setData(perfilEmpleado);
        result.setHttpStatus(HttpStatus.OK);
        return result;
    }
}
