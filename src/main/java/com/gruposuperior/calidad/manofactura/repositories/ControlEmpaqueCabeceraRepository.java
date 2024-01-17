package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.ControlEmpaqueCabecera;

@Repository("controlEmpaqueCabeceraRepository")
public interface ControlEmpaqueCabeceraRepository extends JpaRepository<ControlEmpaqueCabecera, Integer> {

}
