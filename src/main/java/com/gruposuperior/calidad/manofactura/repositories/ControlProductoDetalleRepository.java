package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.ControlProductoDetalle;

@Repository("controlProductoDetalleRepository")
public interface ControlProductoDetalleRepository extends JpaRepository<ControlProductoDetalle, Integer> {

}
