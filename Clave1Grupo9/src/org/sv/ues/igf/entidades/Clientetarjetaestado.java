package org.sv.ues.igf.entidades;

// Generated 10-25-2014 10:33:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clientetarjetaestado generated by hbm2java
 */
@Entity
@Table(name = "clientetarjetaestado", catalog = "clave1")
public class Clientetarjetaestado implements java.io.Serializable {

	private ClientetarjetaestadoId id;
	private Tarjeta tarjetacredito;
	private Cliente cliente;
	private BigDecimal balanceActual;
	private Short numReferencia;
	private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);

	public Clientetarjetaestado() {
	}

	public Clientetarjetaestado(ClientetarjetaestadoId id,
			Tarjeta tarjetacredito, Cliente cliente) {
		this.id = id;
		this.tarjetacredito = tarjetacredito;
		this.cliente = cliente;
	}

	public Clientetarjetaestado(ClientetarjetaestadoId id,
			Tarjeta tarjetacredito, Cliente cliente,
			BigDecimal balanceActual, Short numReferencia,
			Set<Transaccion> transaccions) {
		this.id = id;
		this.tarjetacredito = tarjetacredito;
		this.cliente = cliente;
		this.balanceActual = balanceActual;
		this.numReferencia = numReferencia;
		this.transaccions = transaccions;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idtarjetacredito", column = @Column(name = "idtarjetacredito", nullable = false)),
			@AttributeOverride(name = "idcliente", column = @Column(name = "idcliente", nullable = false)),
			@AttributeOverride(name = "fechaLimitePago", column = @Column(name = "fecha_limite_pago", nullable = false, length = 10)) })
	public ClientetarjetaestadoId getId() {
		return this.id;
	}

	public void setId(ClientetarjetaestadoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idtarjetacredito", nullable = false, insertable = false, updatable = false)
	public Tarjeta getTarjetacredito() {
		return this.tarjetacredito;
	}

	public void setTarjetacredito(Tarjeta tarjetacredito) {
		this.tarjetacredito = tarjetacredito;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcliente", nullable = false, insertable = false, updatable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Column(name = "balance_actual", precision = 11)
	public BigDecimal getBalanceActual() {
		return this.balanceActual;
	}

	public void setBalanceActual(BigDecimal balanceActual) {
		this.balanceActual = balanceActual;
	}

	@Column(name = "num_referencia")
	public Short getNumReferencia() {
		return this.numReferencia;
	}

	public void setNumReferencia(Short numReferencia) {
		this.numReferencia = numReferencia;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clientetarjetaestado")
	public Set<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(Set<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

}
