package com.gruposuperior.calidad.manofactura.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the "control_producto_cabecera" database table.
 * 
 */
@Entity
@Table(name="control_producto_cabecera")
public class ControlProductoCabecera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="activo")
	private boolean activo;

	@Temporal(TemporalType.DATE)
	@Column(name="borrado")
	private Date borrado;

	@Temporal(TemporalType.DATE)
	@Column(name="creado")
	private Date creado;

	@Column(name="id_supervisor")
	private int idSupervisor;

	@Column(name="id_analista")
	private Double idAnalista;

	@Column(name="id_linea")
	private Double idLinea;

	@Column(name="id_producto")
	private Double idProducto;

	@Column(name="id_turno")
	private Double idTurno;

	public ControlProductoCabecera() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Date getBorrado() {
		return this.borrado;
	}

	public void setBorrado(Date borrado) {
		this.borrado = borrado;
	}

	public Date getCreado() {
		return this.creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public int getIdSupervisor() {
		return this.idSupervisor;
	}

	public void setIdSupervisor(int idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public Double getIdAnalista() {
		return idAnalista;
	}

	public void setIdAnalista(Double idAnalista) {
		this.idAnalista = idAnalista;
	}

	public Double getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Double idLinea) {
		this.idLinea = idLinea;
	}

	public Double getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Double idProducto) {
		this.idProducto = idProducto;
	}

	public Double getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Double idTurno) {
		this.idTurno = idTurno;
	}

}