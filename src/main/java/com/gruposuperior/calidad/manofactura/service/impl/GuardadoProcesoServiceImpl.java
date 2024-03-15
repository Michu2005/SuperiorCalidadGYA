package com.gruposuperior.calidad.manofactura.service.impl;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraProcesoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleProcesoDTO;
import com.gruposuperior.calidad.manofactura.entities.ControlProductoCabecera;
import com.gruposuperior.calidad.manofactura.entities.ControlProductoDetalle;
import com.gruposuperior.calidad.manofactura.repositories.ControlProductoCabeceraRepository;
import com.gruposuperior.calidad.manofactura.repositories.ControlProductoDetalleRepository;
import com.gruposuperior.calidad.manofactura.service.GuardadoProcesoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GuardadoProcesoServiceImpl implements GuardadoProcesoService {

    @Autowired
    private ControlProductoCabeceraRepository controlProductoCabeceraRepository;
    @Autowired
    private ControlProductoDetalleRepository controlProductoDetalleRepository;

    @Override
    @Transactional
    public Boolean registroRespuesta(CabeceraProcesoDTO data) {
        System.out.println("Desde el servicio: " +data);
        ControlProductoCabecera controlProductoCabecera = new ControlProductoCabecera();
        controlProductoCabecera.setActivo(true);
        controlProductoCabecera.setCreado(new Date());
        controlProductoCabecera.setIdSupervisor(data.getIdSupervisor());
        controlProductoCabecera.setIdAnalista(data.getIdAnalista());
        controlProductoCabecera.setIdLinea(data.getIdLinea());
        controlProductoCabecera.setIdProducto(data.getIdProducto());
        controlProductoCabecera.setIdTurno(data.getIdTurno());

        try {
            System.out.println(controlProductoCabecera);
            ControlProductoCabecera respuesta = controlProductoCabeceraRepository.save(controlProductoCabecera);
            if (respuesta != null){
                int i = 1;
                for (DetalleProcesoDTO detalleProcesoDTO : data.getDetalleProcesoDTOList()){
                    ControlProductoDetalle controlProductoDetalle = new ControlProductoDetalle();
                    controlProductoDetalle.setActivo(true);
                    controlProductoDetalle.setCreado(new Date());
                    controlProductoDetalle.setNumeroRegistro(i);
                    controlProductoDetalle.setValorZona1(detalleProcesoDTO.getValorZona1());
                    controlProductoDetalle.setValorZona2(detalleProcesoDTO.getValorZona2());
                    controlProductoDetalle.setValorZona3(detalleProcesoDTO.getValorZona3());
                    controlProductoDetalle.setIdParametro(detalleProcesoDTO.getIdParametro());
                    controlProductoDetalleRepository.save(controlProductoDetalle);
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
