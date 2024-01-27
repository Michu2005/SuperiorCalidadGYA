package com.gruposuperior.calidad.manofactura.service.impl;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.TipoParametroDTO;
import com.gruposuperior.calidad.manofactura.entities.TipoParametro;
import com.gruposuperior.calidad.manofactura.repositories.TipoParametroRepository;
import com.gruposuperior.calidad.manofactura.service.TipoParametroService;
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
public class TipoParametroImpl implements TipoParametroService {
    @Autowired
    private TipoParametroRepository tipoParametroRepository;

    @Override
    public ResponsePaginatedDTO<List<TipoParametroDTO>> listarTipoParametro(int pageNumber, int pageSize) {
        // Define el tipo de resultado a retornar
        ResponsePaginatedDTO<List<TipoParametroDTO>> result = new ResponsePaginatedDTO<List<TipoParametroDTO>>();
        // Consulta al repositorio con paginacion
        Sort sort = Sort.by( Sort.Order.desc("id") );
        Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
        Page<TipoParametro> pageTipoParametro = tipoParametroRepository.findAll(pagination);

        // Setea el resultado de la consulta en la respuesta
        result.setData(pageTipoParametro.getContent().stream().map(tipoParametro -> {
            return new TipoParametroDTO(tipoParametro.getId(), tipoParametro.getTipo());
        }).collect(Collectors.toList()));

        result.setCurrentPage(pageTipoParametro.getNumber());
        result.setTotalElements(pageTipoParametro.getTotalElements());
        result.setTotalPages(pageTipoParametro.getTotalPages());
        result.setHttpStatus(HttpStatus.OK);

        return result;
    }

    @Override
    public ResponseDTO<TipoParametro> crearTipoParametro(TipoParametroDTO tipoParametroDTO) {
        ResponseDTO<TipoParametro> result = new ResponseDTO<TipoParametro>();
        TipoParametro tipoParametro = new TipoParametro();
        tipoParametro.setTipo(tipoParametroDTO.getTipo());
        tipoParametro.setActivo(true);
        tipoParametro.setCreado(new Date());
        tipoParametroRepository.save(tipoParametro);

        result.setData(tipoParametro);
        result.setHttpStatus(HttpStatus.OK);
        return result;
    }
}
