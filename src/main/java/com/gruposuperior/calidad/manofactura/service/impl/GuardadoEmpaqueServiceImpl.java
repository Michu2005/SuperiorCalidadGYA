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

import java.util.Date;

@Service
public class GuardadoEmpaqueServiceImpl implements GuardadoEmpaqueService {

    @Autowired
    private ControlEmpaqueCabeceraRepository controlEmpaqueCabeceraRepository;
    @Autowired
    private ControlEmpaqueDetalleRepository controlEmpaqueDetalleRepository;

    @Override
    @Transactional
    public Boolean registroRespuesta(CabeceraEmpaqueDTO data) {
        ControlEmpaqueCabecera controlEmpaqueCabecera = new ControlEmpaqueCabecera();
        controlEmpaqueCabecera.setActivo(true);
        controlEmpaqueCabecera.setCreado(new Date());
        controlEmpaqueCabecera.setIdSupervisor(controlEmpaqueCabecera.getIdSupervisor());
        controlEmpaqueCabecera.setIdAnalista(controlEmpaqueCabecera.getIdAnalista());
        controlEmpaqueCabecera.setIdLinea(controlEmpaqueCabecera.getIdLinea());
        controlEmpaqueCabecera.setIdMaquina(controlEmpaqueCabecera.getIdMaquina());
        controlEmpaqueCabecera.setIdProducto(controlEmpaqueCabecera.getIdProducto());
        controlEmpaqueCabecera.setIdTurno(controlEmpaqueCabecera.getIdTurno());
        controlEmpaqueCabecera.setLote(controlEmpaqueCabecera.getLote());

        try {
            System.out.println(controlEmpaqueCabecera);
            ControlEmpaqueCabecera respuesta = controlEmpaqueCabeceraRepository.save(controlEmpaqueCabecera);
            if (respuesta != null){
                int i = 1;
                for (DetalleEmpaqueDTO detalleEmpaqueDTO : data.getDetalleEmpaqueDTOList()){
                    ControlEmpaqueDetalle controlEmpaqueDetalle = new ControlEmpaqueDetalle();
                    controlEmpaqueDetalle.setActivo(true);
                    controlEmpaqueDetalle.setCreado(new Date());
                    controlEmpaqueDetalle.setNumeroRegistro((short) i);
                    controlEmpaqueDetalle.setDatoPesoPrimario(detalleEmpaqueDTO.getDatoPesoPrimario());
                    controlEmpaqueDetalle.setDatoPesoSecundario(detalleEmpaqueDTO.getDatoPesoSecundario());
                    controlEmpaqueDetalle.setDatoPesoCorrugado(detalleEmpaqueDTO.getDatoPesoCorrugado());
                    //controlEmpaqueDetalle.setIdParametro(detalleEmpaqueDTO.getIdParametro());
                    controlEmpaqueDetalleRepository.save(controlEmpaqueDetalle);
                    i++;
                }
                i=1;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
