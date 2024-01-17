package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.Linea;

@Repository("lineaRepository")
public interface LineaRepository extends JpaRepository<Linea, Integer> {

}
