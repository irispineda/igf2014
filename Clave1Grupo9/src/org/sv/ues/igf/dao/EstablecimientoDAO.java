package org.sv.ues.igf.dao;

import org.hibernate.*;
import org.sv.ues.igf.utilidades.HibernateUtil;

import org.sv.ues.igf.entidades.*;

import java.util.*;
public class EstablecimientoDAO {
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
	
	public void guardaActualiza(Establecimiento establecimiento) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(establecimiento);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public void eliminar(Establecimiento establecimiento) {
		try {
			iniciaOperacion();
			sesion.delete(establecimiento);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	public Establecimiento daEstablecimientoById(String id){
		sesion = sessionFactory.openSession() ;
		// Retorna la instancia persistente de la clase por medio del atributo identidad
		Establecimiento idest = (Establecimiento) sesion.get(Establecimiento.class,new String(id)) ;
		sesion.close() ;
		return idest ;
		}
	public Establecimiento daEstablecimientoByNumRef(String id) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Establecimiento.findByNumReferencia");
		query.setParameter("numReferencia", id);
		Establecimiento establ = (Establecimiento) query.uniqueResult();
		sesion.close();
		return establ;
	}
	public List<Establecimiento> daEstablecimiento() {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Establecimiento.findAll");
		List<Establecimiento> establecimiento = query.list();
		sesion.close();
		return establecimiento;
	}

	public Establecimiento daEstablecimientoByNombre(String nombre) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Establecimiento.findByEstablecimiento");
		query.setParameter("establecimiento", nombre);
		Establecimiento establecimiento = (Establecimiento) query.uniqueResult();
		sesion.close();
		return establecimiento;
	}

}
