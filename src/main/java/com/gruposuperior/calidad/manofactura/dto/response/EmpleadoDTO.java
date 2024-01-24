package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class EmpleadoDTO {
	
	private int id;
	@NotBlank
	private String codigo;
    @NotBlank
    private String nombre;
	
	public EmpleadoDTO() {
		super();
	}

	public EmpleadoDTO(int id, String codigo, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo;
        this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
