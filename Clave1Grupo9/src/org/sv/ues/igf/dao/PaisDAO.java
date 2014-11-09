package org.sv.ues.igf.dao;
import org.hibernate.*;

import java.util.*;



import org.sv.ues.igf.entidades.Pais;
import org.sv.ues.igf.utilidades.HibernateUtil;


public class PaisDAO{
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private SessionFactory sessionFactory = hibernateUtil.getSf();
	private Session sesion;
	private Transaction tx;
	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he)
			throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}
	
	public void guardaActualiza(Pais pais) {//aqui viene de controlador y no guarda
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(pais);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(Pais pais) {
		try {
			iniciaOperacion();
			sesion.delete(pais);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Pais daPaisById(short id) {
		sesion = sessionFactory.openSession();
		// Retorna la instancia persistente de la clase por medio del atributo
		// identidad
		Pais idpa = (Pais) sesion.get(Pais.class,new Short(id)) ;
		sesion.close() ;
		return idpa ;
	}
	
	public Pais daPaisByIdPa(Short id) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Pais.findByIdpa");
		query.setParameter("idpa", id);
		Pais pais = (Pais) query.uniqueResult();
		sesion.close();
		return pais;
	}
	public List<Pais> daPais() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Pais.findAll");
		List<Pais> pais = query.list();
		sesion.close();
		return pais;
	}

	public Pais daPaisByNombre(String nombre) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Pais.findByNombrePais");
		query.setParameter("nombrePais", nombre);
		Pais pais = (Pais) query.uniqueResult();
		sesion.close();
		return pais;
	}

}
