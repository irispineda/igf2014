package org.sv.ues.igf.entidades;

// Generated 10-25-2014 10:33:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clientetarjeta generated by hbm2java
 */
@Entity
@Table(name = "clientetarjeta", catalog = "clave1")
public class Clientetarjeta implements java.io.Serializable {

	private ClientetarjetaId id;
	private Tarjetacredito tarjetacredito;
	private Cliente cliente;
	private Date fechaEmision;
	private BigDecimal limiteCredito;
	private Integer puntosTarjeta;

	public Clientetarjeta() {
	}

	public Clientetarjeta(ClientetarjetaId id, Tarjetacredito tarjetacredito,
			Cliente cliente) {
		this.id = id;
		this.tarjetacredito = tarjetacredito;
		this.cliente = cliente;
	}

	public Clientetarjeta(ClientetarjetaId id, Tarjetacredito tarjetacredito,
			Cliente cliente, Date fechaEmision, BigDecimal limiteCredito,
			Integer puntosTarjeta) {
		this.id = id;
		this.tarjetacredito = tarjetacredito;
		this.cliente = cliente;
		this.fechaEmision = fechaEmision;
		this.limiteCredito = limiteCredito;
		this.puntosTarjeta = puntosTarjeta;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idtarjetacredito", column = @Column(name = "idtarjetacredito", nullable = false)),
			@AttributeOverride(name = "idcliente", column = @Column(name = "idcliente", nullable = false)) })
	public ClientetarjetaId getId() {
		return this.id;
	}

	public void setId(ClientetarjetaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtarjetacredito", nullable = false, insertable = false, updatable = false)
	public Tarjetacredito getTarjetacredito() {
		return this.tarjetacredito;
	}

	public void setTarjetacredito(Tarjetacredito tarjetacredito) {
		this.tarjetacredito = tarjetacredito;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente", nullable = false, insertable = false, updatable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_emision", length = 10)
	public Date getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	@Column(name = "limite_credito", precision = 11)
	public BigDecimal getLimiteCredito() {
		return this.limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	@Column(name = "puntos_tarjeta", precision = 6, scale = 0)
	public Integer getPuntosTarjeta() {
		return this.puntosTarjeta;
	}

	public void setPuntosTarjeta(Integer puntosTarjeta) {
		this.puntosTarjeta = puntosTarjeta;
	}

}
