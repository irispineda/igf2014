package org.sv.ues.igf.entidades;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "clientetarjeta", catalog = "clave1", schema = "")
@NamedQueries({
	@NamedQuery(name = "ClienteTargeta.findByIdPro", query = "SELECT d FROM ClienteTargeta d WHERE d.idCliente = :idCliente"),

	@NamedQuery(name = "ClienteTargeta.findByNombre", query = "SELECT d FROM ClienteTargeta d WHERE d.Fecha_Emision = :Fecha_Emision") 
})

public class ClienteTargeta implements Serializable {
	private static final long serialVersionUID = 1L;






	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtarjetacredito")
	private int idTarjeta;

	@Column(name = "idcliente")
	private int idCliente;
	@Column(name = "fecha_emision")
	private Date Fecha_Emision; 
	@Column(name= "puntos_tarjeta")
	private BigDecimal Puntos_targeta;
	@Column(name = "limite_credito")
	private BigDecimal Limite_credito;

	



	public ClienteTargeta() {
		
	}

	public ClienteTargeta( int idCliente, Date Fecha_Emision ,BigDecimal Puntos_targeta, BigDecimal Limite_credito) {
		super();
		this.idCliente= idCliente;
		
		this.Fecha_Emision= Fecha_Emision;
		this.Limite_credito=Limite_credito;
		this.Puntos_targeta=Puntos_targeta;
		
	}





	public int getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFecha_Emision() {
		return Fecha_Emision;
	}
	public void setFecha_Emision(Date fecha_Emision) {
		Fecha_Emision = fecha_Emision;
	}
	public BigDecimal getLimite_credito() {
		return Limite_credito;
	}
	public void setLimite_credito(BigDecimal limite_credito) {
		Limite_credito = limite_credito;
	}
	public BigDecimal getPuntos_credito() {
		return Puntos_targeta;
	}
	public void setPuntos_credito(BigDecimal puntos_targeta) {
		Puntos_targeta = puntos_targeta;
	}




}
