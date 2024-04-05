
package com.gruposuperior.calidad.manofactura.Mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraEmpaqueDTO;
import com.gruposuperior.calidad.manofactura.dto.response.CabeceraProcesoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleEmpaqueDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleProcesoDTO;
import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueCabecera;
import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueDetalle;
import com.gruposuperior.calidad.manofactura.entities.ControlProductoCabecera;
import com.gruposuperior.calidad.manofactura.entities.ControlProductoDetalle;
import com.gruposuperior.calidad.manofactura.entities.Empleado;
import com.gruposuperior.calidad.manofactura.entities.Linea;
import com.gruposuperior.calidad.manofactura.entities.Maquina;
import com.gruposuperior.calidad.manofactura.entities.PerfilEmpleado;
import com.gruposuperior.calidad.manofactura.entities.Producto;
import com.gruposuperior.calidad.manofactura.entities.Turno;
import com.gruposuperior.calidad.manofactura.repositories.ControlProductoDetalleRepository;
import com.gruposuperior.calidad.manofactura.repositories.EmpleadoRepository;
import com.gruposuperior.calidad.manofactura.repositories.LineaRepository;
import com.gruposuperior.calidad.manofactura.repositories.MaquinaRepository;
import com.gruposuperior.calidad.manofactura.repositories.PerfilEmpleadoRepository;
import com.gruposuperior.calidad.manofactura.repositories.ProductoRepository;
import com.gruposuperior.calidad.manofactura.repositories.TurnoRepository;

@Service
public class SupervisorMapper {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private ControlProductoDetalleRepository controlProductoDetalleRepository;
    @Autowired
    private PerfilEmpleadoRepository perfilEmpleadoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private TurnoRepository turnoRepository;
    @Autowired
    private MaquinaRepository maquinaRepository;
    @Autowired
    private LineaRepository lineaRepository;

    public SupervisorMapper() {

    }

    public List<CabeceraEmpaqueDTO> listaEmpaqueDTO(List<ControlEmpaqueCabecera> lista) {
        List<CabeceraEmpaqueDTO> retorno = new ArrayList<>();
        try {
            LocalDateTime fecha = LocalDateTime.now();
            DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:MM");
            int analista = 3;
            int supervisor = 2;
            List<PerfilEmpleado> catalogoAnalistas = perfilEmpleadoRepository.findByIdPerfil(analista);
            List<PerfilEmpleado> catalogoSupervisor = perfilEmpleadoRepository.findByIdPerfil(supervisor);
            lista.forEach((item) -> {
                PerfilEmpleado analistaSel = catalogoAnalistas.stream()
                        .filter((x) -> x.getEmpleado().getId() == item.getIdAnalista()).findFirst().get();
                PerfilEmpleado supervisorSel = catalogoSupervisor.stream()
                        .filter((x) -> x.getEmpleado().getId() == item.getIdSupervisor()).findFirst().get();
                Producto producto = productoRepository.findAll().stream()
                        .filter((p) -> p.getId() == item.getIdProducto()).findFirst().get();
                Turno turno = turnoRepository.findAll().stream().filter((x) -> x.getId() == item.getIdTurno())
                        .findFirst().get();
                Maquina maquina = maquinaRepository.findAll().stream().filter((x) -> x.getId() == item.getIdMaquina())
                        .findFirst().get();
                Linea linea = lineaRepository.findAll().stream().filter((x) -> x.getId() == item.getIdLinea())
                        .findFirst().get();
                // List<ControlEmpaqueDetalle> detallesRet =
                // detalleRepository.findAll().stream().filter((x) ->
                // x.getControlEmpaqueCabecera().getId() == item.getId()).toList();
                CabeceraEmpaqueDTO nuevo = new CabeceraEmpaqueDTO();
                nuevo.setIdCabecera(item.getId());
                nuevo.setIdSupervisor(item.getIdSupervisor());
                nuevo.setIdAnalista(item.getIdAnalista().intValue());
                nuevo.setIdTurno(item.getIdTurno().intValue());
                nuevo.setIdLinea(item.getIdLinea().intValue());
                nuevo.setIdProducto(item.getIdProducto().intValue());
                nuevo.setIdMaquina(item.getIdMaquina().intValue());
                nuevo.setLote(item.getLote());
                // Mapeo Descripciones DTO
                nuevo.setNombreAnalista(analistaSel.getEmpleado().getNombre());
                nuevo.setNombreSupervisor(supervisorSel.getEmpleado().getNombre());
                nuevo.setNombreProducto(producto.getDescripcion());
                nuevo.setDescripcionTurno(turno.getDescripcion());
                nuevo.setDescripcionMaquina(maquina.getDescripcion());
                nuevo.setDescripcionLinea(linea.getDescripcion());
                nuevo.setHora(fecha.format(f));
                nuevo.setFecha(item.getCreado().toString());
                // nuevo.setDetalleEmpaqueDTOList(listaDetalleEmpaqueDTO(item.getControlEmpaqueDetalles()));
                retorno.add(nuevo);
            });
        } catch (Exception e) {
            System.err.println("Error: "+e);
        }
        return retorno;
    }

