package com.gruposuperior.calidad.manofactura.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.gruposuperior.calidad.manofactura.repositories.ParametroRepository;
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
import org.springframework.beans.factory.annotation.Autowired;


/**
 * The persistent class for the "parametro" database table.
 * 
 */
@Entity
@Table(name="parametro")
public class Parametro implements Serializable {
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

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="max")
	private BigDecimal max;

	@Column(name="min")
	private BigDecimal min;

	@Column(name="unidad_medida")
	private String unidadMedida;

	@Column(name="valor_unico")
	private boolean valorUnico;

	//bi-directional many-to-one association to ControlEmpaqueDetalle
	@OneToMany(mappedBy="parametro")
	private List<ControlEmpaqueDetalle> controlEmpaqueDetalles;

	//bi-directional many-to-one association to TipoParametro
	@ManyToOne
	@JoinColumn(name = "id_tipo_parametro", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private TipoParametro tipoParametro;
	
	//bi-directional many-to-one association to TipoParametro
	@ManyToOne
	@JoinColumn(name = "id_proceso", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private Proceso proceso;

	//bi-directional many-to-one association to ProductoParametro
	@OneToMany(mappedBy="parametro")
	private List<ProductoParametro> productoParametros;

	public Parametro() {
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

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getMax() {
		return this.max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public BigDecimal getMin() {
		return this.min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public String getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public boolean getValorUnico() {
		return this.valorUnico;
	}

	public void setValorUnico(boolean valorUnico) {
		this.valorUnico = valorUnico;
	}

	public List<ControlEmpaqueDetalle> getControlEmpaqueDetalles() {
		return this.controlEmpaqueDetalles;
	}

	public void setControlEmpaqueDetalles(List<ControlEmpaqueDetalle> controlEmpaqueDetalles) {
		this.controlEmpaqueDetalles = controlEmpaqueDetalles;
	}

	public ControlEmpaqueDetalle addControlEmpaqueDetalle(ControlEmpaqueDetalle controlEmpaqueDetalle) {
		getControlEmpaqueDetalles().add(controlEmpaqueDetalle);
		controlEmpaqueDetalle.setParametro(this);

		return controlEmpaqueDetalle;
	}

	public ControlEmpaqueDetalle removeControlEmpaqueDetalle(ControlEmpaqueDetalle controlEmpaqueDetalle) {
		getControlEmpaqueDetalles().remove(controlEmpaqueDetalle);
		controlEmpaqueDetalle.setParametro(null);

		return controlEmpaqueDetalle;
	}

	public TipoParametro getTipoParametro() {
		return this.tipoParametro;
	}

	public void setTipoParametro(TipoParametro tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	public List<ProductoParametro> getProductoParametros() {
		return this.productoParametros;
	}

	public void setProductoParametros(List<ProductoParametro> productoParametros) {
		this.productoParametros = productoParametros;
	}

	public ProductoParametro addProductoParametro(ProductoParametro productoParametro) {
		getProductoParametros().add(productoParametro);
		productoParametro.setParametro(this);

		return productoParametro;
	}

	public ProductoParametro removeProductoParametro(ProductoParametro productoParametro) {
		getProductoParametros().remove(productoParametro);
		productoParametro.setParametro(null);

		return productoParametro;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

}