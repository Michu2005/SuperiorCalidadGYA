package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.PerfilEmpleado;

import java.util.List;

@Repository("perfilEmpleadoRepository")
public interface PerfilEmpleadoRepository extends JpaRepository<PerfilEmpleado, Integer> {
    List<PerfilEmpleado> findByIdPerfil(Integer idPerfil);
}
