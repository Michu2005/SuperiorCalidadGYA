package com.gruposuperior.calidad.manofactura.dto.response;

import com.gruposuperior.calidad.manofactura.entities.Parametro;

import java.util.List;

public class ProductoParametroDTO {

    private int id;
    private int idProducto;
    private int idParametro;

    public ProductoParametroDTO() {
        super();
    }

    public ProductoParametroDTO(int id, int idProducto, int idParametro) {
        super();
        this.id = id;
        this.idProducto = idProducto;
        this.idParametro = idParametro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }
}

