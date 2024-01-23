package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class ProcesoDTO {
	
	private int id;
    @NotBlank
    private String descripcion;
	
	public ProcesoDTO() {
		super();
	}

	public ProcesoDTO(int id, String descripcion) {
		super();
		this.id = id;
        this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
