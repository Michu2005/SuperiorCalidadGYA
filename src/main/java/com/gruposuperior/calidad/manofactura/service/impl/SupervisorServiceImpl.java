package com.gruposuperior.calidad.manofactura.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraEmpaqueDTO;
import com.gruposuperior.calidad.manofactura.dto.response.CabeceraProcesoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleEmpaqueDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleProcesoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.EmpleadoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.FiltroProductosDTO;
import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueCabecera;
import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueDetalle;
import com.gruposuperior.calidad.manofactura.entities.ControlProductoCabecera;
import com.gruposuperior.calidad.manofactura.entities.ControlProductoDetalle;
import com.gruposuperior.calidad.manofactura.entities.Linea;
import com.gruposuperior.calidad.manofactura.entities.Maquina;
import com.gruposuperior.calidad.manofactura.entities.Parametro;
import com.gruposuperior.calidad.manofactura.entities.PerfilEmpleado;
import com.gruposuperior.calidad.manofactura.entities.Proceso;
import com.gruposuperior.calidad.manofactura.entities.Producto;
import com.gruposuperior.calidad.manofactura.entities.Turno;
import com.gruposuperior.calidad.manofactura.repositories.ControlEmpaqueCabeceraRepository;
import com.gruposuperior.calidad.manofactura.repositories.ControlEmpaqueDetalleRepository;
import com.gruposuperior.calidad.manofactura.repositories.ControlProductoCabeceraRepository;
import com.gruposuperior.calidad.manofactura.repositories.ControlProductoDetalleRepository;
import com.gruposuperior.calidad.manofactura.repositories.LineaRepository;
import com.gruposuperior.calidad.manofactura.repositories.MaquinaRepository;
import com.gruposuperior.calidad.manofactura.repositories.ParametroRepository;
import com.gruposuperior.calidad.manofactura.repositories.PerfilEmpleadoRepository;
import com.gruposuperior.calidad.manofactura.repositories.ProcesoRepository;
import com.gruposuperior.calidad.manofactura.repositories.ProductoRepository;
import com.gruposuperior.calidad.manofactura.repositories.TurnoRepository;
import com.gruposuperior.calidad.manofactura.service.SupervisorService;

