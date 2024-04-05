package com.gruposuperior.calidad.manofactura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueDetalle;

@Repository("controlEmpaqueDetalleRepository")
public interface ControlEmpaqueDetalleRepository extends JpaRepository<ControlEmpaqueDetalle, Integer> {
  /*  @Query(value = "Select * FROM control_empaque_detalle d WHERE d.id_control_empaque_cabecera = :idCabecera",nativeQuery = true)
    List<ControlEmpaqueDetalle> detallebyIdCabecera(@Param("idCabecera") int idCabecera);*/
}
