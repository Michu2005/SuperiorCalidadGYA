package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.Producto;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
   
}
