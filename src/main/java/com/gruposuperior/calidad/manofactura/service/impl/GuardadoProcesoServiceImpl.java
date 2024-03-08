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

import java.util.Date;

public class GuardadoProcesoServiceImpl implements GuardadoProcesoService {

    @Autowired
    private ControlProductoCabeceraRepository controlProductoCabeceraRepository;
    @Autowired
    private ControlProductoDetalleRepository controlProductoDetalleRepository;

    @Override
    @Transactional
    public Boolean registroRespuesta(CabeceraProcesoDTO data) {
        ControlProductoCabecera controlProductoCabecera = new ControlProductoCabecera();
        controlProductoCabecera.setActivo(true);
        controlProductoCabecera.setCreado(new Date());
        controlProductoCabecera.setIdSupervisor(controlProductoCabecera.getIdSupervisor());
        controlProductoCabecera.setIdAnalista(controlProductoCabecera.getIdAnalista());
        controlProductoCabecera.setIdLinea(controlProductoCabecera.getIdLinea());
        controlProductoCabecera.setIdProducto(controlProductoCabecera.getIdProducto());
        controlProductoCabecera.setIdTurno(controlProductoCabecera.getIdTurno());

        try {
            ControlProductoCabecera respuesta = controlProductoCabeceraRepository.save(controlProductoCabecera);
            if (respuesta != null){
                for (DetalleProcesoDTO detalleProcesoDTO : data.getDetalleProcesoDTOList()){
                    ControlProductoDetalle controlProductoDetalle = new ControlProductoDetalle();
                    controlProductoDetalle.setActivo(true);
                    controlProductoDetalle.setCreado(new Date());
                    controlProductoDetalle.setNumeroRegistro(controlProductoDetalle.getNumeroRegistro());
                    controlProductoDetalle.setValorZona1(controlProductoDetalle.getValorZona1());
                    controlProductoDetalle.setValorZona2(controlProductoDetalle.getValorZona2());
                    controlProductoDetalle.setValorZona3(controlProductoDetalle.getValorZona3());

                    controlProductoDetalleRepository.save(controlProductoDetalle);
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
