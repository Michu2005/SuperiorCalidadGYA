package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.ControlProductoCabecera;

@Repository("controlProductoCabeceraRepository")
public interface ControlProductoCabeceraRepository extends JpaRepository<ControlProductoCabecera, Integer> {

}
