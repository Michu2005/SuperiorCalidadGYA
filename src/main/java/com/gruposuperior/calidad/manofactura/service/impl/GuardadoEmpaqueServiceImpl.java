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
        System.out.println("Desde el servicio: " +data);
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
            System.out.println(controlEmpaqueCabecera);
            ControlEmpaqueCabecera respuesta = controlEmpaqueCabeceraRepository.save(controlEmpaqueCabecera);
            if (respuesta != null){
                int i = 1;
                for (DetalleEmpaqueDTO detalleEmpaqueDTO : data.getDetalleEmpaqueDTOList()){
                    ControlEmpaqueDetalle controlEmpaqueDetalle = new ControlEmpaqueDetalle();
                    controlEmpaqueDetalle.setIdControlEmpaqueCabecera(controlEmpaqueCabecera.getId());
                    controlEmpaqueDetalle.setActivo(true);
                    controlEmpaqueDetalle.setCreado(new Date());
                    controlEmpaqueDetalle.setNumeroRegistro(i);
                    controlEmpaqueDetalle.setDatoPesoPrimario(detalleEmpaqueDTO.getDatoPesoPrimario());
                    controlEmpaqueDetalle.setDatoPesoSecundario(detalleEmpaqueDTO.getDatoPesoSecundario());
                    controlEmpaqueDetalle.setDatoPesoCorrugado(detalleEmpaqueDTO.getDatoPesoCorrugado());
                    controlEmpaqueDetalle.setIdParametro(detalleEmpaqueDTO.getIdParametro());
                    controlEmpaqueDetalleRepository.save(controlEmpaqueDetalle);
                    i++;
                }
                i=1;
            }
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e);
            return false;
        }
    }
}
