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
 * The persistent class for the "maquina" database table.
 * 
 */
@Entity
@Table(name="maquina")
public class Maquina implements Serializable {
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

	//bi-directional many-to-one association to ControlEmpaqueCabecera
	@OneToMany(mappedBy="maquina")
	private List<ControlEmpaqueCabecera> controlEmpaqueCabeceras;

	//bi-directional many-to-one association to ControlProductoCabecera
	@OneToMany(mappedBy="maquina")
	private List<ControlProductoCabecera> controlProductoCabeceras;

	public Maquina() {
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

	public List<ControlEmpaqueCabecera> getControlEmpaqueCabeceras() {
		return this.controlEmpaqueCabeceras;
	}

	public void setControlEmpaqueCabeceras(List<ControlEmpaqueCabecera> controlEmpaqueCabeceras) {
		this.controlEmpaqueCabeceras = controlEmpaqueCabeceras;
	}

	public ControlEmpaqueCabecera addControlEmpaqueCabecera(ControlEmpaqueCabecera controlEmpaqueCabecera) {
		getControlEmpaqueCabeceras().add(controlEmpaqueCabecera);
		controlEmpaqueCabecera.setMaquina(this);

		return controlEmpaqueCabecera;
	}

	public ControlEmpaqueCabecera removeControlEmpaqueCabecera(ControlEmpaqueCabecera controlEmpaqueCabecera) {
		getControlEmpaqueCabeceras().remove(controlEmpaqueCabecera);
		controlEmpaqueCabecera.setMaquina(null);

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
		controlProductoCabecera.setMaquina(this);

		return controlProductoCabecera;
	}

	public ControlProductoCabecera removeControlProductoCabecera(ControlProductoCabecera controlProductoCabecera) {
		getControlProductoCabeceras().remove(controlProductoCabecera);
		controlProductoCabecera.setMaquina(null);

		return controlProductoCabecera;
	}

}