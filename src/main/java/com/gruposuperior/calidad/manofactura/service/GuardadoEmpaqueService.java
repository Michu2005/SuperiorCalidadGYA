package com.gruposuperior.calidad.manofactura.service;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraEmpaqueDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface GuardadoEmpaqueService {

    List<Integer> registroRespuesta(CabeceraEmpaqueDTO data);

}
