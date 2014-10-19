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
 * Padrefamilia generated by hbm2java
 */
@Entity
@Table(name = "padrefamilia", catalog = "palasatenea")
public class Padrefamilia implements java.io.Serializable {

	private PadrefamiliaId id;
	private Usuario usuario;
	private String panombrepa;
	private String paapellidopa;
	private String panumcelpa;
	private String pacorreopa;
	private String palugartrabapa;
	private String padirecctrabapa;
	private String pateltrabapa;
	private String paextteltrabapa;
	private String panombrema;
	private String paapellidosma;
	private String panumcelma;
	private String pacorreoma;
	private String palugartrabama;
	private String padirecciontrabama;
	private String pateltrabama;
	private String paexttelma;
	private Set<Estudiante1> estudiante1s = new HashSet<Estudiante1>(0);

	public Padrefamilia() {
	}

	public Padrefamilia(PadrefamiliaId id, Usuario usuario, String panombrepa,
			String paapellidopa, String panumcelpa, String pacorreopa,
			String palugartrabapa, String padirecctrabapa, String pateltrabapa,
			String paextteltrabapa, String panombrema, String paapellidosma,
			String panumcelma, String pacorreoma, String palugartrabama,
			String padirecciontrabama, String pateltrabama, String paexttelma) {
		this.id = id;
		this.usuario = usuario;
		this.panombrepa = panombrepa;
		this.paapellidopa = paapellidopa;
		this.panumcelpa = panumcelpa;
		this.pacorreopa = pacorreopa;
		this.palugartrabapa = palugartrabapa;
		this.padirecctrabapa = padirecctrabapa;
		this.pateltrabapa = pateltrabapa;
		this.paextteltrabapa = paextteltrabapa;
		this.panombrema = panombrema;
		this.paapellidosma = paapellidosma;
		this.panumcelma = panumcelma;
		this.pacorreoma = pacorreoma;
		this.palugartrabama = palugartrabama;
		this.padirecciontrabama = padirecciontrabama;
		this.pateltrabama = pateltrabama;
		this.paexttelma = paexttelma;
	}

