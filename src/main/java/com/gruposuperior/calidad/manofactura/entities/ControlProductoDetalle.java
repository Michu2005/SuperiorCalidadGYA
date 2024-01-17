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

	@Column(name="valor")
	private BigDecimal valor;

	//bi-directional many-to-one association to ControlProductoCabecera
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_control_producto_cabecera")
	private ControlProductoCabecera controlProductoCabecera;

	//bi-directional many-to-one association to ProductoParametro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_producto_parametro")
	private ProductoParametro productoParametro;

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

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ControlProductoCabecera getControlProductoCabecera() {
		return this.controlProductoCabecera;
	}

	public void setControlProductoCabecera(ControlProductoCabecera controlProductoCabecera) {
		this.controlProductoCabecera = controlProductoCabecera;
	}

	public ProductoParametro getProductoParametro() {
		return this.productoParametro;
	}

	public void setProductoParametro(ProductoParametro productoParametro) {
		this.productoParametro = productoParametro;
	}

}