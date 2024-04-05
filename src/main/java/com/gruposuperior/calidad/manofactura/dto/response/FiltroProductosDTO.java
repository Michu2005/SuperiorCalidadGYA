package com.gruposuperior.calidad.manofactura.dto.response;

import java.util.Date;

public class FiltroProductosDTO {
    
	private int idAnalista;
    private int idProducto; 
    private int idMaquina;
    private int tipo;
    private int idSupervisor;
    private Date fechaDesde;
    private Date fechaHasta;

	public FiltroProductosDTO() {
		super();
	}
	public FiltroProductosDTO(int idAnalista, int idProducto, int idMaquina, int tipo, int idSupervisor) {
		super();
		this.idAnalista = idAnalista;
        this.idProducto = idProducto;
        this.idMaquina = idMaquina;
        this.tipo = tipo;
        this.idSupervisor = idSupervisor;
	}    
    public int getIdAnalista() {
        return idAnalista;
    }
    public void setIdAnalista(int idAnalista) {
        this.idAnalista = idAnalista;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public int getIdMaquina() {
        return idMaquina;
    }
    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    } 
 
    public Date getFechaDesde() {
        return fechaDesde;
    }
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    public Date getFechaHasta() {
        return fechaHasta;
    }
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    public int getIdSupervisor() {
        return idSupervisor;
    }
    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }    
    
}
