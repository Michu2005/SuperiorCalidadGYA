package com.gruposuperior.calidad.manofactura.dto.response;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public class ParametroDTO {
	
	private int id;
    @NotBlank
    private String descripcion;
    private BigDecimal max;
    private BigDecimal min;
    private String unidadMedia;
    private boolean valorUnico;
	
	public ParametroDTO() {
		super();
	}

	public ParametroDTO(int id, @NotBlank String descripcion, BigDecimal max, BigDecimal min, String unidadMedia,
			boolean valorUnico) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.max = max;
		this.min = min;
		this.unidadMedia = unidadMedia;
		this.valorUnico = valorUnico;
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

	public String getUnidadMedia() {
		return unidadMedia;
	}

	public void setUnidadMedia(String unidadMedia) {
		this.unidadMedia = unidadMedia;
	}

	public boolean isValorUnico() {
		return valorUnico;
	}

	public void setValorUnico(boolean valorUnico) {
		this.valorUnico = valorUnico;
	}

}
