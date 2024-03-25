package com.gruposuperior.calidad.manofactura.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the "control_empaque_detalle" database table.
 * 
 */
@Entity
@Table(name="control_empaque_detalle")
public class ControlEmpaqueDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="id_control_empaque_cabecera")
	private int idControlEmpaqueCabecera;

	@Column(name="activo")
	private boolean activo;

	@Temporal(TemporalType.DATE)
	@Column(name="borrado")
	private Date borrado;

	@Temporal(TemporalType.DATE)
	@Column(name="creado")
	private Date creado;

	@Column(name="numero_registro")
	private int numeroRegistro;

	@Column(name="dato_peso_primario")
	private double datoPesoPrimario;

	@Column(name="dato_peso_secundario")
	private double datoPesoSecundario;

	@Column(name="dato_peso_corrugado")
	private double datoPesoCorrugado;

	@Column(name="id_parametro")
	private int idParametro;

	public ControlEmpaqueDetalle() {
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

	public int getNumeroRegistro() {
		return this.numeroRegistro;
	}

	public void setNumeroRegistro(int numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public double getDatoPesoPrimario() {
		return datoPesoPrimario;
	}

	public void setDatoPesoPrimario(double datoPesoPrimario) {
		this.datoPesoPrimario = datoPesoPrimario;
	}

	public double getDatoPesoSecundario() {
		return datoPesoSecundario;
	}

	public void setDatoPesoSecundario(double datoPesoSecundario) {
		this.datoPesoSecundario = datoPesoSecundario;
	}

	public double getDatoPesoCorrugado() {
		return datoPesoCorrugado;
	}

	public void setDatoPesoCorrugado(double datoPesoCorrugado) {
		this.datoPesoCorrugado = datoPesoCorrugado;
	}

	public int getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}

	public int getIdControlEmpaqueCabecera() {
		return idControlEmpaqueCabecera;
	}

	public void setIdControlEmpaqueCabecera(int idControlEmpaqueCabecera) {
		this.idControlEmpaqueCabecera = idControlEmpaqueCabecera;
	}
}