package com.gruposuperior.calidad.manofactura.service;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.response.CabeceraEmpaqueDTO;
import com.gruposuperior.calidad.manofactura.dto.response.CabeceraProcesoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleEmpaqueDTO;
import com.gruposuperior.calidad.manofactura.dto.response.DetalleProcesoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.EmpleadoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.FiltroProductosDTO;

public interface SupervisorService {
    public List<CabeceraEmpaqueDTO> listaEmpaqueDTO(FiltroProductosDTO filtro);
    public List<CabeceraProcesoDTO> listaProcesoDTO(FiltroProductosDTO filtro);
    Boolean editarDetalleEmpaque(DetalleEmpaqueDTO data) throws Exception;
    Boolean editarControlProductoDetalle(DetalleProcesoDTO data) throws Exception;
    public List<EmpleadoDTO> listarAnalistaPorSupervisorProducto(int codigoEmpleado);
    public List<EmpleadoDTO> listarAnalistaPorSupervisorEmpaque(int codigoEmpleado);
}