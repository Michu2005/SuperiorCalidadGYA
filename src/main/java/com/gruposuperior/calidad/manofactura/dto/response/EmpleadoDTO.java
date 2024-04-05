package com.gruposuperior.calidad.manofactura.dto.response;

import jakarta.validation.constraints.NotBlank;

public class EmpleadoDTO {

	@NotBlank
	private String codigo;
    @NotBlank
    private String nombre;
	@NotBlank
	private int IdEmpleado;    
	@NotBlank
	private int idPerfil;
    @NotBlank
	private int tipo;
       
    
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

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

	

}
