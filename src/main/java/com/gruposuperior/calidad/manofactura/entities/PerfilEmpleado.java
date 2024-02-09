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
 * The persistent class for the "perfil_empleado" database table.
 * 
 */
@Entity
@Table(name="perfil_empleado")
public class PerfilEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="id_perfil")
	private int idPerfil;

	@Column(name="id_empleado")
	private int idEmpleado;

	@Column(name="activo")
	private boolean activo;

	@Temporal(TemporalType.DATE)
	@Column(name="borrado")
	private Date borrado;

	@Temporal(TemporalType.DATE)
	@Column(name="creado")
	private Date creado;

	//bi-directional many-to-one association to ControlEmpaqueCabecera
	@OneToMany(mappedBy="perfilEmpleado")
	private List<ControlEmpaqueCabecera> controlEmpaqueCabeceras;

	//bi-directional many-to-one association to ControlProductoCabecera
	@OneToMany(mappedBy="perfilEmpleado")
	private List<ControlProductoCabecera> controlProductoCabeceras;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name = "id_empleado", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private Empleado empleado;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name = "id_perfil", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private Perfil perfil;

	public PerfilEmpleado() {
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

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public List<ControlEmpaqueCabecera> getControlEmpaqueCabeceras() {
		return this.controlEmpaqueCabeceras;
	}

	public void setControlEmpaqueCabeceras(List<ControlEmpaqueCabecera> controlEmpaqueCabeceras) {
		this.controlEmpaqueCabeceras = controlEmpaqueCabeceras;
	}

	public ControlEmpaqueCabecera addControlEmpaqueCabecera(ControlEmpaqueCabecera controlEmpaqueCabecera) {
		getControlEmpaqueCabeceras().add(controlEmpaqueCabecera);
		controlEmpaqueCabecera.setPerfilEmpleado(this);

		return controlEmpaqueCabecera;
	}

	public ControlEmpaqueCabecera removeControlEmpaqueCabecera(ControlEmpaqueCabecera controlEmpaqueCabecera) {
		getControlEmpaqueCabeceras().remove(controlEmpaqueCabecera);
		controlEmpaqueCabecera.setPerfilEmpleado(null);

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
		controlProductoCabecera.setPerfilEmpleado(this);

		return controlProductoCabecera;
	}

	public ControlProductoCabecera removeControlProductoCabecera(ControlProductoCabecera controlProductoCabecera) {
		getControlProductoCabeceras().remove(controlProductoCabecera);
		controlProductoCabecera.setPerfilEmpleado(null);

		return controlProductoCabecera;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}