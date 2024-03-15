package com.gruposuperior.calidad.manofactura.service.impl;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraProcesoDTO;
import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueCabecera;
import com.gruposuperior.calidad.manofactura.repositories.ControlEmpaqueCabeceraRepository;
import com.gruposuperior.calidad.manofactura.repositories.ControlEmpaqueDetalleRepository;
import com.gruposuperior.calidad.manofactura.service.GuardadoEmpaqueService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class GuardadoEmpaqueServiceImpl implements GuardadoEmpaqueService {

    @Autowired
    private ControlEmpaqueCabeceraRepository controlEmpaqueCabeceraRepository;
    @Autowired
    private ControlEmpaqueDetalleRepository controlEmpaqueDetalleRepository;

    @Override
    @Transactional
    public Boolean registroRespuesta(CabeceraProcesoDTO data) {
        ControlEmpaqueCabecera controlEmpaqueCabecera = new ControlEmpaqueCabecera();
        controlEmpaqueCabecera.setActivo(true);
        controlEmpaqueCabecera.setCreado(new Date());
        controlEmpaqueCabecera.setIdSupervisor(controlEmpaqueCabecera.getIdSupervisor());
        controlEmpaqueCabecera.setIdAnalista(controlEmpaqueCabecera.getIdAnalista());
        controlEmpaqueCabecera.setIdLinea(controlEmpaqueCabecera.getIdLinea());
        controlEmpaqueCabecera.setIdMaquina(controlEmpaqueCabecera.getIdMaquina());
        controlEmpaqueCabecera.setIdProducto(controlEmpaqueCabecera.getIdProducto());
        controlEmpaqueCabecera.setIdTurno(controlEmpaqueCabecera.getIdTurno());

        try {
            ControlEmpaqueCabecera respuesta = controlEmpaqueCabeceraRepository.save(controlEmpaqueCabecera);
            /*if (respuesta != null){
                for (){}
            }*/
        }catch (Exception e){
            return false;
        }

        return null;
    }
}
