package org.sv.ues.igf.dao;

import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.sv.ues.igf.entidades.Tarjeta;
import org.sv.ues.igf.utilidades.HibernateUtil;


import org.sv.ues.igf.utilidades.*;

public class TarjetaDAO {
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private SessionFactory sessionFactory =hibernateUtil.getSessionFactory();
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

	public void guardaActualiza(Tarjeta tarjeta) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(tarjeta);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	
	public void eliminar(Tarjeta tarjeta) {
		try {
			iniciaOperacion();
			sesion.delete(tarjeta);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}
	public Tarjeta daTargetaByIdTargeta(int id) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Tarjeta.findByIdPro");
		query.setParameter("idTarjeta", id);
		Tarjeta targeta = (Tarjeta) query.uniqueResult();
		sesion.close();
		return targeta;
	}
	
	
	public Tarjeta daTarjetaByNombre(String nombre) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("Tarjeta.findByNombre");
		query.setParameter("nombreTarjeta", nombre);
		Tarjeta depto = (Tarjeta) query.uniqueResult();
		sesion.close();
		return depto;
	}
	
}
