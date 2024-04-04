package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueDetalle;

@Repository("controlEmpaqueDetalleRepository")
public interface ControlEmpaqueDetalleRepository extends JpaRepository<ControlEmpaqueDetalle, Integer> {
    ControlEmpaqueDetalle findByIdControlEmpaqueCabecera(Integer idControlEmpaqueCabecera);
}
