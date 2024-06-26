package com.gruposuperior.calidad.manofactura.service;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraProcesoDTO;
import org.springframework.stereotype.Service;

@Service
public interface GuardadoProcesoService {

    Boolean registroRespuesta(CabeceraProcesoDTO data);
}
