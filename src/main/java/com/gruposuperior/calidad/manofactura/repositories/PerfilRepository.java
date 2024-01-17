package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.Perfil;

@Repository("perfilRepository")
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
