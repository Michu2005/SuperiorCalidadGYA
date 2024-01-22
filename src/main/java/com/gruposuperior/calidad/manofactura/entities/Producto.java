package com.gruposuperior.calidad.manofactura.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the "producto" database table.
 * 
 */
@Entity
@Table(name="producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="codigo")
	private String codigo;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="activo")
	private boolean activo;

	@Temporal(TemporalType.DATE)
	@Column(name="borrado")
	private Date borrado;

	@Temporal(TemporalType.DATE)
	@Column(name="creado")
	private Date creado;

	//bi-directional many-to-one association to ControlEmpaqueCabecera
	@OneToMany(mappedBy="producto")
	private List<ControlEmpaqueCabecera> controlEmpaqueCabeceras;

	//bi-directional many-to-one association to ControlProductoCabecera
	@OneToMany(mappedBy="producto")
	private List<ControlProductoCabecera> controlProductoCabeceras;

	//bi-directional many-to-one association to ProductoParametro
	@OneToMany(mappedBy="producto")
	private List<ProductoParametro> productoParametros;

	public Producto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ControlEmpaqueCabecera> getControlEmpaqueCabeceras() {
		return this.controlEmpaqueCabeceras;
	}

	public void setControlEmpaqueCabeceras(List<ControlEmpaqueCabecera> controlEmpaqueCabeceras) {
		this.controlEmpaqueCabeceras = controlEmpaqueCabeceras;
	}

	public ControlEmpaqueCabecera addControlEmpaqueCabecera(ControlEmpaqueCabecera controlEmpaqueCabecera) {
		getControlEmpaqueCabeceras().add(controlEmpaqueCabecera);
		controlEmpaqueCabecera.setProducto(this);

		return controlEmpaqueCabecera;
	}

	public ControlEmpaqueCabecera removeControlEmpaqueCabecera(ControlEmpaqueCabecera controlEmpaqueCabecera) {
		getControlEmpaqueCabeceras().remove(controlEmpaqueCabecera);
		controlEmpaqueCabecera.setProducto(null);

		return controlEmpaqueCabecera;
	}

	public List<ControlProductoCabecera> getControlProductoCabeceras() {
		return this.controlProductoCabeceras;
	}

	public void setControlProductoCabeceras(List<ControlProductoCabecera> controlProductoCabeceras) {
		this.controlProductoCabeceras = controlProductoCabeceras;
	}

	public ControlProductoCabecera addControlProductoCabecera(ControlProductoCabecera controlProductoCabecera) {
		getControlProductoCabeceras().add(controlProductoCabecera);
		controlProductoCabecera.setProducto(this);

		return controlProductoCabecera;
	}

	public ControlProductoCabecera removeControlProductoCabecera(ControlProductoCabecera controlProductoCabecera) {
		getControlProductoCabeceras().remove(controlProductoCabecera);
		controlProductoCabecera.setProducto(null);

		return controlProductoCabecera;
	}

	public List<ProductoParametro> getProductoParametros() {
		return this.productoParametros;
	}

	public void setProductoParametros(List<ProductoParametro> productoParametros) {
		this.productoParametros = productoParametros;
	}

	public ProductoParametro addProductoParametro(ProductoParametro productoParametro) {
		getProductoParametros().add(productoParametro);
		productoParametro.setProducto(this);

		return productoParametro;
	}

	public ProductoParametro removeProductoParametro(ProductoParametro productoParametro) {
		getProductoParametros().remove(productoParametro);
		productoParametro.setProducto(null);

		return productoParametro;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Date getBorrado() {
		return borrado;
	}

	public void setBorrado(Date borrado) {
		this.borrado = borrado;
	}

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

}