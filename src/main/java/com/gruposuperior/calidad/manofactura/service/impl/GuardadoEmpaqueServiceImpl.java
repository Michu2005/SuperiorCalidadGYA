package com.gruposuperior.calidad.manofactura.service.impl;

import com.gruposuperior.calidad.manofactura.dto.response.*;
import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueCabecera;
import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueDetalle;
import com.gruposuperior.calidad.manofactura.entities.ParametrosAdicionales;
import com.gruposuperior.calidad.manofactura.repositories.ControlEmpaqueCabeceraRepository;
import com.gruposuperior.calidad.manofactura.repositories.ControlEmpaqueDetalleRepository;
import com.gruposuperior.calidad.manofactura.service.GuardadoEmpaqueService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GuardadoEmpaqueServiceImpl implements GuardadoEmpaqueService {

    @Autowired
    private ControlEmpaqueCabeceraRepository controlEmpaqueCabeceraRepository;
    @Autowired
    private ControlEmpaqueDetalleRepository controlEmpaqueDetalleRepository;

    @Override
    @Transactional
    public List<Integer> registroRespuesta(CabeceraEmpaqueDTO data) {
        List<Integer> idGuardados = new ArrayList<>();
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
            if (respuesta != null) {
                int i = 1;
                // Guardar los detalles estándar de empaque
                for (DetalleEmpaqueDTO detalleEmpaqueDTO : data.getDetalleEmpaqueDTOList()) {
                    ControlEmpaqueDetalle controlEmpaqueDetalle = new ControlEmpaqueDetalle();
                    controlEmpaqueDetalle.setIdControlEmpaqueCabecera(respuesta.getId());
                    controlEmpaqueDetalle.setActivo(true);
                    controlEmpaqueDetalle.setCreado(new Date());
                    controlEmpaqueDetalle.setNumeroRegistro(i);
                    controlEmpaqueDetalle.setDatoPesoPrimario(detalleEmpaqueDTO.getDatoPesoPrimario());
                    controlEmpaqueDetalle.setDatoPesoSecundario(detalleEmpaqueDTO.getDatoPesoSecundario());
                    controlEmpaqueDetalle.setDatoPesoCorrugado(detalleEmpaqueDTO.getDatoPesoCorrugado());
                    controlEmpaqueDetalle.setIdParametro(detalleEmpaqueDTO.getIdParametro());
                    ControlEmpaqueDetalle respuestaRegistroDetalle = controlEmpaqueDetalleRepository.save(controlEmpaqueDetalle);
                    idGuardados.add(respuestaRegistroDetalle.getId());
                    i++;
                }

            }
            return idGuardados;
        } catch (Exception e) {
            System.out.println("Error en guardar detalles de empaque: " + e);
            return idGuardados;
        }
    }

    @Override
    @Transactional
    public Boolean registrarGalletaRota(List<DetalleEmpaqueGalletaRotaDTO> data) {
        try{
            for(DetalleEmpaqueGalletaRotaDTO detalle : data){
                Optional<ControlEmpaqueDetalle> registroBuscado = controlEmpaqueDetalleRepository.findById(detalle.getIdGuardado());
                if(registroBuscado.isPresent()){
                    ControlEmpaqueDetalle registroActualizado = registroBuscado.get();
                    registroActualizado.setDatoPesoGalletaRota(detalle.getDatoPesoGalletaRota());
                    registroActualizado.setDatoGalletaRotaCalculado(detalle.getDatoPesoGalletaRotaCalculado());
                    registroActualizado.setDatoPesoPrimarioGalletaRota(detalle.getDatoPesoPrimarioGalletaRota());
                    controlEmpaqueDetalleRepository.save(registroActualizado);
                }
            }
            return true;
        }catch (Exception e){
            System.out.println("Error en guardar detalles de empaque: " + e);
            return false;
        }
    }

    @Override
    public Boolean registrarHermeticidad(List<DetalleEmpaqueHermeticidadDTO> data) {
        try {
            for (DetalleEmpaqueHermeticidadDTO detalle : data){
                Optional<ControlEmpaqueDetalle> registroBuscado = controlEmpaqueDetalleRepository.findById(detalle.getIdGuardado());
                if (registroBuscado.isPresent()){
                    ControlEmpaqueDetalle registroActualizado = registroBuscado.get();
                    registroActualizado.setDatoHermeticidad(detalle.getDatoHermeticidad());
                    controlEmpaqueDetalleRepository.save(registroActualizado);
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar detalles de hermeticidad: " + e);
            return false;
        }
    }

    /*@Override
    public Boolean registrarParametrosAdicionales(List<ParametrosAdicionalesDTO> data) {
        try{
            for (ParametrosAdicionalesDTO detalle : data){
                Optional<ControlEmpaqueDetalle> registroBuscado = controlEmpaqueDetalleRepository.findById(detalle.getIdControlEmpaqueCabecera());
                if (registroBuscado.isPresent()){
                    ControlEmpaqueDetalle registroActualizado = registroBuscado.get();
                    controlEmpaqueDetalleRepository.save(registroActualizado);
                }
            }
            return true;
        }catch(Exception e){
            System.out.println("Error al guardar detalles de parametros adicionales: "+ e);
            return false;
        }
    }*/
}
