package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.ProductoParametro;

@Repository("productoParametroRepository")
public interface ProductoParametroRepository extends JpaRepository<ProductoParametro, Integer> {

}
