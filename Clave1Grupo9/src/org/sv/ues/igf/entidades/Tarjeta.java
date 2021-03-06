package org.sv.ues.igf.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.*;

@Entity
@Table(name = "tarjetacredito", catalog = "clave1", schema = "")
@NamedQueries({
	@NamedQuery(name = "Tarjeta.findByIdPro", query = "SELECT d FROM Tarjeta d WHERE d.idTarjeta = :idTarjeta"),

	@NamedQuery(name = "Tarjeta.findByNombre", query = "SELECT d FROM Tarjeta d WHERE d.nombreTarjeta = :nombreTarjeta") 
})

public class Tarjeta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
	
	
	
	public Tarjeta() {
		
	}
	
	public Tarjeta(String nombreTarjeta, BigDecimal limiteMinimo,
			BigDecimal limiteMaximo,String Nombre_emisor, Date fechaIngreso, BigDecimal tasaInteres) {
		super();
		this.nombreTarjeta = nombreTarjeta;
		this.limiteMinimo = limiteMinimo;
		this.limiteMaximo = limiteMaximo;
		this.Nombre_emisor=Nombre_emisor;
		this.fechaIngreso = fechaIngreso;
		this.tasaInteres = tasaInteres;
	}
	
	
	/*@OneToMany(mappedBy="tarjetacredito",cascade= CascadeType.ALL)
	    private Set<ClienteTargeta> clientetargeta;
	*/
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "idtarjetacredito")
	private int idTarjeta;
	public int getIdTarjeta() {
		return idTarjeta;
	}
	
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	
	
	
	
	@Column(name = "nombre_tarjeta", length = 35)
	private String nombreTarjeta;
	public String getNombreTarjeta() {
		return nombreTarjeta;
	}
	

	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}
	
	
	
	@Column(name = "limite_credito_min", length = 35)
	private BigDecimal limiteMinimo;
	
	public BigDecimal getLimiteMinimo() {
		return limiteMinimo;
	}
	public void setLimiteMinimo(BigDecimal limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}
	
	
	
	@Column(name = "limite_credito_max", length = 35)
	private BigDecimal limiteMaximo;
	
	public BigDecimal getLimiteMaximo() {
		return limiteMaximo;
	}
	public void setLimiteMaximo(BigDecimal limiteMaximo) {
		this.limiteMaximo = limiteMaximo;
	}
	
	@Column(name= "nombre_emisor", length = 35)
	private String Nombre_emisor;
	
	public String getNombre_emisor() {
		return Nombre_emisor;
	}

	public void setNombre_emisor(String nombre_emisor) {
		Nombre_emisor = nombre_emisor;
	}
	
@Column(name = "fecha_ingreso", length = 35)
	
	private Date fechaIngreso;
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
	@Column(name = "tasa_interes", length = 35)
	private BigDecimal tasaInteres;
	
	
	public BigDecimal getTasaInteres() {
		return tasaInteres;
	}
	public void setTasaInteres(BigDecimal tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "targetacredito")
	public Set<ClienteTargeta> getClientestargeta() {
		return this.clientetargeta;
	}

	public void setClientestargeta(Set<ClienteTargeta> clientetargeta) {
		this.clientetargeta = clientetargeta;
	}*/

	
}
