package org.sv.ues.igf.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sv.ues.igf.entidades.Clientetarjeta;
import org.sv.ues.igf.utilidades.HibernateUtil;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;





public class ClienteTargetaDAO {
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

	public void guardaActualiza(Clientetarjeta cliente) {
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(cliente);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	
	public void eliminar(Clientetarjeta cliente) {
		try {
			iniciaOperacion();
			sesion.delete(cliente);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
	}

	public Clientetarjeta daclienteByIdPro(int id) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("ClienteTargeta.findByIdPro");
		query.setParameter("idcliente", id);
		Clientetarjeta cliente = (Clientetarjeta) query.uniqueResult();
		sesion.close();
		return cliente;
	}
	public Clientetarjeta daClienteTargetaById(int idtarjetacredito, int idcliente){
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Clientetarjeta.findByID");
		query.setParameter("id_cliente", idcliente);
		query.setParameter("id_tarjeta", idtarjetacredito);
		Clientetarjeta ct = (Clientetarjeta) query.uniqueResult();
		sesion.close() ;
		return null ;
		}
	
	public Clientetarjeta daClienteTargetaByNombre(Date nombre) {
		sesion = sessionFactory.openSession();
		Query query = sesion.getNamedQuery("ClienteTar.findByNombre");
		query.setParameter("Fecha_Emision", nombre);
		Clientetarjeta targeta = (Clientetarjeta) query.uniqueResult();
		sesion.close();
		return targeta;
	}
}