    public List<DetalleEmpaqueDTO> listaDetalleEmpaqueDTO(List<ControlEmpaqueDetalle> lista) {
        List<DetalleEmpaqueDTO> retorno = new ArrayList<>();
        try {
            lista.forEach((item) -> {
                DetalleEmpaqueDTO detalle = new DetalleEmpaqueDTO();
                detalle.setIdDetalle(item.getId());
                detalle.setDatoPesoPrimario(item.getDatoPesoPrimario());
                detalle.setDatoPesoSecundario(item.getDatoPesoSecundario());
                detalle.setDatoPesoCorrugado(item.getDatoPesoCorrugado());
                detalle.setDatoPesoGalletaRota(item.getDatoPesoGalletaRota());
                detalle.setNumeroRegistro(item.getNumeroRegistro());
                // detalle.setValor();
                detalle.setDatoPesoGalletaRota(item.getDatoPesoGalletaRota());
                detalle.setDatoPesoGalletaRotaCalcualado(item.getDatoPesoGalletaRotaCalcualado());
                detalle.setDatoPesoPrimarioGalletaRota(item.getDatoPesoPrimarioGalletaRota());
                detalle.setDatoPesoPrimarioHermeticidad(item.getDatoPesoPrimarioHermeticidad());
                detalle.setDatoPesoPrimarioParametroAdic(item.getDatoPesoPrimarioParametroAdic());
                detalle.setActivo(item.getActivo());
                detalle.setBorrado(item.getBorrado());
                detalle.setCreado(item.getCreado());
            });

        } catch (Exception e) {

        }
        return retorno;
    }

