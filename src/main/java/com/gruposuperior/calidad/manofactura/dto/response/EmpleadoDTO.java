package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class EmpleadoDTO {

	@NotBlank
	private String codigo;
    @NotBlank
    private String nombre;
	
	public EmpleadoDTO() {
		super();
	}

	public EmpleadoDTO(String codigo, String nombre) {
		super();
		this.codigo = codigo;
        this.nombre = nombre;
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
