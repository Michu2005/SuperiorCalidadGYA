package com.gruposuperior.calidad.manofactura.repositories;

import com.gruposuperior.calidad.manofactura.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("turnoRepository")
public interface TurnoRepository extends JpaRepository<Turno, Integer> {

}
