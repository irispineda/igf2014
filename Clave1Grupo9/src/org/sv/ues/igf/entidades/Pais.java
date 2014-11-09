package org.sv.ues.igf.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "pais", catalog = "clave1", schema = "")
@NamedQueries({
		@NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
		@NamedQuery(name = "Pais.findByIdpa", query = "SELECT p FROM pais p WHERE p.idpa = :idpa"),
		@NamedQuery(name = "Pais.findByNombrePais", query = "SELECT p FROM Pais p WHERE p.nombrePais = :nombrePais") })
public class Pais implements Serializable {
	private Short idpa;
	private String nombrePais;

	public Pais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idpais")
	public Short getIdpa() {
		return idpa;
	}

	public void setIdpa(Short idpa) {
		this.idpa = idpa;
	}

	@Basic(optional = false)
	@Column(name = "nombre_pais")
	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

}
