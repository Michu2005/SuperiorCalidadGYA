package com.gruposuperior.calidad.manofactura.repositories;

import com.gruposuperior.calidad.manofactura.dto.response.EmpleadoDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.Empleado;

import java.util.List;

@Repository("empleadoRepository")
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
