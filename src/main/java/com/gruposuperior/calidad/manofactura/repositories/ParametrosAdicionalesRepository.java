package com.gruposuperior.calidad.manofactura.repositories;

import com.gruposuperior.calidad.manofactura.entities.ParametrosAdicionales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("parametrosAdicionalesRepository")
public interface ParametrosAdicionalesRepository extends JpaRepository<ParametrosAdicionales, Integer> {
}
