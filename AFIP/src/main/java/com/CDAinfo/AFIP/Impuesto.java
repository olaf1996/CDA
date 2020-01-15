package com.CDAinfo.AFIP;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="impuestos")
public class Impuesto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idImpuesto;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="fechaLiquidacion")
	private Date fechaLiquidacion;


	@Column(name="porcentaje")
	private Double porcentaje;
	
	@Column(name="claveFiscal")
	private Long claveFiscal;
	
	public Impuesto(){
		
	}

	public Impuesto(Long idImpuesto, String tipo, Date fechaLiquidacion, Double porcentaje, Long claveFiscal) {
		super();
		this.idImpuesto = idImpuesto;
		this.tipo = tipo;
		this.fechaLiquidacion = fechaLiquidacion;
		this.porcentaje = porcentaje;
		this.claveFiscal = claveFiscal;
	}

	public Long getIdImpuesto() {
		return idImpuesto;
	}

	public void setIdImpuesto(Long idImpuesto) {
		this.idImpuesto = idImpuesto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}

	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}

	

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public Long getClaveFiscal() {
		return claveFiscal;
	}

	public void setClaveFiscal(Long claveFiscal) {
		this.claveFiscal = claveFiscal;
	}
	
	
	@Override
    public String toString() {
		return "Usuario: \n" +
				 "   id: " + this.idImpuesto +
	                "\n   tipo: " + this.tipo +
	                "\n   fecha: " + this.fechaLiquidacion +
	                 "\n porcentaje: " + this.porcentaje +
	                 "\n clave:" + this.claveFiscal;
	}
}