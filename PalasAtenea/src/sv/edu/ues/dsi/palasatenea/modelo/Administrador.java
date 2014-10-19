package sv.edu.ues.dsi.palasatenea.modelo;

// Generated 10-18-2014 06:33:11 PM by Hibernate Tools 3.4.0.CR1

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
 * Administrador generated by hbm2java
 */
@Entity
@Table(name = "administrador", catalog = "palasatenea")
public class Administrador implements java.io.Serializable {

	private AdministradorId id;
	private Usuario usuario;
	private Set<Docente> docentes = new HashSet<Docente>(0);
	private Set<Estudiante1> estudiante1s = new HashSet<Estudiante1>(0);

	public Administrador() {
	}

	public Administrador(AdministradorId id, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
	}

	public Administrador(AdministradorId id, Usuario usuario,
			Set<Docente> docentes, Set<Estudiante1> estudiante1s) {
		this.id = id;
		this.usuario = usuario;
		this.docentes = docentes;
		this.estudiante1s = estudiante1s;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "ucarnetusuario", column = @Column(name = "UCARNETUSUARIO", nullable = false, length = 8)),
			@AttributeOverride(name = "acarnet", column = @Column(name = "ACARNET", nullable = false, length = 8)) })
	public AdministradorId getId() {
		return this.id;
	}

	public void setId(AdministradorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UCARNETUSUARIO", nullable = false, insertable = false, updatable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "administrador")
	public Set<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(Set<Docente> docentes) {
		this.docentes = docentes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "administrador")
	public Set<Estudiante1> getEstudiante1s() {
		return this.estudiante1s;
	}

	public void setEstudiante1s(Set<Estudiante1> estudiante1s) {
		this.estudiante1s = estudiante1s;
	}

}