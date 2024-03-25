package com.gruposuperior.calidad.manofactura.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the "control_empaque_cabecera" database table.
 * 
 */
@Entity
@Table(name="control_empaque_cabecera")
public class ControlEmpaqueCabecera implements Serializable {
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
	private int idAnalista;

	@Column(name="id_linea")
	private int idLinea;

	@Column(name="id_producto")
	private int idProducto;

	@Column(name="id_turno")
	private int idTurno;

	@Column(name="id_maquina")
	private int idMaquina;

	@Column(name="lote")
	private String lote;

	public ControlEmpaqueCabecera() {
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

	public Integer getIdAnalista() {
		return idAnalista;
	}

	public void setIdAnalista(int idAnalista) {
		this.idAnalista = idAnalista;
	}

	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdTurno() {
		return idTurno;
	}

	public Integer getIdMaquina() {
		return idMaquina;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	@Override
	public String toString() {
		return "ControlEmpaqueCabecera{" +
				"id=" + id +
				", activo=" + activo +
				", borrado=" + borrado +
				", creado=" + creado +
				", idSupervisor=" + idSupervisor +
				", idAnalista=" + idAnalista +
				", idLinea=" + idLinea +
				", idProducto=" + idProducto +
				", idTurno=" + idTurno +
				", idMaquina=" + idMaquina +
				", lote='" + lote + '\'' +
				'}';
	}
}