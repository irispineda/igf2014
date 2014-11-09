package org.sv.ues.igf.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tarjetacredito", catalog = "clave1", schema = "")
@NamedQueries({
	@NamedQuery(name = "Tarjeta.findByIdPro", query = "SELECT d FROM Tarjeta d WHERE d.idTarjeta = :idTarjeta"),

	@NamedQuery(name = "Tarjeta.findByNombre", query = "SELECT d FROM Tarjeta d WHERE d.nombreTarjeta = :nombreTarjeta") 
})

public class Tarjeta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtarjetacredito")
	private int idTarjeta;
	@Column(name = "nombre_tarjeta")
	private String nombreTarjeta;
	@Column(name = "limite_credito_min")
	private BigDecimal limiteMinimo;
	@Column(name = "limite_credito_max")
	private BigDecimal limiteMaximo;
	@Column(name= "nombre_emisor")
	private String Nombre_emisor;
	
	@Column(name = "fecha_ingreso")
	
	private Date fechaIngreso;
	@Column(name = "tasa_interes")
	private BigDecimal tasaInteres;
	
	private Tarjeta() {
		
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
	public String getNombre_emisor() {
		return Nombre_emisor;
	}

	public void setNombre_emisor(String nombre_emisor) {
		Nombre_emisor = nombre_emisor;
	}
	public int getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public String getNombreTarjeta() {
		return nombreTarjeta;
	}
	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}
	public BigDecimal getLimiteMinimo() {
		return limiteMinimo;
	}
	public void setLimiteMinimo(BigDecimal limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}
	public BigDecimal getLimiteMaximo() {
		return limiteMaximo;
	}
	public void setLimiteMaximo(BigDecimal limiteMaximo) {
		this.limiteMaximo = limiteMaximo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public BigDecimal getTasaInteres() {
		return tasaInteres;
	}
	public void setTasaInteres(BigDecimal tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	
	
	
}