import jakarta.transaction.Transactional;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    private ControlEmpaqueCabeceraRepository empaqueRepository;
    @Autowired
    private ControlProductoCabeceraRepository productoempaqueRepository;
    @Autowired
    private ControlEmpaqueDetalleRepository controlEmpaqueDetalleRepository;
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
    @Autowired
    private ParametroRepository parametroRepository;
    @Autowired
    private ProcesoRepository procesoRepository;

    // Seccion de Busqueda de Datos
    @Override
    public List<CabeceraEmpaqueDTO> listaEmpaqueDTO(FiltroProductosDTO filtro) {
        List<ControlEmpaqueCabecera> retorno = new ArrayList<>();
        List<CabeceraEmpaqueDTO> listaRetorno = new ArrayList<>();
        try {
            retorno = empaqueRepository.findAll();
            if (filtro.getIdSupervisor() != 0)
                retorno = retorno.stream().filter((x) -> x.getIdSupervisor() == filtro.getIdSupervisor()).toList();
            if (filtro.getIdAnalista() != 0)
                retorno = retorno.stream().filter((x) -> x.getIdAnalista() == filtro.getIdAnalista()).toList();
            if (filtro.getIdProducto() != 0)
                retorno = retorno.stream().filter((x) -> x.getIdProducto() == filtro.getIdProducto()).toList();
            if (filtro.getIdMaquina() != 0)
                retorno = retorno.stream().filter((x) -> x.getIdMaquina() == filtro.getIdMaquina()).toList();
            if (filtro.getFechaDesde() != null)
                retorno = retorno.stream().filter((x) -> x.getCreado().equals(filtro.getFechaDesde())
                        || x.getCreado().after(filtro.getFechaDesde())).toList();
            if (filtro.getFechaDesde() != null)
                retorno = retorno.stream().filter((x) -> x.getCreado().equals(filtro.getFechaHasta())
                        || x.getCreado().before(filtro.getFechaHasta())).toList();

            listaRetorno = listarEmpaquesDTO(retorno);
        } catch (Exception e) {
            System.err.println(e);
        }
        return listaRetorno;
    }

    @Override
    public List<CabeceraProcesoDTO> listaProcesoDTO(FiltroProductosDTO filtro) {
        List<ControlProductoCabecera> lista = new ArrayList<>();
        List<CabeceraProcesoDTO> listaRetorno = new ArrayList<>();
        // Mapeo de Datos BD a DTO
        try {
            lista = productoempaqueRepository.findAll();
            if (filtro.getIdSupervisor() != 0)
                lista = lista.stream().filter((x) -> x.getIdSupervisor() == filtro.getIdSupervisor()).toList();
            if (filtro.getIdAnalista() != 0)
                lista = lista.stream().filter((x) -> x.getIdAnalista() == filtro.getIdAnalista()).toList();
            if (filtro.getIdProducto() != 0)
                lista = lista.stream().filter((x) -> x.getIdProducto() == filtro.getIdProducto()).toList();
            if (filtro.getFechaDesde() != null)
                lista = lista.stream().filter((x) -> x.getCreado().equals(filtro.getFechaDesde())
                        || x.getCreado().after(filtro.getFechaDesde())).toList();
            if (filtro.getFechaHasta() != null)
                lista = lista.stream().filter((x) -> x.getCreado().equals(filtro.getFechaHasta())
                        || x.getCreado().before(filtro.getFechaHasta())).toList();
            listaRetorno = listarProcesosDTO(lista);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaRetorno;
    }

    /**
     * Seccion de lista de SAC y AAC
     */
    public List<EmpleadoDTO> listarAnalistaPorSupervisorProducto(int idSupervisor) {
        List<EmpleadoDTO> retorno = new ArrayList<>();
        int tipo = 2;
        try {
            List<ControlProductoCabecera> lista = productoempaqueRepository.findAll().stream()
                    .filter((x) -> x.getIdSupervisor() == idSupervisor).toList();
            List<CabeceraProcesoDTO> cabeceras = new ArrayList<>();
            cabeceras = listarProcesosDTO(lista);

            Map<Integer, List<CabeceraProcesoDTO>> mapLista = cabeceras.stream()
                    .collect(Collectors.groupingBy(CabeceraProcesoDTO::getIdAnalista));

            Set<Integer> keys = mapLista.keySet();
            for (Integer key : keys) {
                var empleado = perfilEmpleadoRepository.findAll().stream().filter((x) -> x.getEmpleado().getId() == key)
                        .findAny().get();
                EmpleadoDTO item = new EmpleadoDTO();
                item.setCodigo(empleado.getEmpleado().getCodigo());
                item.setNombre(empleado.getEmpleado().getNombre());
                item.setIdEmpleado(empleado.getEmpleado().getId());
                item.setTipo(tipo);
                retorno.add(item);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public List<EmpleadoDTO> listarAnalistaPorSupervisorEmpaque(int idSupervisor) {
        List<EmpleadoDTO> retorno = new ArrayList<>();
        int tipo = 1;
        try {
            List<ControlEmpaqueCabecera> lista = empaqueRepository.findAll().stream()
                    .filter((x) -> x.getIdSupervisor() == idSupervisor).toList();
            List<CabeceraEmpaqueDTO> cabeceras = new ArrayList<>();
            cabeceras = listarEmpaquesDTO(lista);

            Map<Integer, List<CabeceraEmpaqueDTO>> mapLista = cabeceras.stream()
                    .collect(Collectors.groupingBy(CabeceraEmpaqueDTO::getIdAnalista));

            Set<Integer> keys = mapLista.keySet();
            for (Integer key : keys) {
                var empleado = perfilEmpleadoRepository.findAll().stream().filter((x) -> x.getEmpleado().getId() == key)
                        .findAny().get();
                EmpleadoDTO item = new EmpleadoDTO();
                item.setCodigo(empleado.getEmpleado().getCodigo());
                item.setNombre(empleado.getEmpleado().getNombre());
                item.setIdEmpleado(empleado.getEmpleado().getId());
                item.setTipo(tipo);
                retorno.add(item);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    /**
     * Seccion de Servicios de Actualizacion de Datos
     * 
     * @throws Exception
     */
    @Override
    @Transactional
    public Boolean editarDetalleEmpaque(DetalleEmpaqueDTO data) throws Exception {
        Boolean validar = false;
        try {
            ControlEmpaqueDetalle retorno = controlEmpaqueDetalleRepository.findAll()
                    .stream()
                    .filter((x) -> x.getId() == data.getIdDetalle())
                    .findFirst()
                    .get();
            if (Objects.nonNull(retorno)) {
                retorno.setNumeroRegistro(data.getNumeroRegistro());
                retorno.setDatoPesoCorrugado(data.getDatoPesoCorrugado());
                retorno.setDatoPesoPrimario(data.getDatoPesoPrimario());
                retorno.setDatoPesoSecundario(data.getDatoPesoSecundario());
                retorno.setDatoPesoCorrugado(data.getDatoPesoCorrugado());
                retorno.setDatoPesoGalletaRota(data.getDatoPesoGalletaRota());
                retorno.setDatoPesoGalletaRotaCalcualado(data.getDatoPesoGalletaRotaCalcualado());
                retorno.setDatoPesoPrimarioHermeticidad(data.getDatoPesoPrimarioHermeticidad());
                retorno.setDatoPesoPrimarioParametroAdic(data.getDatoPesoPrimarioParametroAdic());
                retorno.setActivo(data.isActivo());
                retorno.setBorrado(data.getBorrado());
                retorno.setCreado(data.getCreado());
                controlEmpaqueDetalleRepository.save(retorno);
                validar = true;
            } else {
                throw new Exception("No se pudo Actualizar el Registro!!");
            }

        } catch (Exception e) {
            throw new Exception("Error en el proceso de Actualización:");
        }
        return validar;
    }

    @Override
    @Transactional
    public Boolean editarControlProductoDetalle(DetalleProcesoDTO data) throws Exception {
        Boolean validar = false;
        try {
            ControlProductoDetalle retorno = controlProductoDetalleRepository.findAll()
                    .stream()
                    .filter((x) -> x.getId() == data.getId())
                    .findFirst()
                    .get();
            if (Objects.nonNull(retorno)) {
                retorno.setIdParametro(data.getIdParametro());
                retorno.setNumeroRegistro(data.getNumeroRegistro());
                retorno.setValorZona1(data.getValorZona1());
                retorno.setValorZona2(data.getValorZona2());
                retorno.setValorZona3(data.getValorZona3());
                retorno.setActivo(data.isActivo());
                retorno.setBorrado(data.getBorrado());
                retorno.setCreado(data.getCreado());
                controlProductoDetalleRepository.save(retorno);
                validar = true;
            } else {
                throw new Exception("No se pudo Actualizar el Registro!!");
            }

        } catch (Exception e) {
            throw new Exception("Error en el proceso de Actualización:");
        }
        return validar;
    }

    /**
     * Seccion Para mapear de DAO A DTO
     */
    public List<CabeceraEmpaqueDTO> listarEmpaquesDTO(List<ControlEmpaqueCabecera> lista) {
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
                List<ControlEmpaqueDetalle> detallesRet = controlEmpaqueDetalleRepository.findAll()
                        .stream()
                        .filter((x) -> x.getControlEmpaqueCabecera().getId() == item.getId())
                        .toList();
                ;
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
                nuevo.setDetalleEmpaqueDTOList(listaDetalleEmpaqueDTO(detallesRet, item.getId()));
                retorno.add(nuevo);
            });
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        return retorno;
    }

    public List<DetalleEmpaqueDTO> listaDetalleEmpaqueDTO(List<ControlEmpaqueDetalle> lista, int idCabecera) {
        List<DetalleEmpaqueDTO> retorno = new ArrayList<>();
        try {
            lista.forEach((item) -> {
                Parametro parametro = parametroRepository.findAll().stream()
                        .filter((f) -> f.getId() == item.getParametro().getId()).findFirst().get();
                DetalleEmpaqueDTO detalle = new DetalleEmpaqueDTO();
                detalle.setIdDetalle(item.getId());
                detalle.setDatoPesoPrimario(item.getDatoPesoPrimario() != null ? item.getDatoPesoPrimario() : 0);
                detalle.setDatoPesoSecundario(item.getDatoPesoSecundario() != null ? item.getDatoPesoSecundario() : 0);
                detalle.setDatoPesoCorrugado(item.getDatoPesoCorrugado() != null ? item.getDatoPesoCorrugado() : 0);
                detalle.setDatoPesoGalletaRota(
                        item.getDatoPesoGalletaRota() != null ? item.getDatoPesoGalletaRota() : 0);
                detalle.setNumeroRegistro(item.getNumeroRegistro());
                // detalle.setValor();
                detalle.setDatoPesoGalletaRota(
                        item.getDatoPesoGalletaRota() != null ? item.getDatoPesoGalletaRota() : 0);
                detalle.setDatoPesoGalletaRotaCalcualado(
                        item.getDatoPesoGalletaRotaCalcualado() != null ? item.getDatoPesoGalletaRotaCalcualado() : 0);
                detalle.setDatoPesoPrimarioGalletaRota(
                        item.getDatoPesoGalletaRotaCalcualado() != null ? item.getDatoPesoGalletaRotaCalcualado() : 0);
                detalle.setDatoPesoPrimarioHermeticidad(
                        item.getDatoPesoPrimarioHermeticidad() != null ? item.getDatoPesoPrimarioHermeticidad() : 0);
                detalle.setDatoPesoPrimarioParametroAdic(
                        item.getDatoPesoPrimarioParametroAdic() != null ? item.getDatoPesoPrimarioParametroAdic() : 0);
                detalle.setActivo(item.getActivo());
                detalle.setBorrado(item.getBorrado());
                detalle.setCreado(item.getCreado());
                detalle.setMin(parametro.getMin());
                detalle.setMax(parametro.getMax());
                detalle.setDescripcionParametro(parametro.getDescripcion());
                detalle.setNumeroRegistro(item.getNumeroRegistro());
                /*
                 * detalle.setSinFuga(parametro.);
                 * detalle.setFugaGrave();
                 * detalle.setFugaLeve();
                 */

                retorno.add(detalle);
            });

        } catch (Exception e) {
            System.err.println(e);
        }
        return retorno;
    }

    public List<CabeceraProcesoDTO> listarProcesosDTO(List<ControlProductoCabecera> lista) {
        List<CabeceraProcesoDTO> retorno = new ArrayList<>();
        List<ControlProductoDetalle> detalles = controlProductoDetalleRepository.findAll();
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
                Linea linea = lineaRepository.findAll().stream().filter((x) -> x.getId() == item.getIdLinea())
                        .findFirst().get();
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
                // Datos DTO
                nuevo.setNombreAAC(analistaSel.getEmpleado().getNombre());
                nuevo.setNombreSAC(supervisorSel.getEmpleado().getNombre());
                nuevo.setNombreProducto(producto.getDescripcion());
                nuevo.setTurno(turno.getDescripcion());
                nuevo.setLinea(linea.getDescripcion());
                nuevo.setHora(fecha.format(f));
                nuevo.setFecha(item.getCreado().toString());
                nuevo.setDetalleProcesoDTOList(listaDetallesProcesoDTO(detalles, item.getId()));
                retorno.add(nuevo);
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public List<DetalleProcesoDTO> listaDetallesProcesoDTO(List<ControlProductoDetalle> lista, int idCabecera) {
        List<DetalleProcesoDTO> retorno = new ArrayList<>();
        List<ControlProductoDetalle> detalles = new ArrayList<>();
        try {
            detalles = lista.stream().filter((s) -> s.getControlProductoCabecera().getId() == idCabecera).toList();
            detalles.forEach((item) -> {
                Parametro parametro = parametroRepository.findAll()
                        .stream().filter((x) -> x.getId() == item.getIdParametro())
                        .findFirst().get();
                Proceso proceso = procesoRepository.findAll().stream()
                        .filter((x) -> x.getId() == parametro.getIdProceso())
                        .findFirst().get();
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
                nuevo.setDescripcionParametro(parametro.getDescripcion());
                nuevo.setMin(parametro.getMin());
                nuevo.setMax(parametro.getMax());
                nuevo.setDescripcionProceso(proceso.getDescripcion());

                retorno.add(nuevo);
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
