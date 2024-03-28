package com.gruposuperior.calidad.manofactura.service.impl;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraEmpaqueDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleEmpaqueDTO;
import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueCabecera;
import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueDetalle;
import com.gruposuperior.calidad.manofactura.repositories.ControlEmpaqueCabeceraRepository;
import com.gruposuperior.calidad.manofactura.repositories.ControlEmpaqueDetalleRepository;
import com.gruposuperior.calidad.manofactura.service.GuardadoEmpaqueService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GuardadoEmpaqueServiceImpl implements GuardadoEmpaqueService {

    @Autowired
    private ControlEmpaqueCabeceraRepository controlEmpaqueCabeceraRepository;

    @Autowired
    private ControlEmpaqueDetalleRepository controlEmpaqueDetalleRepository;

    @Override
    @Transactional
    public List<Integer> registroRespuesta(CabeceraEmpaqueDTO data) {
        List<Integer> idsGuardados = new ArrayList<>();
        ControlEmpaqueCabecera controlEmpaqueCabecera = new ControlEmpaqueCabecera();
        controlEmpaqueCabecera.setActivo(true);
        controlEmpaqueCabecera.setIdSupervisor(data.getIdSupervisor());
        controlEmpaqueCabecera.setCreado(new Date());
        controlEmpaqueCabecera.setIdAnalista(data.getIdAnalista());
        controlEmpaqueCabecera.setIdLinea(data.getIdLinea());
        controlEmpaqueCabecera.setIdMaquina(data.getIdMaquina());
        controlEmpaqueCabecera.setIdProducto(data.getIdProducto());
        controlEmpaqueCabecera.setIdTurno(data.getIdTurno());
        controlEmpaqueCabecera.setLote(data.getLote());

        try {
            ControlEmpaqueCabecera respuesta = controlEmpaqueCabeceraRepository.save(controlEmpaqueCabecera);
            if (respuesta != null) {
                // Guardar los detalles iniciales de empaque
                for (DetalleEmpaqueDTO detalleEmpaqueDTO : data.getDetalleEmpaqueDTOList()) {
                    ControlEmpaqueDetalle controlEmpaqueDetalle = new ControlEmpaqueDetalle();
                    controlEmpaqueDetalle.setIdControlEmpaqueCabecera(respuesta.getId()); // Usar el ID de la cabecera guardada
                    controlEmpaqueDetalle.setActivo(true);
                    controlEmpaqueDetalle.setCreado(new Date());
                    controlEmpaqueDetalle.setNumeroRegistro(detalleEmpaqueDTO.getIdControlEmpaqueCabecera()); // Usar el número de registro proporcionado
                    controlEmpaqueDetalle.setDatoPesoPrimario(detalleEmpaqueDTO.getDatoPesoPrimario());
                    controlEmpaqueDetalle.setDatoPesoSecundario(detalleEmpaqueDTO.getDatoPesoSecundario());
                    controlEmpaqueDetalle.setDatoPesoCorrugado(detalleEmpaqueDTO.getDatoPesoCorrugado());
                    controlEmpaqueDetalle.setIdParametro(detalleEmpaqueDTO.getIdParametro());
                    ControlEmpaqueDetalle detalleGuardado = controlEmpaqueDetalleRepository.save(controlEmpaqueDetalle);
                    idsGuardados.add(detalleGuardado.getId());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return idsGuardados;
    }
}
