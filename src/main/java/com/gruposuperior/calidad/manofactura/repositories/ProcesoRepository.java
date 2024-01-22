package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.Proceso;

@Repository("procesoRepository")
public interface ProcesoRepository extends JpaRepository<Proceso, Integer> {

}
