package com.gruposuperior.calidad.manofactura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.ControlProductoDetalle;

import jakarta.transaction.Transactional;

@Repository("controlProductoDetalleRepository")
@Transactional
public interface ControlProductoDetalleRepository extends JpaRepository<ControlProductoDetalle, Integer> {
    @Query(value = "Select * FROM control_producto_detalle"
            + " where id_control_producto_cabecera = ?1", nativeQuery = true)
    List<ControlProductoDetalle> findDetallesProducto(int codCabecera);
}
