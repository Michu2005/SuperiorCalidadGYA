package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.Maquina;

@Repository("maquinaRepository")
public interface MaquinaRepository extends JpaRepository<Maquina, Integer> {

}
