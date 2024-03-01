package com.gruposuperior.calidad.manofactura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gruposuperior.calidad.manofactura.entities.Producto;

import java.util.List;
import java.util.Optional;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findById(int id);
}
