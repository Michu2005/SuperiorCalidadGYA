package com.gruposuperior.calidad.manofactura.repositories;

import com.gruposuperior.calidad.manofactura.entities.Parametro;
import com.gruposuperior.calidad.manofactura.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.gruposuperior.calidad.manofactura.entities.ProductoParametro;

import java.util.List;

@Repository("productoParametroRepository")
public interface ProductoParametroRepository extends JpaRepository<ProductoParametro, Integer> {
    List<ProductoParametro> findByProductoId(Integer idProducto);
}