    public List<CabeceraProcesoDTO> listaProcesoDTO(List<ControlProductoCabecera> lista) {
        List<CabeceraProcesoDTO> retorno = new ArrayList<>();
        List<Empleado> emp = empleadoRepository.findAll();
        try {
            lista.forEach((item) -> {
                List<ControlProductoDetalle> detalles = controlProductoDetalleRepository
                        .findDetallesProducto(item.getId());
                CabeceraProcesoDTO nuevo = new CabeceraProcesoDTO();
                nuevo.setId(item.getId());
                nuevo.setIdSupervisor(item.getIdSupervisor());
                nuevo.setIdAnalista(item.getIdAnalista());
                nuevo.setIdTurno(item.getIdTurno());
                nuevo.setIdLinea(item.getIdLinea());
                nuevo.setIdProducto(item.getIdProducto());
                nuevo.setActivo(item.getActivo());
                nuevo.setBorrado(item.getBorrado());
                nuevo.setCreado(item.getCreado());
                nuevo.setDetalleProcesoDTOList(listaDetallesProcesoDTO(detalles));
                retorno.add(nuevo);
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public List<DetalleProcesoDTO> listaDetallesProcesoDTO(List<ControlProductoDetalle> lista) {
        List<DetalleProcesoDTO> retorno = new ArrayList<>();
        try {
            lista.forEach((item) -> {
                DetalleProcesoDTO nuevo = new DetalleProcesoDTO();
                nuevo.setId(item.getId());
                // nuevo.setIdCabeceraProceso(item.getControlProductoCabecera().getId());
                nuevo.setIdParametro(item.getIdParametro());
                nuevo.setNumeroRegistro(item.getNumeroRegistro());
                nuevo.setValorZona1(item.getValorZona1());
                nuevo.setValorZona2(item.getValorZona2());
                nuevo.setValorZona3(item.getValorZona3());
                nuevo.setActivo(item.getActivo());
                nuevo.setBorrado(item.getBorrado());
                nuevo.setCreado(item.getCreado());
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public ControlEmpaqueCabecera controlEmpaqueCabeceraMapper(CabeceraEmpaqueDTO item) {
        ControlEmpaqueCabecera retorno = new ControlEmpaqueCabecera();
        try {
            retorno.setActivo(item.isActivo());
            retorno.setBorrado(item.getBorrado());
            retorno.setCreado(item.getCreado());
            retorno.setIdSupervisor(item.getIdSupervisor());
            retorno.setIdAnalista(Double.valueOf(item.getIdAnalista()));
            retorno.setIdLinea(Double.valueOf(item.getIdLinea()));
            retorno.setIdProducto(Double.valueOf(item.getIdProducto()));
            retorno.setIdTurno(Double.valueOf(item.getIdTurno()));
            retorno.setIdMaquina(Double.valueOf(item.getIdMaquina()));
            retorno.setLote(item.getLote());
        } catch (Exception e) {

        }
        return retorno;
    }

    public ControlEmpaqueDetalle controlEmpaqueDetalleMapper(DetalleEmpaqueDTO item) {
        ControlEmpaqueDetalle retorno = new ControlEmpaqueDetalle();
        try {
            retorno.setNumeroRegistro(item.getNumeroRegistro());
            retorno.setDatoPesoCorrugado(item.getDatoPesoCorrugado());
            retorno.setDatoPesoPrimario(item.getDatoPesoPrimario());
            retorno.setDatoPesoSecundario(item.getDatoPesoSecundario());
            retorno.setDatoPesoCorrugado(item.getDatoPesoCorrugado());
            retorno.setDatoPesoGalletaRota(item.getDatoPesoGalletaRota());
            retorno.setDatoPesoGalletaRotaCalcualado(item.getDatoPesoGalletaRotaCalcualado());
            retorno.setDatoPesoPrimarioHermeticidad(item.getDatoPesoPrimarioHermeticidad());
            retorno.setDatoPesoPrimarioParametroAdic(item.getDatoPesoPrimarioParametroAdic());
            retorno.setActivo(item.isActivo());
            retorno.setBorrado(item.getBorrado());
            retorno.setCreado(item.getCreado());
        } catch (Exception e) {
        }
        return retorno;
    }

    public ControlProductoCabecera controlProductoCabeceraMapper(CabeceraProcesoDTO item) {
        ControlProductoCabecera retorno = new ControlProductoCabecera();
        try {
            retorno.setId(item.getId());
            retorno.setIdLinea(item.getIdLinea());
            retorno.setIdTurno(item.getIdTurno());
            retorno.setIdProducto(item.getIdProducto());
            retorno.setIdAnalista(item.getIdAnalista());
            retorno.setIdSupervisor(item.getIdSupervisor());
            retorno.setActivo(item.isActivo());
            retorno.setBorrado(item.getBorrado());
            retorno.setCreado(item.getCreado());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return retorno;
    }

    public ControlProductoDetalle controlProductoDetalleMapper(DetalleProcesoDTO item) {
        ControlProductoDetalle retorno = new ControlProductoDetalle();
        try {
            retorno.setIdParametro(item.getIdParametro());
            retorno.setNumeroRegistro(item.getNumeroRegistro());
            retorno.setValorZona1(item.getValorZona1());
            retorno.setValorZona2(item.getValorZona2());
            retorno.setValorZona3(item.getValorZona3());
            retorno.setActivo(item.isActivo());
            retorno.setBorrado(item.getBorrado());
            retorno.setCreado(item.getCreado());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return retorno;
    }

}
