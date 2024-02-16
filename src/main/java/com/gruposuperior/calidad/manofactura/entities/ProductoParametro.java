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
 * The persistent class for the "producto_parametro" database table.
 * 
 */
@Entity
@Table(name="producto_parametro")
public class ProductoParametro implements Serializable {
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

	//bi-directional many-to-one association to ControlProductoDetalle
	@OneToMany(mappedBy="productoParametro")
	private List<ControlProductoDetalle> controlProductoDetalles;

	//bi-directional many-to-one association to Parametro
	@ManyToOne
	@JoinColumn(name = "id_parametro", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private Parametro parametro;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name = "id_producto", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private Producto producto;

	public ProductoParametro() {
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

	public List<ControlProductoDetalle> getControlProductoDetalles() {
		return this.controlProductoDetalles;
	}

	public void setControlProductoDetalles(List<ControlProductoDetalle> controlProductoDetalles) {
		this.controlProductoDetalles = controlProductoDetalles;
	}

	public ControlProductoDetalle addControlProductoDetalle(ControlProductoDetalle controlProductoDetalle) {
		getControlProductoDetalles().add(controlProductoDetalle);
		controlProductoDetalle.setProductoParametro(this);

		return controlProductoDetalle;
	}

	public ControlProductoDetalle removeControlProductoDetalle(ControlProductoDetalle controlProductoDetalle) {
		getControlProductoDetalles().remove(controlProductoDetalle);
		controlProductoDetalle.setProductoParametro(null);

		return controlProductoDetalle;
	}

	public Parametro getParametro() {
		return this.parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}