	public Padrefamilia(PadrefamiliaId id, Usuario usuario, String panombrepa,
			String paapellidopa, String panumcelpa, String pacorreopa,
			String palugartrabapa, String padirecctrabapa, String pateltrabapa,
			String paextteltrabapa, String panombrema, String paapellidosma,
			String panumcelma, String pacorreoma, String palugartrabama,
			String padirecciontrabama, String pateltrabama, String paexttelma,
			Set<Estudiante1> estudiante1s) {
		this.id = id;
		this.usuario = usuario;
		this.panombrepa = panombrepa;
		this.paapellidopa = paapellidopa;
		this.panumcelpa = panumcelpa;
		this.pacorreopa = pacorreopa;
		this.palugartrabapa = palugartrabapa;
		this.padirecctrabapa = padirecctrabapa;
		this.pateltrabapa = pateltrabapa;
		this.paextteltrabapa = paextteltrabapa;
		this.panombrema = panombrema;
		this.paapellidosma = paapellidosma;
		this.panumcelma = panumcelma;
		this.pacorreoma = pacorreoma;
		this.palugartrabama = palugartrabama;
		this.padirecciontrabama = padirecciontrabama;
		this.pateltrabama = pateltrabama;
		this.paexttelma = paexttelma;
		this.estudiante1s = estudiante1s;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "ucarnetusuario", column = @Column(name = "UCARNETUSUARIO", nullable = false, length = 8)),
			@AttributeOverride(name = "pacarnetpa", column = @Column(name = "PACARNETPA", nullable = false, length = 8)) })
	public PadrefamiliaId getId() {
		return this.id;
	}

	public void setId(PadrefamiliaId id) {
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

	@Column(name = "PANOMBREPA", nullable = false, length = 25)
	public String getPanombrepa() {
		return this.panombrepa;
	}

	public void setPanombrepa(String panombrepa) {
		this.panombrepa = panombrepa;
	}

	@Column(name = "PAAPELLIDOPA", nullable = false, length = 25)
	public String getPaapellidopa() {
		return this.paapellidopa;
	}

	public void setPaapellidopa(String paapellidopa) {
		this.paapellidopa = paapellidopa;
	}

	@Column(name = "PANUMCELPA", nullable = false, length = 8)
	public String getPanumcelpa() {
		return this.panumcelpa;
	}

	public void setPanumcelpa(String panumcelpa) {
		this.panumcelpa = panumcelpa;
	}

	@Column(name = "PACORREOPA", nullable = false, length = 50)
	public String getPacorreopa() {
		return this.pacorreopa;
	}

	public void setPacorreopa(String pacorreopa) {
		this.pacorreopa = pacorreopa;
	}

	@Column(name = "PALUGARTRABAPA", nullable = false, length = 50)
	public String getPalugartrabapa() {
		return this.palugartrabapa;
	}

	public void setPalugartrabapa(String palugartrabapa) {
		this.palugartrabapa = palugartrabapa;
	}

	@Column(name = "PADIRECCTRABAPA", nullable = false, length = 50)
	public String getPadirecctrabapa() {
		return this.padirecctrabapa;
	}

	public void setPadirecctrabapa(String padirecctrabapa) {
		this.padirecctrabapa = padirecctrabapa;
	}

	@Column(name = "PATELTRABAPA", nullable = false, length = 8)
	public String getPateltrabapa() {
		return this.pateltrabapa;
	}

	public void setPateltrabapa(String pateltrabapa) {
		this.pateltrabapa = pateltrabapa;
	}

	@Column(name = "PAEXTTELTRABAPA", nullable = false, length = 8)
	public String getPaextteltrabapa() {
		return this.paextteltrabapa;
	}

	public void setPaextteltrabapa(String paextteltrabapa) {
		this.paextteltrabapa = paextteltrabapa;
	}

	@Column(name = "PANOMBREMA", nullable = false, length = 25)
	public String getPanombrema() {
		return this.panombrema;
	}

	public void setPanombrema(String panombrema) {
		this.panombrema = panombrema;
	}

	@Column(name = "PAAPELLIDOSMA", nullable = false, length = 25)
	public String getPaapellidosma() {
		return this.paapellidosma;
	}

	public void setPaapellidosma(String paapellidosma) {
		this.paapellidosma = paapellidosma;
	}

	@Column(name = "PANUMCELMA", nullable = false, length = 50)
	public String getPanumcelma() {
		return this.panumcelma;
	}

	public void setPanumcelma(String panumcelma) {
		this.panumcelma = panumcelma;
	}

	@Column(name = "PACORREOMA", nullable = false, length = 8)
	public String getPacorreoma() {
		return this.pacorreoma;
	}

	public void setPacorreoma(String pacorreoma) {
		this.pacorreoma = pacorreoma;
	}

	@Column(name = "PALUGARTRABAMA", nullable = false, length = 50)
	public String getPalugartrabama() {
		return this.palugartrabama;
	}

	public void setPalugartrabama(String palugartrabama) {
		this.palugartrabama = palugartrabama;
	}

	@Column(name = "PADIRECCIONTRABAMA", nullable = false, length = 50)
	public String getPadirecciontrabama() {
		return this.padirecciontrabama;
	}

	public void setPadirecciontrabama(String padirecciontrabama) {
		this.padirecciontrabama = padirecciontrabama;
	}

	@Column(name = "PATELTRABAMA", nullable = false, length = 8)
	public String getPateltrabama() {
		return this.pateltrabama;
	}

	public void setPateltrabama(String pateltrabama) {
		this.pateltrabama = pateltrabama;
	}

	@Column(name = "PAEXTTELMA", nullable = false, length = 8)
	public String getPaexttelma() {
		return this.paexttelma;
	}

	public void setPaexttelma(String paexttelma) {
		this.paexttelma = paexttelma;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "padrefamilia")
	public Set<Estudiante1> getEstudiante1s() {
		return this.estudiante1s;
	}

	public void setEstudiante1s(Set<Estudiante1> estudiante1s) {
		this.estudiante1s = estudiante1s;
	}

}