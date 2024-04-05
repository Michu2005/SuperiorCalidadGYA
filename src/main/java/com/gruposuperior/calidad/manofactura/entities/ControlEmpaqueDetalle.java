package com.gruposuperior.calidad.manofactura.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the "control_empaque_detalle" database table.
 * 
 */
@Entity
@Table(name="control_empaque_detalle")
public class ControlEmpaqueDetalle implements Serializable {
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

	@Column(name="numero_registro")
	private short numeroRegistro;

    @Column(name = "dato_peso_primario")
    private Double datoPesoPrimario;

    @Column(name = "dato_peso_secundario")
    private Double datoPesoSecundario;

    @Column(name = "dato_peso_corrugado")
    private Double datoPesoCorrugado;

    @Column(name = "dato_peso_galleta_rota")
    private Double datoPesoGalletaRota;

    @Column(name = "dato_peso_galleta_rota_calculado")
    private Double datoPesoGalletaRotaCalcualado;

    @Column(name = "dato_peso_primario_galleta_rota")
    private Double datoPesoPrimarioGalletaRota;

    @Column(name = "dato_peso_primario_hermeticidad")
    private Double datoPesoPrimarioHermeticidad;

    @Column(name = "dato_peso_primario_parametro_adic")
    private Double datoPesoPrimarioParametroAdic;


	//bi-directional many-to-one association to ControlEmpaqueCabecera
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_control_empaque_cabecera")
	private ControlEmpaqueCabecera controlEmpaqueCabecera;

	//bi-directional many-to-one association to Parametro
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_parametro")
	private Parametro parametro;

	public ControlEmpaqueDetalle() {
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

	public short getNumeroRegistro() {
		return this.numeroRegistro;
	}

	public void setNumeroRegistro(short numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}


	public ControlEmpaqueCabecera getControlEmpaqueCabecera() {
		return this.controlEmpaqueCabecera;
	}

	public void setControlEmpaqueCabecera(ControlEmpaqueCabecera controlEmpaqueCabecera) {
		this.controlEmpaqueCabecera = controlEmpaqueCabecera;
	}

	public Parametro getParametro() {
		return this.parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

    public Double getDatoPesoPrimario() {
        return datoPesoPrimario;
    }

    public void setDatoPesoPrimario(Double datoPesoPrimario) {
        this.datoPesoPrimario = datoPesoPrimario;
    }

    public Double getDatoPesoSecundario() {
        return datoPesoSecundario;
    }

    public void setDatoPesoSecundario(Double datoPesoSecundario) {
        this.datoPesoSecundario = datoPesoSecundario;
    }

    public Double getDatoPesoCorrugado() {
        return datoPesoCorrugado;
    }

    public void setDatoPesoCorrugado(Double datoPesoCorrugado) {
        this.datoPesoCorrugado = datoPesoCorrugado;
    }

    public Double getDatoPesoGalletaRota() {
        return datoPesoGalletaRota;
    }

    public void setDatoPesoGalletaRota(Double datoPesoGalletaRota) {
        this.datoPesoGalletaRota = datoPesoGalletaRota;
    }

    public Double getDatoPesoGalletaRotaCalcualado() {
        return datoPesoGalletaRotaCalcualado;
    }

    public void setDatoPesoGalletaRotaCalcualado(Double datoPesoGalletaRotaCalcualado) {
        this.datoPesoGalletaRotaCalcualado = datoPesoGalletaRotaCalcualado;
    }

    public Double getDatoPesoPrimarioGalletaRota() {
        return datoPesoPrimarioGalletaRota;
    }

    public void setDatoPesoPrimarioGalletaRota(Double datoPesoPrimarioGalletaRota) {
        this.datoPesoPrimarioGalletaRota = datoPesoPrimarioGalletaRota;
    }

    public Double getDatoPesoPrimarioHermeticidad() {
        return datoPesoPrimarioHermeticidad;
    }

    public void setDatoPesoPrimarioHermeticidad(Double datoPesoPrimarioHermeticidad) {
        this.datoPesoPrimarioHermeticidad = datoPesoPrimarioHermeticidad;
    }

    public Double getDatoPesoPrimarioParametroAdic() {
        return datoPesoPrimarioParametroAdic;
    }

    public void setDatoPesoPrimarioParametroAdic(Double datoPesoPrimarioParametroAdic) {
        this.datoPesoPrimarioParametroAdic = datoPesoPrimarioParametroAdic;
    }

}