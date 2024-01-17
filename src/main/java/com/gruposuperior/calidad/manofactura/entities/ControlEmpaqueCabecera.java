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

	//bi-directional many-to-one association to Linea
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_linea")
	private Linea linea;

	//bi-directional many-to-one association to Maquina
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_maquina")
	private Maquina maquina;

	//bi-directional many-to-one association to PerfilEmpleado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_perfil_empleado")
	private PerfilEmpleado perfilEmpleado;

	//bi-directional many-to-one association to Producto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private Producto producto;

	//bi-directional many-to-one association to Turno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_turno")
	private Turno turno;

	//bi-directional many-to-one association to ControlEmpaqueDetalle
	@OneToMany(mappedBy="controlEmpaqueCabecera")
	private List<ControlEmpaqueDetalle> controlEmpaqueDetalles;

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

	public Linea getLinea() {
		return this.linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Maquina getMaquina() {
		return this.maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public PerfilEmpleado getPerfilEmpleado() {
		return this.perfilEmpleado;
	}

	public void setPerfilEmpleado(PerfilEmpleado perfilEmpleado) {
		this.perfilEmpleado = perfilEmpleado;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<ControlEmpaqueDetalle> getControlEmpaqueDetalles() {
		return this.controlEmpaqueDetalles;
	}

	public void setControlEmpaqueDetalles(List<ControlEmpaqueDetalle> controlEmpaqueDetalles) {
		this.controlEmpaqueDetalles = controlEmpaqueDetalles;
	}

	public ControlEmpaqueDetalle addControlEmpaqueDetalle(ControlEmpaqueDetalle controlEmpaqueDetalle) {
		getControlEmpaqueDetalles().add(controlEmpaqueDetalle);
		controlEmpaqueDetalle.setControlEmpaqueCabecera(this);

		return controlEmpaqueDetalle;
	}

	public ControlEmpaqueDetalle removeControlEmpaqueDetalle(ControlEmpaqueDetalle controlEmpaqueDetalle) {
		getControlEmpaqueDetalles().remove(controlEmpaqueDetalle);
		controlEmpaqueDetalle.setControlEmpaqueCabecera(null);

		return controlEmpaqueDetalle;
	}

}