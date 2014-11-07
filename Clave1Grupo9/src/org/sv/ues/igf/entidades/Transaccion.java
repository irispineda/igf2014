package org.sv.ues.igf.entidades;

// Generated 10-25-2014 10:33:59 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * Transaccion generated by hbm2java
 */
@Entity
@Table(name = "transaccion", catalog = "clave1")
@NamedQueries({
	@NamedQuery(name = "Transaccion.findByAll", query = "SELECT t FROM Transaccion t "),
	@NamedQuery(name = "Transaccion.findByIdTransaccion", query = "SELECT t FROM Transaccion t WHERE idtransaccion = :id")
})
public class Transaccion implements java.io.Serializable {

	private Integer idtransaccion;
	private Pais pais;
	private Clientetarjetaestado clientetarjetaestado;
	private Concepto concepto;
	private Tarjetacredito tarjetacredito;
	private Cliente cliente;
	private Date fechaTransaccion;
	private Date fechaAplicada;
	private BigDecimal montoTransaccion;
	private String BCargo;
	private String BAbono;
	
	public Transaccion() {
		this.idtransaccion = 0;
		this.fechaAplicada = new Date();
		this.fechaTransaccion = new Date();
		this.montoTransaccion = new BigDecimal(0);
	}

	public Transaccion(Pais pais, Clientetarjetaestado clientetarjetaestado,
			Concepto concepto, Tarjetacredito tarjetacredito, Cliente cliente,
			Date fechaTransaccion, Date fechaAplicada,
			BigDecimal montoTransaccion, String BCargo, String BAbono) {
		this.pais = pais;
		this.clientetarjetaestado = clientetarjetaestado;
		this.concepto = concepto;
		this.tarjetacredito = tarjetacredito;
		this.cliente = cliente;
		this.fechaTransaccion = fechaTransaccion;
		this.fechaAplicada = fechaAplicada;
		this.montoTransaccion = montoTransaccion;
		this.BCargo = BCargo;
		this.BAbono = BAbono;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idtransaccion", unique = true, nullable = false)
	public Integer getIdtransaccion() {
		return this.idtransaccion;
	}

	public void setIdtransaccion(Integer idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpais")
	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "idtarjetacredito", referencedColumnName = "idtarjetacredito"),
			@JoinColumn(name = "idcliente", referencedColumnName = "idcliente"),
			@JoinColumn(name = "fecha_limite_pago", referencedColumnName = "fecha_limite_pago") })
	public Clientetarjetaestado getClientetarjetaestado() {
		return this.clientetarjetaestado;
	}

	public void setClientetarjetaestado(
			Clientetarjetaestado clientetarjetaestado) {
		this.clientetarjetaestado = clientetarjetaestado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idconcepto")
	public Concepto getConcepto() {
		return this.concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtarjetacredito", insertable = false, updatable = false)
	public Tarjetacredito getTarjetacredito() {
		return this.tarjetacredito;
	}

	public void setTarjetacredito(Tarjetacredito tarjetacredito) {
		this.tarjetacredito = tarjetacredito;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente", insertable = false, updatable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_transaccion", length = 10)
	public Date getFechaTransaccion() {
		return this.fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_aplicada", length = 10)
	public Date getFechaAplicada() {
		return this.fechaAplicada;
	}

	public void setFechaAplicada(Date fechaAplicada) {
		this.fechaAplicada = fechaAplicada;
	}

	@Column(name = "monto_transaccion", precision = 12)
	public BigDecimal getMontoTransaccion() {
		return this.montoTransaccion;
	}

	public void setMontoTransaccion(BigDecimal montoTransaccion) {
		this.montoTransaccion = montoTransaccion;
	}

	@Column(name = "b_cargo", length = 1)
	public String getBCargo() {
		return this.BCargo;
	}

	public void setBCargo(String BCargo) {
		this.BCargo = BCargo;
	}

	@Column(name = "b_abono", length = 1)
	public String getBAbono() {
		return this.BAbono;
	}

	public void setBAbono(String BAbono) {
		this.BAbono = BAbono;
	}

}
