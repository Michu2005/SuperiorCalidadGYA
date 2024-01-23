package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.PerfilEmpleado;

@Repository("perfilEmpleadoRepository")
public interface PerfilEmpleadoRepository extends JpaRepository<PerfilEmpleado, Integer> {

}