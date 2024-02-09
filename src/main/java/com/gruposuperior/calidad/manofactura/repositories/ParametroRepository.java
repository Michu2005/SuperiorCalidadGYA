package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.Parametro;

@Repository("parametroRepository")
public interface ParametroRepository extends JpaRepository<Parametro, Integer> {
}
