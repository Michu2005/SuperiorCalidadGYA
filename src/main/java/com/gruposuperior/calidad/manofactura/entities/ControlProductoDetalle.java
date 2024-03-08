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
 * The persistent class for the "control_producto_detalle" database table.
 * 
 */
@Entity
@Table(name="control_producto_detalle")
public class ControlProductoDetalle implements Serializable {
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

	@Column(name="numero_registro")
	private short numeroRegistro;

	@Column(name="valor_zona_1")
	private Double valorZona1;

	@Column(name="valor_zona_2")
	private Double valorZona2;

	@Column(name="valor_zona_3")
	private Double valorZona3;

	@Column(name="id_parametro")
	private int idParametro;

	//bi-directional many-to-one association to ControlProductoCabecera
	@ManyToOne
	@JoinColumn(name = "id_control_producto_cabecera", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private ControlProductoCabecera controlProductoCabecera;

	public ControlProductoDetalle() {
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

	public short getNumeroRegistro() {
		return this.numeroRegistro;
	}

	public void setNumeroRegistro(short numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public ControlProductoCabecera getControlProductoCabecera() {
		return this.controlProductoCabecera;
	}

	public Double getValorZona1() {
		return valorZona1;
	}

	public void setValorZona1(Double valorZona1) {
		this.valorZona1 = valorZona1;
	}

	public Double getValorZona2() {
		return valorZona2;
	}

	public void setValorZona2(Double valorZona2) {
		this.valorZona2 = valorZona2;
	}

	public Double getValorZona3() {
		return valorZona3;
	}

	public void setValorZona3(Double valorZona3) {
		this.valorZona3 = valorZona3;
	}

	public int getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}

	public void setControlProductoCabecera(ControlProductoCabecera controlProductoCabecera) {
		this.controlProductoCabecera = controlProductoCabecera;
	}

}