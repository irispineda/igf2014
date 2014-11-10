package org.sv.ues.igf.entidades;

// Generated 10-25-2014 10:33:59 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Establecimiento generated by hbm2java
 */
@Entity
@Table(name = "establecimiento", catalog = "clave1", schema = "")
@NamedQueries({
	@NamedQuery(name = "Establecimiento.findAll", query = "SELECT p FROM Establecimiento p"),
	@NamedQuery(name = "Establecimiento.findByNumReferencia", query = "SELECT p FROM Establecimiento p WHERE p.numReferencia = :numReferencia"),
	@NamedQuery(name = "Establecimiento.findByEstablecimiento", query = "SELECT p FROM Establecimiento p WHERE p.establecimiento = :establecimiento") })
public class Establecimiento implements java.io.Serializable {

	private Short numReferencia;
	private String establecimiento;
	private String domicilio;
	private Date fechIngreso;
	private String activo;

	public Establecimiento() {
	}

	public Establecimiento(String establecimiento, String domicilio,
			Date fechIngreso, String activo) {
		this.establecimiento = establecimiento;
		this.domicilio = domicilio;
		this.fechIngreso = fechIngreso;
		this.activo = activo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "num_referencia", unique = true, nullable = false)
	public Short getNumReferencia() {
		return this.numReferencia;
	}

	public void setNumReferencia(Short numReferencia) {
		this.numReferencia = numReferencia;
	}

	@Column(name = "establecimiento", length = 35)
	public String getEstablecimiento() {
		return this.establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	@Column(name = "domicilio", length = 45)
	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fech_ingreso", length = 10)
	public Date getFechIngreso() {
		return this.fechIngreso;
	}

	public void setFechIngreso(Date fechIngreso) {
		this.fechIngreso = fechIngreso;
	}

	@Column(name = "activo", length = 1)
	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

}
