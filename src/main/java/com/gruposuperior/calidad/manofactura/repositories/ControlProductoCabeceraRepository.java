package com.gruposuperior.calidad.manofactura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.ControlProductoCabecera;

@Repository("controlProductoCabeceraRepository")
public interface ControlProductoCabeceraRepository extends JpaRepository<ControlProductoCabecera, Integer> {
    @Query(value = "Select * FROM control_producto_cabecera c "
            + " where c.id_supervisor = :id_supervisor", nativeQuery = true)
    List<ControlProductoCabecera> findProcesosByFiltros(@Param("id_supervisor") int id_supervisor);

}
