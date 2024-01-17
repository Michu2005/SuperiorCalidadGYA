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
 * The persistent class for the "perfil" database table.
 * 
 */
@Entity
@Table(name="perfil")
public class Perfil implements Serializable {
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

	//bi-directional many-to-one association to PerfilEmpleado
	@OneToMany(mappedBy="perfil")
	private List<PerfilEmpleado> perfilEmpleados;

	public Perfil() {
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

	public List<PerfilEmpleado> getPerfilEmpleados() {
		return this.perfilEmpleados;
	}

	public void setPerfilEmpleados(List<PerfilEmpleado> perfilEmpleados) {
		this.perfilEmpleados = perfilEmpleados;
	}

	public PerfilEmpleado addPerfilEmpleado(PerfilEmpleado perfilEmpleado) {
		getPerfilEmpleados().add(perfilEmpleado);
		perfilEmpleado.setPerfil(this);

		return perfilEmpleado;
	}

	public PerfilEmpleado removePerfilEmpleado(PerfilEmpleado perfilEmpleado) {
		getPerfilEmpleados().remove(perfilEmpleado);
		perfilEmpleado.setPerfil(null);

		return perfilEmpleado;
	}

}