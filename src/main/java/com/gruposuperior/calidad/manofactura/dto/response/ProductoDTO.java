package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class ProductoDTO {
	
	private int id;
	@NotBlank
	private String codigo;
    @NotBlank
    private String descripcion;
	
	public ProductoDTO() {
		super();
	}

	public ProductoDTO(int id, String codigo, String descripcion) {
		super();
		this.id = id;
		this.codigo = codigo;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
