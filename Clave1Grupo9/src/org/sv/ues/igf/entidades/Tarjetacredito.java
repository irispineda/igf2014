package org.sv.ues.igf.entidades;

// Generated 10-25-2014 10:33:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tarjetacredito generated by hbm2java
 */
@Entity
@Table(name = "tarjetacredito", catalog = "clave1")
public class Tarjetacredito implements java.io.Serializable {

	private Integer idtarjetacredito;
	private String nombreTarjeta;
	private BigDecimal limiteCreditoMin;
	private BigDecimal limiteCreditoMax;
	private String nombreEmisor;
	private Date fechaIngreso;
	private BigDecimal tasaInteres;
	private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);
	private Set<Clientetarjeta> clientetarjetas = new HashSet<Clientetarjeta>(0);
	private Set<Clientetarjetaestado> clientetarjetaestados = new HashSet<Clientetarjetaestado>(
			0);

	public Tarjetacredito() {
	}

	public Tarjetacredito(String nombreTarjeta, BigDecimal limiteCreditoMin,
			BigDecimal limiteCreditoMax, String nombreEmisor,
			Date fechaIngreso, BigDecimal tasaInteres,
			Set<Transaccion> transaccions, Set<Clientetarjeta> clientetarjetas,
			Set<Clientetarjetaestado> clientetarjetaestados) {
		this.nombreTarjeta = nombreTarjeta;
		this.limiteCreditoMin = limiteCreditoMin;
		this.limiteCreditoMax = limiteCreditoMax;
		this.nombreEmisor = nombreEmisor;
		this.fechaIngreso = fechaIngreso;
		this.tasaInteres = tasaInteres;
		this.transaccions = transaccions;
		this.clientetarjetas = clientetarjetas;
		this.clientetarjetaestados = clientetarjetaestados;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idtarjetacredito", unique = true, nullable = false)
	public Integer getIdtarjetacredito() {
		return this.idtarjetacredito;
	}

	public void setIdtarjetacredito(Integer idtarjetacredito) {
		this.idtarjetacredito = idtarjetacredito;
	}

	@Column(name = "nombre_tarjeta", length = 45)
	public String getNombreTarjeta() {
		return this.nombreTarjeta;
	}

	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}

	@Column(name = "limite_credito_min", precision = 11)
	public BigDecimal getLimiteCreditoMin() {
		return this.limiteCreditoMin;
	}

	public void setLimiteCreditoMin(BigDecimal limiteCreditoMin) {
		this.limiteCreditoMin = limiteCreditoMin;
	}

	@Column(name = "limite_credito_max", precision = 11)
	public BigDecimal getLimiteCreditoMax() {
		return this.limiteCreditoMax;
	}

	public void setLimiteCreditoMax(BigDecimal limiteCreditoMax) {
		this.limiteCreditoMax = limiteCreditoMax;
	}

	@Column(name = "nombre_emisor", length = 45)
	public String getNombreEmisor() {
		return this.nombreEmisor;
	}

	public void setNombreEmisor(String nombreEmisor) {
		this.nombreEmisor = nombreEmisor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_ingreso", length = 10)
	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Column(name = "tasa_interes", precision = 7)
	public BigDecimal getTasaInteres() {
		return this.tasaInteres;
	}

	public void setTasaInteres(BigDecimal tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarjetacredito")
	public Set<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(Set<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarjetacredito")
	public Set<Clientetarjeta> getClientetarjetas() {
		return this.clientetarjetas;
	}

	public void setClientetarjetas(Set<Clientetarjeta> clientetarjetas) {
		this.clientetarjetas = clientetarjetas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarjetacredito")
	public Set<Clientetarjetaestado> getClientetarjetaestados() {
		return this.clientetarjetaestados;
	}

	public void setClientetarjetaestados(
			Set<Clientetarjetaestado> clientetarjetaestados) {
		this.clientetarjetaestados = clientetarjetaestados;
	}

}