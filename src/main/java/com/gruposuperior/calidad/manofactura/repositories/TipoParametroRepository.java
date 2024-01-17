package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.TipoParametro;

@Repository("tipoParametroRepository")
public interface TipoParametroRepository extends JpaRepository<TipoParametro, Integer> {

}
