package org.sv.ues.igf.entidades;

// Generated 10-25-2014 10:33:59 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * Concepto generated by hbm2java
 */
@Entity
@Table(name = "concepto", catalog = "clave1")
@NamedQueries({
	@NamedQuery(name = "Concepto.findByAll", query = "SELECT c FROM Concepto c "),
	@NamedQuery(name = "Concepto.findByIdConcepto", query = "SELECT c FROM Concepto c WHERE idconcepto = :id")
})
public class Concepto implements java.io.Serializable {

	private Integer idconcepto;
	private String descripcion;
	private String user;
	private Date datareg;
	//private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);

	public Concepto() {
		this.idconcepto = 0;
		this.descripcion = "";
	}

	/*public Concepto(String descripcion, Set<Transaccion> transaccions) {
		this.descripcion = descripcion;
		this.transaccions = transaccions;
	}*/

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idconcepto", unique = true, nullable = false)
	public Integer getIdconcepto() {
		return this.idconcepto;
	}

	public void setIdconcepto(Integer idconcepto) {
		this.idconcepto = idconcepto;
	}

	@Column(name = "descripcion", length = 45)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "user", length = 45)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datareg", length = 19)
	public Date getDatareg() {
		return this.datareg;
	}

	public void setDatareg(Date datareg) {
		this.datareg = datareg;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "concepto")
	public Set<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(Set<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}*/

}
