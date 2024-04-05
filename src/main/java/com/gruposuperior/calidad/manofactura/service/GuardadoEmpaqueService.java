package com.gruposuperior.calidad.manofactura.service;

import com.gruposuperior.calidad.manofactura.dto.response.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface GuardadoEmpaqueService {

    RespuestaDTO registroRespuesta(CabeceraEmpaqueDTO data);

    Boolean registrarGalletaRota(List<DetalleEmpaqueGalletaRotaDTO> data);

    Boolean registrarHermeticidad(List<DetalleEmpaqueHermeticidadDTO> data);

    Boolean registrarParametrosAdicionales(List<ParametrosAdicionalesDTO> data);

}
