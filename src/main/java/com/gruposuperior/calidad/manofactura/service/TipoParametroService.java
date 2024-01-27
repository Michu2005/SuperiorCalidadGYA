package com.gruposuperior.calidad.manofactura.service;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.TipoParametroDTO;
import com.gruposuperior.calidad.manofactura.entities.TipoParametro;

import java.util.List;

public interface TipoParametroService {
    ResponsePaginatedDTO<List<TipoParametroDTO>> listarTipoParametro(int pageNumber, int pageSize);
    ResponseDTO<TipoParametro> crearTipoParametro(TipoParametroDTO tipoParametroDTO);
}
