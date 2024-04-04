package com.gruposuperior.calidad.manofactura.service;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraEmpaqueDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleEmpaqueGalletaRotaDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleEmpaqueHermeticidadDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ParametrosAdicionalesDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface GuardadoEmpaqueService {

    List<Integer> registroRespuesta(CabeceraEmpaqueDTO data);

    Boolean registrarGalletaRota(List<DetalleEmpaqueGalletaRotaDTO> data);

    Boolean registrarHermeticidad(List<DetalleEmpaqueHermeticidadDTO> data);

    //Boolean registrarParametrosAdicionales(List<ParametrosAdicionalesDTO> data);

}
