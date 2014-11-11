package org.sv.ues.igf.entidades;

import java.io.Serializable;
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
@Entity
@Table(name = "pais", catalog = "clave1", schema = "")
@NamedQueries({
		@NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
		@NamedQuery(name = "Pais.findByIdpa", query = "SELECT p FROM Pais p WHERE p.idpa = :idpa"),
		@NamedQuery(name = "Pais.findByNombrePais", query = "SELECT p FROM Pais p WHERE p.nombrePais = :nombrePais") })
public class Pais implements java.io.Serializable {
	private Short idpa;
	private String nombrePais;
	
	public Pais() {
	}

	public Pais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idpais", unique = true, nullable = false)
	public Short getIdpa() {
		return idpa;
	}

	public void setIdpa(Short idpa) {
		this.idpa = idpa;
	}

	
	@Column(name = "nombre_pais", length = 35)
	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

}
