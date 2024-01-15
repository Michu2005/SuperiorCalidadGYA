package com.gruposuperior.calidad.manofactura.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TURNO")
public class Turno implements Serializable {
    @Serial
    private static final long serialVersionUID = 5059182445795391715L;
    @Id
    @Column(name = "id_turno")
    private int idTurno;
    @Column
    private String descripcion;

    public int getIdTurno() {
        return idTurno;
    }

    public Turno() {
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
