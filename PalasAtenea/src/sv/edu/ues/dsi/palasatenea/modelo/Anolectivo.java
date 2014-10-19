package sv.edu.ues.dsi.palasatenea.modelo;

// Generated 10-18-2014 06:33:11 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Anolectivo generated by hbm2java
 */
@Entity
@Table(name = "anolectivo", catalog = "palasatenea")
public class Anolectivo implements java.io.Serializable {

	private String acodano;
	private boolean aactivo;
	private Date aanoinicio;
	private Date aanofinal;
	private String adescrcipcion;
	private Set<Estudiante1> estudiante1s = new HashSet<Estudiante1>(0);
	private Set<Materia> materias = new HashSet<Materia>(0);

	public Anolectivo() {
	}

	public Anolectivo(String acodano, boolean aactivo, Date aanoinicio,
			Date aanofinal, String adescrcipcion) {
		this.acodano = acodano;
		this.aactivo = aactivo;
		this.aanoinicio = aanoinicio;
		this.aanofinal = aanofinal;
		this.adescrcipcion = adescrcipcion;
	}

	public Anolectivo(String acodano, boolean aactivo, Date aanoinicio,
			Date aanofinal, String adescrcipcion,
			Set<Estudiante1> estudiante1s, Set<Materia> materias) {
		this.acodano = acodano;
		this.aactivo = aactivo;
		this.aanoinicio = aanoinicio;
		this.aanofinal = aanofinal;
		this.adescrcipcion = adescrcipcion;
		this.estudiante1s = estudiante1s;
		this.materias = materias;
	}

	@Id
	@Column(name = "ACODANO", unique = true, nullable = false, length = 8)
	public String getAcodano() {
		return this.acodano;
	}

	public void setAcodano(String acodano) {
		this.acodano = acodano;
	}

	@Column(name = "AACTIVO", nullable = false)
	public boolean isAactivo() {
		return this.aactivo;
	}

	public void setAactivo(boolean aactivo) {
		this.aactivo = aactivo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AANOINICIO", nullable = false, length = 10)
	public Date getAanoinicio() {
		return this.aanoinicio;
	}

	public void setAanoinicio(Date aanoinicio) {
		this.aanoinicio = aanoinicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AANOFINAL", nullable = false, length = 10)
	public Date getAanofinal() {
		return this.aanofinal;
	}

	public void setAanofinal(Date aanofinal) {
		this.aanofinal = aanofinal;
	}

	@Column(name = "ADESCRCIPCION", nullable = false, length = 100)
	public String getAdescrcipcion() {
		return this.adescrcipcion;
	}

	public void setAdescrcipcion(String adescrcipcion) {
		this.adescrcipcion = adescrcipcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "anolectivo")
	public Set<Estudiante1> getEstudiante1s() {
		return this.estudiante1s;
	}

	public void setEstudiante1s(Set<Estudiante1> estudiante1s) {
		this.estudiante1s = estudiante1s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "anolectivo")
	public Set<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}

}