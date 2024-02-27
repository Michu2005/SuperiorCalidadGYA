package com.gruposuperior.calidad.manofactura.repositories;

import com.gruposuperior.calidad.manofactura.entities.ProductoParametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.Parametro;

import java.util.List;

@Repository("parametroRepository")
public interface ParametroRepository extends JpaRepository<Parametro, Integer> {
}
