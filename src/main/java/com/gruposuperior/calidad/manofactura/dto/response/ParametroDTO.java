package com.gruposuperior.calidad.manofactura.dto.response;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public class ParametroDTO {

    @NotBlank
	private Integer id;
    private String descripcion;
    private BigDecimal max;
    private BigDecimal min;
	private String unidadMedida;
	
	public ParametroDTO() {
		super();
	}

	public ParametroDTO(@NotBlank String descripcion, BigDecimal max, BigDecimal min, String unidadMedida) {
		super();
		this.descripcion = descripcion;
		this.max = max;
		this.min = min;
		this.unidadMedida = unidadMedida;
	}

	public Integer getId(){return id;}

	public void setId(Integer id){this.id = id;}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getMax() {
		return max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public BigDecimal getMin() {
		return min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
}
