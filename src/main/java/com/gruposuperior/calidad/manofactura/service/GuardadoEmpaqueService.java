package com.gruposuperior.calidad.manofactura.service;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraEmpaqueDTO;
import org.springframework.stereotype.Service;

@Service
public interface GuardadoEmpaqueService {

    Boolean registroRespuesta(CabeceraEmpaqueDTO data);

}
