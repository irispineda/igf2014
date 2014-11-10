package org.sv.ues.igf.entidades;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name = "usuarios", catalog = "clave1")
@NamedQueries({
	@NamedQuery(name = "Usuarios.findByAll", query = "SELECT u FROM Usuarios u "),
	@NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE id = :id"),
	@NamedQuery(name = "Usuarios.findByUsuarioPassword", query = "SELECT u FROM Usuarios u WHERE usuario = :usuario AND password = :pass")
})
public class Usuarios implements java.io.Serializable {

	private Integer id;
	private String usuario;
	private String password;
	private String name;
	private String role;
	private String user;
	private Date datareg;

	public Usuarios() {
	}

	public Usuarios(String usuario, String password, String name, String role) {
		this.usuario = usuario;
		this.password = password;
		this.name = name;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "usuario", nullable = false, length = 100)
	public String getUsuario() {
		return this.usuario;
	}

	public void setusuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.rol = role;
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
}